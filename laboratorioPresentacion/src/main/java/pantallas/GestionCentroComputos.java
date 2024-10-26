/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dto.CentroComputoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
 * Aqui se muestran todos los centros de cómputo asignados a cada unidad académica, 
 * con la opción de agregar, editar y elminar
 * @author eduar
 */
public class GestionCentroComputos extends javax.swing.JFrame {

    private ICarreraNegocio carreraNegocio;
    private IUnidadNegocio unidadNegocio;
    private IAlumnoNegocio alumnoNegocio;

    private ICentroComputoNegocio centroComputoNegocio;

    public GestionCentroComputos(Administrador administrador, ICentroComputoNegocio centroComputoNegocio) {
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

        int indiceColumnaEditar = 5;
        TableColumnModel modeloColumnas = this.tblCentroComputo.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar).setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar).setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        };
        int indiceColumnaEliminar = 6;
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void cargarCentrosEnTabla() {
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
                centro.getNombre(),
                centro.getHoraInicio().getTime().toString(),
                centro.getHoraFinal().getTime().toString(),
                centro.getContraseñaMaestra(),
                "Editar",
                "Eliminar"
            });
        }
    }

    private void editar() {
        int filaSeleccionada = tblCentroComputo.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un centro para editar.");
            return;
        }

        Long idCentro = (Long) tblCentroComputo.getValueAt(filaSeleccionada, 0);
        String nombre = (String) tblCentroComputo.getValueAt(filaSeleccionada, 1);
        String horaInicio = (String) tblCentroComputo.getValueAt(filaSeleccionada, 2);
        String horaFinal = (String) tblCentroComputo.getValueAt(filaSeleccionada, 3);
        String contraseña = (String) tblCentroComputo.getValueAt(filaSeleccionada, 4);

        // Convertir las horas de inicio y final en formato de tiempo
        CentroComputoDTO centroEditado = new CentroComputoDTO();
        centroEditado.setId(idCentro);
        centroEditado.setNombre(nombre);
        // Conversión de horaInicio y horaFinal desde String a Calendar, por ejemplo.
        // centroEditado.setHoraInicio(...); // Convierte y asigna el valor de horaInicio
        // centroEditado.setHoraFinal(...);   // Convierte y asigna el valor de horaFinal
        centroEditado.setContraseñaMaestra(contraseña);

        // Guardar cambios
        try {
            centroComputoNegocio.editarCentroComputo(centroEditado);
            JOptionPane.showMessageDialog(this, "Centro de cómputo editado con éxito.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al editar el centro de cómputo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        cargarCentrosEnTabla(); // Recargar la tabla
    }

    private void eliminar() {
        int filaSeleccionada = tblCentroComputo.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un centro para eliminar.");
            return;
        }

        Long idCentro = (Long) tblCentroComputo.getValueAt(filaSeleccionada, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este centro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                centroComputoNegocio.eliminarCentroComputo(idCentro);
                JOptionPane.showMessageDialog(this, "Centro de cómputo eliminado con éxito.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el centro de cómputo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            cargarCentrosEnTabla(); // Recargar la tabla
        }
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idCentro", "Nombre", "Hora Inicio", "Hora Final", "Contraseña maestra", "Editar", "Eliminar"
            }
        ));
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
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar)
                            .addComponent(btnRegresar))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(false);
        AgregarCentroComputos agregarCentroComputos = new AgregarCentroComputos();
        agregarCentroComputos.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.setVisible(false);
        //Administrador administrador = new Administrador(carreraNegocio, unidadNegocio, alumnoNegocio);
//        administrador.setVisible(true);

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
