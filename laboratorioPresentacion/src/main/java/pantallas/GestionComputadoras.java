/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import NegocioException.NegocioException;
import dto.ComputadoraDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.ICentroComputoNegocio;
import negocio.IComputadoraNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;


/**
 *
 * @author Oley
 */
public class GestionComputadoras extends javax.swing.JFrame {
    
    
    private IComputadoraNegocio computadoraNegocio;
    private Administrador administrador;
    private ICentroComputoNegocio centroComputoNegocio;

    /**
     * Creates new form GestionComputadoras
     */
    public GestionComputadoras(Administrador administrador, IComputadoraNegocio computadoraNegocio, ICentroComputoNegocio centroComputoNegocio) {
        this.computadoraNegocio = computadoraNegocio;
        this.administrador = administrador;
        this.centroComputoNegocio = centroComputoNegocio;
        
        initComponents();
        
        cargarMetodosIniciales();
        
    }
    
    
        private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaComputadoras();
        this.cargarComputadorasEnTabla();

    }
    
        
    private void editarComputadoraTabla(ComputadoraDTO computadora) {
        try {
            
            System.out.println(computadora.toString() + "editar bloqueo id");
            
            ComputadoraDTO compuActualizada = computadoraNegocio.actualizarComputadora(computadora);
            
            System.out.println(compuActualizada.getId());
            
            JOptionPane.showMessageDialog(this, "Bloqueo editado");
            
            this.cargarComputadorasEnTabla();

            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
        
    private void eliminarComputadoraTabla(ComputadoraDTO compu) {
        try {
            this.computadoraNegocio.eliminarComputadora(compu);
            JOptionPane.showMessageDialog(this, "Computadora Eliminado");
            this.cargarComputadorasEnTabla();
            
        } 
        
        catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
    private void cargarConfiguracionInicialTablaComputadoras() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                editar();

            }
        };

        int indiceColumnaEditar = 7;
        TableColumnModel modeloColumnas = this.tblComputadoras.getColumnModel();
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
        int indiceColumnaEliminar = 8;
        modeloColumnas = this.tblComputadoras.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar",
                        onEliminarClickListener));

    }

    private long getIdSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 0;
            long idCompuSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idCompuSeleccionado;
        } else {
            return 0;
        }
    }
    
    
    private String getEstatusSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 1;
            String estatusCompuSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return estatusCompuSeleccionado;
        } else {
            return null;
        }
    }
        
        
    private String getIpSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 2;
            String ipCompuSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return ipCompuSeleccionado;
        } else {
            return null;
        }
    }
            
            
            
            
    private Integer getNumeroMaquiaSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 3;
            Integer numeroMaquinaCompuSeleccionado = (Integer) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return numeroMaquinaCompuSeleccionado;
        } else {
            return null;
        }
    }
                
           
    private boolean getUsoAlumnoSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 4;
            boolean usoAlumnoCompuSeleccionado = (boolean) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return usoAlumnoCompuSeleccionado;
        } else {
            return false;
        }
    }
    
    
    private long getLaboratorioSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 5;
            long laboratorioCompuSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return laboratorioCompuSeleccionado;
        } else {
            return 0;
        }
    }
                
                
    private boolean getEliminadoSeleccionadoTablaComputadoras() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 6;
            boolean usoAlumnoCompuSeleccionado = (boolean) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return usoAlumnoCompuSeleccionado;
        } else {
            return false;
        }
    } 
  


    private void editar() {
        //Metodo para regresar el alumno seleccionado

        try{

        ComputadoraDTO compu = new ComputadoraDTO();

        compu = computadoraNegocio.obtenerPorId(getIdSeleccionadoTablaComputadoras());

        System.out.println(compu.getId() + " si busco");
        
        compu.setCentroLaboratorio(this.getLaboratorioSeleccionadoTablaComputadoras());
        compu.setEstatus(this.getEstatusSeleccionadoTablaComputadoras());
        compu.setId(this.getIdSeleccionadoTablaComputadoras());
        compu.setIp(this.getIpSeleccionadoTablaComputadoras());
        compu.setNumeroMaquina(this.getNumeroMaquiaSeleccionadoTablaComputadoras());
        compu.setUsoAlumno(this.getUsoAlumnoSeleccionadoTablaComputadoras());
        
        editarComputadoraTabla(compu);
        
        cargarComputadorasEnTabla();
        }
        
        catch(NegocioException e ){
            e.printStackTrace();
        }
    }

    private void eliminar() throws NegocioException {
        //Metodo para regresar el beneficiario seleccionado
        
        ComputadoraDTO eliminado = new ComputadoraDTO();
        
        eliminado = computadoraNegocio.obtenerPorId(getIdSeleccionadoTablaComputadoras());

        System.out.println("Preparando el id: " + eliminado.getId() + " para borrar");
        
        eliminado.setEliminado(true);
        
        eliminarComputadoraTabla(eliminado);
        cargarComputadorasEnTabla();

    }

    private void llenarTablaComputadoras(List<ComputadoraDTO> computadorasLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblComputadoras.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (computadorasLista != null) {
            computadorasLista.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getId();
                fila[1] = row.getEstatus();
                fila[2] = row.getIp();
                fila[3] = row.getNumeroMaquina();
                fila[4] = row.isUsoAlumno();
                fila[5] = row.getCentroLaboratorio();
                fila[6] = row.isEliminado();
                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarComputadorasEnTabla() {
        try {
            List<ComputadoraDTO> computadoras = this.computadoraNegocio.buscarComputadorasTabla();
            this.llenarTablaComputadoras(computadoras);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
    private void cargarBloqueosEnTablaPorMotivo(String ip) {
        try {
            
            System.out.println(ip);
            List<ComputadoraDTO> computadoras = this.computadoraNegocio.buscarBloqueosTabla(ip);
            
            if(computadoras.size() > 0){
            
            this.llenarTablaComputadoras(computadoras);
            
            }
            
            else{
               JOptionPane.showMessageDialog(this, "No se encontraron registros con los datos especificados, se mostraran todos los datos", "Informacion", JOptionPane.ERROR_MESSAGE); 
                cargarComputadorasEnTabla();
            }
            
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            cargarComputadorasEnTabla();
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
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComputadoras = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar Computadoras");

        jLabel1.setText("Gestion de Computadoras");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblComputadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idComputadoras", "Estatus", "Dirrecion ip", "Numero Maquina", "UsoAlumno", "Laboratorio", "Eliminado", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComputadoras);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnBuscar))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAgregar))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegresar))
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
                .addGap(17, 17, 17)
                .addComponent(btnAgregar)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnRegresar))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
this.setVisible(false);
administrador.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(false);
        AgregarComputadora agregarComputadora=new AgregarComputadora(this, computadoraNegocio, centroComputoNegocio);
        agregarComputadora.setVisible(true);



        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComputadoras;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
