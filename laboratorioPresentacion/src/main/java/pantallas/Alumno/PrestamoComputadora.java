/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas.Alumno;

import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.ComputadoraDTO;
import dto.PrestamoComputadoraDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.IAlumnoNegocio;
import negocio.IComputadoraNegocio;
import negocio.IPrestamoComputadoraNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Arturo ITSON
 */
public class PrestamoComputadora extends javax.swing.JFrame {

    
    private IComputadoraNegocio computadoraNegocio;
    private AlumnoDTO alumnoDTO;
    private IniciarSesionAlumno iniciarSesionAlumno;
    private IAlumnoNegocio alumnoNegocio;
    private IPrestamoComputadoraNegocio prestamoComputadoraNegocio;
    
    
    /**
     * Creates new form PrestamoComputadora
     */
    public PrestamoComputadora(IniciarSesionAlumno iniciarSesionAlumno, IComputadoraNegocio computadoraNegocio, IAlumnoNegocio alumnoNegocio, 
                               IPrestamoComputadoraNegocio prestamoComputadoraNegocio, AlumnoDTO alumnoDTO ) {
        this.computadoraNegocio = computadoraNegocio;
        this.alumnoDTO = alumnoDTO;
        this.iniciarSesionAlumno = iniciarSesionAlumno;
        this.alumnoNegocio = alumnoNegocio;
        this.prestamoComputadoraNegocio = prestamoComputadoraNegocio;
        
        initComponents();
        
        
        cargarMetodosIniciales();
    }
    
    
    
    private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaPrestamosComputadoras();
        this.cargarPrestamosComputadorasEnTabla();

    }
    
    
    
    private void seleccionarPrestamoComputadoraTabla(PrestamoComputadoraDTO prestamoCompu) {

        ConfirmarPrestamoComputadora confirmarPrestamoComputadora = new ConfirmarPrestamoComputadora(this, iniciarSesionAlumno, alumnoNegocio, computadoraNegocio, prestamoCompu, alumnoDTO, prestamoComputadoraNegocio);
        confirmarPrestamoComputadora.setVisible(true);
        this.setVisible(false);
        
    }
    
    
    private void cargarConfiguracionInicialTablaPrestamosComputadoras() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                seleccionar();

            }
        };

        int indiceColumnaEditar = 2;
        TableColumnModel modeloColumnas = this.tblComputadoras.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Seleccionar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Seleccionar",
                        onEditarClickListener));

    }
    
    

    private Integer getNumeroMaquinaSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 1;
            Integer numeroMaquinaSeleccionada = (Integer) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return numeroMaquinaSeleccionada;
        } else {
            return null;
        }
    }

    
    private String getEstatusSeleccionadoTablaBloqueo() {
        int indiceFilaSeleccionada = this.tblComputadoras.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblComputadoras.getModel();
            int indiceColumnaId = 0;
            String estatusSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return estatusSeleccionado;
        } else {
            return null;
        }
    }
    

    private void seleccionar() {

        PrestamoComputadoraDTO prestamoCompu = new PrestamoComputadoraDTO();
        prestamoCompu.setIdAlumno(alumnoDTO.getId());
        prestamoCompu.setNumMaquina(this.getNumeroMaquinaSeleccionadoTablaBloqueo());
        prestamoCompu.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
        prestamoCompu.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
        prestamoCompu.setNombres(alumnoDTO.getNombres());
       // prestamoCompu.setIdComputadora();

       if(this.getEstatusSeleccionadoTablaBloqueo().equals("Apartada")){
          JOptionPane.showMessageDialog(this, "No puede apartar una computadora que esta en uso", "Informacion", JOptionPane.ERROR_MESSAGE); 
          return;
       }
           
       else{
        seleccionarPrestamoComputadoraTabla(prestamoCompu);
       }
                
    }


    private void llenarTablaPrestamosComputadoras(List<ComputadoraDTO> computadorasLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblComputadoras.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (computadorasLista != null) {
            computadorasLista.forEach(row -> {
                Object[] fila = new Object[2];
                fila[0] = row.getEstatus();
                fila[1] = row.getNumeroMaquina();
                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarPrestamosComputadorasEnTabla() {
        try {
            List<ComputadoraDTO> computadoras = this.computadoraNegocio.buscarComputadorasUsoAlumnoTabla();
            this.llenarTablaPrestamosComputadoras(computadoras);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    
    private void cargarComputadorasPrestamosEnTablaPorEstatus(String estatus) {
        try {
            
            System.out.println(estatus);
            List<ComputadoraDTO> computadoras = this.computadoraNegocio.buscarBloqueosPorEstatusTabla(estatus);
            
            if(computadoras.size() > 0){
            
            this.llenarTablaPrestamosComputadoras(computadoras);
            
            }
            
            else{
               JOptionPane.showMessageDialog(this, "No se encontraron registros con los datos especificados, se mostraran todos los datos", "Informacion", JOptionPane.ERROR_MESSAGE); 
                cargarPrestamosComputadorasEnTabla();
            }
            
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
            cargarPrestamosComputadorasEnTabla();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComputadoras = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblComputadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Estatus", "Numero de Maquina", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComputadoras);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblTitulo.setText("Prestamo de computadoras");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                            .addComponent(btnBuscar))
                        .addComponent(jScrollPane1)
                        .addComponent(jblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnRegresar)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.cargarComputadorasPrestamosEnTablaPorEstatus(txtBuscar.getText());
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        iniciarSesionAlumno.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jblTitulo;
    private javax.swing.JTable tblComputadoras;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
