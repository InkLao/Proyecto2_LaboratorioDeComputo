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
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import negocio.IAlumnoNegocio;
import negocio.IComputadoraNegocio;
import negocio.IPrestamoComputadoraNegocio;

/**
 *
 * @author Arturo ITSON
 */
public class ConfirmarPrestamoComputadora extends javax.swing.JFrame implements Runnable {

    private IAlumnoNegocio alumnoNegocio;
    private IComputadoraNegocio computadoraNegocio;
    private IPrestamoComputadoraNegocio prestamoComputadoraNegocio;
    
    private PrestamoComputadora prestamoComputadora; // la pantalla anterior
    private PrestamoComputadoraDTO prestamoComputadoraDTO;
    private IniciarSesionAlumno iniciarSesionAlumno;
    
    private AlumnoDTO alumnoDTO;
    private static int minutosMax = 0;
    private static int minutosSeleccionados = 0;
    
    
    /**
     * Creates new form ConfirmarPrestamoComputadora
     */
    public ConfirmarPrestamoComputadora(PrestamoComputadora prestamoComputadora, IniciarSesionAlumno iniciarSesionAlumno, IAlumnoNegocio alumnoNegocio, IComputadoraNegocio computadoraNegocio, PrestamoComputadoraDTO prestamoComputadoraDTO, AlumnoDTO alumnoDTO,
                                        IPrestamoComputadoraNegocio prestamoComputadoraNegocio) {
        this.prestamoComputadora = prestamoComputadora;
        this.alumnoNegocio = alumnoNegocio;
        this.computadoraNegocio = computadoraNegocio;
        this.prestamoComputadoraDTO = prestamoComputadoraDTO;
        this.alumnoDTO = alumnoDTO;
        this.prestamoComputadoraNegocio = prestamoComputadoraNegocio;
        this.iniciarSesionAlumno = iniciarSesionAlumno;
        
        initComponents();
        
        
        cargarMetodosIniciales(prestamoComputadoraDTO);
    }

    
    public void cargarMetodosIniciales(PrestamoComputadoraDTO prestamoComputadoraDTO){
    
        txtMaquina.setText(String.valueOf(prestamoComputadoraDTO.getNumMaquina()));
        txtAlumno.setText(prestamoComputadoraDTO.getNombres() + " " + prestamoComputadoraDTO.getApellidoPaterno() + " " + prestamoComputadoraDTO.getApellidoMaterno());
        txtMinutos.setText("1");
        
        minutosMax = alumnoDTO.getCarrera().getTiempoMaxUsoDiario();
        
        
    }
    
    
    @Override
    public void run() {
        
        Timer timer = new Timer(minutosSeleccionados * 60000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Tu Codigo
                    
                    try {
                        
                        ComputadoraDTO compu = computadoraNegocio.buscarComputadorasPorNumMaquina(prestamoComputadoraDTO.getNumMaquina());
                        compu.setEstatus("Disponible");
                        computadoraNegocio.actualizarComputadora(compu);
                        System.out.println("y tu tiempo se acabo");
                        
                        
                    } catch (NegocioException ex) {
                        Logger.getLogger(ConfirmarPrestamoComputadora.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            });    
    
        timer.start();
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
        btnRegresar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaquina = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMinutos = new javax.swing.JTextField();
        btnMenosMinutos = new javax.swing.JButton();
        btnMasMinutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmar Prestamo");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Maquina");

        txtMaquina.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Alumno");

        txtAlumno.setEditable(false);
        txtAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Minutos");

        txtMinutos.setEditable(false);
        txtMinutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinutosActionPerformed(evt);
            }
        });

        btnMenosMinutos.setText("<");
        btnMenosMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosMinutosActionPerformed(evt);
            }
        });

        btnMasMinutos.setText(">");
        btnMasMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasMinutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnMenosMinutos)
                        .addGap(34, 34, 34)
                        .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnMasMinutos)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAlumno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaquina))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenosMinutos)
                    .addComponent(btnMasMinutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnConfirmar))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlumnoActionPerformed

    private void txtMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinutosActionPerformed

    private void btnMenosMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosMinutosActionPerformed
        // TODO add your handling code here:
        
        btnMasMinutos.setEnabled(true);
        
        if(Integer.valueOf(txtMinutos.getText()) < 2){
            JOptionPane.showMessageDialog(this, "Debe escoger un minuto o mas");
            btnMenosMinutos.setEnabled(false);
            txtMinutos.setText("1");
            btnMasMinutos.setEnabled(true);
        }
        
        else{
            int minutosMasUno = Integer.valueOf(txtMinutos.getText()) - 1;
            txtMinutos.setText(String.valueOf(minutosMasUno));
            
        }
    }//GEN-LAST:event_btnMenosMinutosActionPerformed

    private void btnMasMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasMinutosActionPerformed
        // TODO add your handling code here:
        
        if (Integer.valueOf(txtMinutos.getText()) > minutosMax){
            JOptionPane.showMessageDialog(this, "No se permiten mas minutos");
            btnMasMinutos.setEnabled(false);
            int minutosMenosUno = Integer.valueOf(txtMinutos.getText()) - 1;
            txtMinutos.setText(String.valueOf(minutosMenosUno));
            btnMenosMinutos.setEnabled(true);
        }
        
        else{
            int minutosMasUno = Integer.valueOf(txtMinutos.getText()) + 1;
            txtMinutos.setText(String.valueOf(minutosMasUno));
            btnMenosMinutos.setEnabled(true);
            
        }
        
    }//GEN-LAST:event_btnMasMinutosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        
        prestamoComputadora.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        try{
            
            minutosSeleccionados = Integer.valueOf(txtMinutos.getText());
            PrestamoComputadoraDTO prestamo = new PrestamoComputadoraDTO();
            prestamo.setIdAlumno(alumnoDTO.getId());
            System.out.println("id de alumno es " + prestamo.getIdAlumno());
            prestamo.setIdComputadora(computadoraNegocio.buscarComputadorasPorNumMaquina(prestamoComputadoraDTO.getNumMaquina()).getId());
            System.out.println("id de comutadora es:" + prestamo.getIdComputadora());
            prestamo.setMinutos(Integer.valueOf(minutosSeleccionados));
            prestamo.setFechaPrestamo(Calendar.getInstance());
            
            prestamoComputadoraNegocio.guardarPrestamo(prestamo);
            
            System.out.println("minutos seleccionados: " + minutosSeleccionados);
            
            run();
            JOptionPane.showMessageDialog(this, "Se ha apartado la maquina");
            
            this.dispose();
            prestamoComputadora.dispose();
            iniciarSesionAlumno.setVisible(true);
        }
        
        catch(NegocioException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnMasMinutos;
    private javax.swing.JButton btnMenosMinutos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtMaquina;
    private javax.swing.JTextField txtMinutos;
    // End of variables declaration//GEN-END:variables


}