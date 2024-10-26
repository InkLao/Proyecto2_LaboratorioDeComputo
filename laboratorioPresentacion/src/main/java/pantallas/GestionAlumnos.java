/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import NegocioException.NegocioException;
import dto.AlumnoDTO;
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
import negocio.ICarreraNegocio;
import negocio.IUnidadNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Oley
 */
public class GestionAlumnos extends javax.swing.JFrame {
    
    private Administrador administrador;
    private ICarreraNegocio carreraNegocio;
    private IUnidadNegocio unidadNegocio;
    private IAlumnoNegocio alumnoNegocio;

    /**
     * Creates new form GestionAlumnos
     */
    public GestionAlumnos(Administrador administrador, IAlumnoNegocio alumnoNegocio,ICarreraNegocio carreraNegocio) {
        this.alumnoNegocio=alumnoNegocio;
        this.carreraNegocio=carreraNegocio;
        this.administrador = administrador;
        initComponents();
                cargarMetodosIniciales();

    }
 private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaBloqueos();
        this.cargarBloqueosEnTabla();

    }
    
    
    
    private void editarBloqueoTabla(AlumnoDTO bloqueo) {
      try {
        System.out.println(bloqueo.toString() + " editar alumno id");
        
        // Actualiza el alumno
        AlumnoDTO bloqueoActualizado = alumnoNegocio.actualizarAlumnos(bloqueo);
        
        // Muestra información en consola
        System.out.println(bloqueoActualizado.getId());
        
        // Mensaje de éxito
        JOptionPane.showMessageDialog(this, "Bloqueo editado exitosamente");
        
        // Recarga la tabla
        this.cargarBloqueosEnTabla();
        
        System.out.println(bloqueoActualizado.getId() + " actualizado");
    }catch (Exception ex) {
        // Manejo de cualquier otra excepción
        JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }   
        // Manejo de excepciones
           

    }
    
    private void eliminarBloqueoTabla(AlumnoDTO bloqueo) {
//        try {
            this.alumnoNegocio.eliminarAlumnos(bloqueo);
            JOptionPane.showMessageDialog(this, "Bloqueo Eliminado");
            this.cargarBloqueosEnTabla();
            
        } 
        
//        catch (NegocioException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
//        }

    
    
    private void cargarConfiguracionInicialTablaBloqueos() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                editar();

            }
        };

        int indiceColumnaEditar = 5;
        TableColumnModel modeloColumnas = this.tblAlumnos.getColumnModel();
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
        modeloColumnas = this.tblAlumnos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar",
                        onEliminarClickListener));

    }

    private long getIdSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 0;
            long idBloqueoSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idBloqueoSeleccionado;
        } else {
            return 0;
        }
    }

    
    private boolean getEliminadoSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 4;
            boolean eliminadoBloqueoSeleccionado = (boolean) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return eliminadoBloqueoSeleccionado;
        } else {
            return false;
        }
    }
    
    private String getMotivoSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblAlumnos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblAlumnos.getModel();
            int indiceColumnaId = 1;
            String motivoBloqueoSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return motivoBloqueoSeleccionado;
        } else {
            return null;
        }
    }    


    private void editar() {
           AlumnoDTO bloqueo = alumnoNegocio.obtenerPorId(getIdSeleccionadoTablaBloqueo());
    
    if (bloqueo != null) {
        bloqueo.setApellidoMaterno(getMotivoSeleccionadoTablaBloqueo());
        editarBloqueoTabla(bloqueo);
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el alumno seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
    }
        }
        
        
   

    private void eliminar() throws NegocioException {
        //Metodo para regresar el beneficiario seleccionado
        
        AlumnoDTO eliminado = new AlumnoDTO();
        
        eliminado = alumnoNegocio.obtenerPorId(getIdSeleccionadoTablaBloqueo());

        System.out.println("Preparando el id: " + eliminado.getId() + " para borrar");
        
        eliminado.setEstaEliminado(true);
        
        eliminarBloqueoTabla(eliminado);
        cargarBloqueosEnTabla();

    }

    private void llenarTablaBloqueos(List<AlumnoDTO> bloqueosLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAlumnos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (bloqueosLista != null) {
            bloqueosLista.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row.getId();
                fila[1] = row.getNombres();
                fila[2] = row.getApellidoPaterno();
                fila[3] = row.getApellidoMaterno();
                fila[4] = row.isEstaEliminado();
                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarBloqueosEnTabla() {
            List<AlumnoDTO> bloqueos = this.alumnoNegocio.buscarAlumnosTabla();
            this.llenarTablaBloqueos(bloqueos);
       
    }    
    
    
    private void cargarBloqueosEnTablaPorMotivo(String motivo) {
        System.out.println(motivo);
        List<AlumnoDTO> bloqueos = this.alumnoNegocio.buscarAlumnosTabla(motivo);
        if(bloqueos.size() > 0){
            
            this.llenarTablaBloqueos(bloqueos);
            
        }
        
        else{
            JOptionPane.showMessageDialog(this, "No se encontraron registros con los datos especificados, se mostraran todos los datos", "Informacion", JOptionPane.ERROR_MESSAGE);
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestion Alumnos");

        jButton1.setText("Buscar");

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idAlumno", "Nombre", "ApellidoP", "ApellidoM", "Estatus", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblAlumnos);

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(jButton2)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

this.setVisible(false);
administrador.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.setVisible(false);
AgregarAlumno agregarAlumno=new AgregarAlumno(this, alumnoNegocio, carreraNegocio);
agregarAlumno.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables
}
