/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import negocio.IAlumnoNegocio;
import negocio.ICarreraNegocio;
import negocio.IUnidadNegocio;

/**
 *
 * @author Oley
 */
public class GestionComputadoras extends javax.swing.JFrame {
private ICarreraNegocio carreraNegocio;
private IUnidadNegocio unidadNegocio;
private IAlumnoNegocio alumnoNegocio;
private Administrador administrador;

    /**
     * Creates new form GestionComputadoras
     */
    public GestionComputadoras(Administrador administrador) {
        this.administrador = administrador;
        initComponents();
        
        cargarMetodosIniciales();
        
    }
    
    
        private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaComputadoras();
        this.cargarComputadorasEnTabla();

    }
    
        
    private void editarComputadoraTabla(ComputadoraDTO computadora) {
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
    
    
    private void cargarConfiguracionInicialTablaBloqueos() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                editar();

            }
        };

        int indiceColumnaEditar = 6;
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
        int indiceColumnaEliminar = 7;
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
            int indiceColumnaId = 5;
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
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getMotivo();
                fila[2] = row.getFechaBloqueo().getTime().toString();
                fila[3] = row.getFechaLiberacion().getTime().toString();
                fila[4] = row.getAlumno();
                fila[5] = row.isEliminado();
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Computadoras");

        jLabel1.setText("Gestion de Computadoras");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idComputadoras", "Estatus", "Dirrecion ip", "Numero Maquina", "Software", "Ocupante", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton3))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.setVisible(false);
administrador.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);
AgregarComputadora agregarComputadora=new AgregarComputadora(this);
agregarComputadora.setVisible(true);



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
