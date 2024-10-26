/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import NegocioException.NegocioException;
import dto.BloqueoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.IAlumnoNegocio;
import negocio.IBloqueoNegocio;
import negocio.ICarreraNegocio;
import negocio.IUnidadNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Oley
 */
public class GestionBloqueos extends javax.swing.JFrame {
    
    private Administrador administrador;
    private ICarreraNegocio carreraNegocio;
    private IUnidadNegocio unidadNegocio;
    private IAlumnoNegocio alumnoNegocio;
    private IBloqueoNegocio bloqueoNegocio;

    /**
     * Creates new form GestionBloqueos
     */
    public GestionBloqueos(Administrador administrador, IBloqueoNegocio bloqueoNegocio, IAlumnoNegocio alumnoNegocio) {
        
        this.administrador = administrador;
        this.bloqueoNegocio = bloqueoNegocio;
        this.alumnoNegocio = alumnoNegocio;
                
        initComponents();
        
        cargarMetodosIniciales();

    }

    
    private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaBloqueos();
        this.cargarBloqueosEnTabla();

    }
    
    
    
    private void editarBloqueoTabla(BloqueoDTO bloqueo) {
        try {
            System.out.println(bloqueo.toString() + "editar bloqueo id");
            BloqueoDTO bloqueoActualizado = bloqueoNegocio.actualizarBloqueo(bloqueo);
            System.out.println(bloqueoActualizado.getId());
            JOptionPane.showMessageDialog(this, "Bloqueo editado");
            this.cargarBloqueosEnTabla();
            System.out.println(bloqueoActualizado.getId() + "22");

            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void eliminarBloqueoTabla(BloqueoDTO bloqueo) {
        try {
            this.bloqueoNegocio.eliminarBloqueo(bloqueo);
            JOptionPane.showMessageDialog(this, "Bloqueo Eliminado");
            this.cargarBloqueosEnTabla();
            
        } 
        
        catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void cargarConfiguracionInicialTablaBloqueos() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                editar();

            }
        };

        int indiceColumnaEditar = 5;
        TableColumnModel modeloColumnas = this.tblBloqueos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar",
                        onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnaId = 0;

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
        int indiceColumnaEliminar = 6;
        modeloColumnas = this.tblBloqueos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar",
                        onEliminarClickListener));

    }

    private long getIdSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblBloqueos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBloqueos.getModel();
            int indiceColumnaId = 0;
            long idBloqueoSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idBloqueoSeleccionado;
        } else {
            return 0;
        }
    }

    
    private boolean getEliminadoSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblBloqueos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBloqueos.getModel();
            int indiceColumnaId = 4;
            boolean eliminadoBloqueoSeleccionado = (boolean) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return eliminadoBloqueoSeleccionado;
        } else {
            return false;
        }
    }
    
    private String getMotivoSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblBloqueos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBloqueos.getModel();
            int indiceColumnaId = 1;
            String motivoBloqueoSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return motivoBloqueoSeleccionado;
        } else {
            return null;
        }
    }    


    private void editar() {
        //Metodo para regresar el alumno seleccionado

        try{

        BloqueoDTO bloqueo = new BloqueoDTO();

        bloqueo = bloqueoNegocio.obtenerPorId(getIdSeleccionadoTablaBloqueo());

        System.out.println(bloqueo.getId() + " si busco");
        bloqueo.setMotivo(getMotivoSeleccionadoTablaBloqueo());
        editarBloqueoTabla(bloqueo);
        
        cargarBloqueosEnTabla();
        }
        
        catch(NegocioException e ){
            e.printStackTrace();
        }
    }

    private void eliminar() throws NegocioException {
        //Metodo para regresar el beneficiario seleccionado
        
        BloqueoDTO eliminado = new BloqueoDTO();
        
        eliminado = bloqueoNegocio.obtenerPorId(getIdSeleccionadoTablaBloqueo());

        System.out.println("Preparando el id: " + eliminado.getId() + " para borrar");
        
        eliminado.setEliminado(true);
        
        eliminarBloqueoTabla(eliminado);
        cargarBloqueosEnTabla();

    }

    private void llenarTablaBloqueos(List<BloqueoDTO> bloqueosLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBloqueos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (bloqueosLista != null) {
            bloqueosLista.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row.getId();
                fila[1] = row.getMotivo();
                fila[2] = row.getFechaBloqueo().getTime().toString();
                fila[3] = row.getFechaLiberacion().getTime().toString();
                fila[4] = row.isEliminado();
                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarBloqueosEnTabla() {
        try {
            List<BloqueoDTO> bloqueos = this.bloqueoNegocio.buscarBloqueosTabla();
            this.llenarTablaBloqueos(bloqueos);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
    private void cargarBloqueosEnTablaPorMotivo(String motivo) {
        try {
            
            System.out.println(motivo);
            List<BloqueoDTO> bloqueos = this.bloqueoNegocio.buscarBloqueosTabla(motivo);
            
            if(bloqueos.size() > 0){
            
            this.llenarTablaBloqueos(bloqueos);
            
            }
            
            else{
               JOptionPane.showMessageDialog(this, "No se encontraron registros con los datos especificados, se mostraran todos los datos", "Informacion", JOptionPane.ERROR_MESSAGE); 
                cargarBloqueosEnTabla();
            }
            
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            cargarBloqueosEnTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBloqueos = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestion Bloqueos");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblBloqueos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idBloqueo", "Motivo", "Fecha Bloqueo", "Fecha Liberacion", "Eliminado", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBloqueos);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnBuscar))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnAgregar))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnRegresar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(7, 7, 7)
                .addComponent(btnAgregar)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnRegresar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.setVisible(false);
        administrador.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(false);
        AgregarBloqueo agregarBloqueo=new AgregarBloqueo(this, alumnoNegocio, bloqueoNegocio, alumnoNegocio);
        agregarBloqueo.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
        this.cargarBloqueosEnTablaPorMotivo(txtBuscar.getText());
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBloqueos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
