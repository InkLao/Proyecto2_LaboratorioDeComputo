/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.IAlumnoNegocio;
import negocio.ICarreraNegocio;
import negocio.ICentroComputoNegocio;
import negocio.IUnidadNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 * Aqui se muestran todos los centros de cómputo asignados a cada unidad
 * académica, con la opción de agregar, editar y elminar
 *
 * @author eduar
 */
public class GestionCentroComputos extends javax.swing.JFrame {
    
    private ICarreraNegocio carreraNegocio;
    private IUnidadNegocio unidadNegocio;
    private IAlumnoNegocio alumnoNegocio;
    private Administrador administrador;

    private ICentroComputoNegocio centroComputoNegocio;

    public GestionCentroComputos(IUnidadNegocio unidadNegocio, Administrador administrador, ICentroComputoNegocio centroComputoNegocio) {
        this.unidadNegocio=unidadNegocio;
        this.administrador=administrador;
        this.centroComputoNegocio = centroComputoNegocio;
        initComponents();
        cargarConfiguracionInicialTabla();
        cargarCentrosEnTabla();
    }

    private void cargarConfiguracionInicialTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        };

        int indiceColumnaEditar = 7;
        TableColumnModel modeloColumnas = this.tblCentroComputo.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar).setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar).setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para eliminar un bloqueo
                    eliminar();
                } catch (NegocioException ex) {
                    Logger.getLogger(GestionBloqueos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        int indiceColumnaEliminar = 8;
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    public void cargarCentrosEnTabla() {
        try {
            List<CentroComputoDTO> centros = centroComputoNegocio.obtenerTodosLosCentros();  // Método que lista todos los centros
            llenarTablaCentros(centros);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar centros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarTablaCentros(List<CentroComputoDTO> centros) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCentroComputo.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla

        for (CentroComputoDTO centro : centros) {
            modeloTabla.addRow(new Object[]{
                centro.getId(),
                centro.getUnidadAcademica(),
                centro.getNombre(),
                centro.getHoraInicio().getTime().toString(),
                centro.getHoraFinal().getTime().toString(),
                centro.getContraseñaMaestra(),
                centro.isEliminado(),
                "Editar",
                "Eliminar"
            });
        }
    }

    private void editarCentroComputoTabla(CentroComputoDTO centroComputo) {
        try {
            centroComputo = centroComputoNegocio.buscarCentroComputo(getIdSeleccionadoTablaCentroComputo());
            centroComputo.setNombre(getNombreSeleccionadoTabla());
            System.out.println(centroComputo.toString() + "editar centro id");
            CentroComputoDTO centroActualizado = centroComputoNegocio.actualizarCentroComputo(centroComputo);
            System.out.println(centroActualizado.toString());
            JOptionPane.showMessageDialog(this, "Centro editado");
            this.cargarCentrosEnTabla();
            System.out.println(centroActualizado.getId() + "22");

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String getNombreSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblCentroComputo.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCentroComputo.getModel();
            int indiceColumnaId = 2;
            String nombreSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return nombreSeleccionado;
        } else {
            return null;
        }
    }

    private String getContraseñaMaestraSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblCentroComputo.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCentroComputo.getModel();
            int indiceColumnaId = 5;
            String contraseñaMaestraSeleccionada = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return contraseñaMaestraSeleccionada;
        } else {
            return null;
        }
    }

    private void editar() {
        try {

            CentroComputoDTO centroComputo = new CentroComputoDTO();

            centroComputo = centroComputoNegocio.buscarCentroComputo(getIdSeleccionadoTablaCentroComputo());

            System.out.println(centroComputo.getId() + " si busco");
            centroComputo.setContraseñaMaestra(getContraseñaMaestraSeleccionadoTabla());
            editarCentroComputoTabla(centroComputo);

            cargarCentrosEnTabla();
        } catch (NegocioException e) {
            e.printStackTrace();
        }
    }

    private long getIdSeleccionadoTablaCentroComputo() {
        int indiceFilaSeleccionada = this.tblCentroComputo.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCentroComputo.getModel();
            int indiceColumnaId = 0;
            long idBloqueoSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idBloqueoSeleccionado;
        } else {
            return 0;
        }
    }

    private void eliminarCentroComputoTabla(CentroComputoDTO centroComputo) {
        try {
            this.centroComputoNegocio.eliminarCentroComputo(centroComputo);
            JOptionPane.showMessageDialog(this, "Centro Computo Eliminado");
            this.cargarCentrosEnTabla();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void eliminar() throws NegocioException {
        CentroComputoDTO eliminado = new CentroComputoDTO();

        eliminado = centroComputoNegocio.buscarCentroComputo(getIdSeleccionadoTablaCentroComputo());

        System.out.println("Preparando el id: " + eliminado.getId() + " para borrar");

        eliminado.setEliminado(true);

        eliminarCentroComputoTabla(eliminado);
        cargarCentrosEnTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCentroComputo = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestion Centro de Computos");

        btnBuscar.setText("Buscar");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblCentroComputo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idCentro", "Unidad Academica", "Nombre", "Hora Inicio", "Hora Final", "Contraseña maestra", "Esta Eliminado", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCentroComputo);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(7, 7, 7)
                .addComponent(btnAgregar)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(false);
        AgregarCentroComputos agregarCentroComputos = new AgregarCentroComputos(this, unidadNegocio, centroComputoNegocio);
        agregarCentroComputos.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.setVisible(false);
        administrador.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCentroComputo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
