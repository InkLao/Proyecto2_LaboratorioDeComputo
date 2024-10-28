/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas.Maquina;

import pantallas.Maquina.EquipoDisponible;
import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.ComputadoraDTO;
import dto.PrestamoComputadoraDTO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import negocio.IAlumnoNegocio;
import negocio.IComputadoraNegocio;
import negocio.IPrestamoComputadoraNegocio;
import pantallas.Alumno.PrestamoComputadora;

/**
 *
 * @author Oley
 */
public class EquipoOcupado extends javax.swing.JFrame {

    
    private String rutaITSONLogo = "src/main/java/Imagenes/CaballoPotros_1.png";
    private String rutaPotrosLogo = "src/main/java/Imagenes/ItsonLogoPNG_1.png";
    private String ip;
    private static ComputadoraDTO compu;
    private static boolean detener = false;

    IComputadoraNegocio computadoraNegocio;
    IAlumnoNegocio alumnoNegocio;
    IPrestamoComputadoraNegocio prestamoComputadoraNegocio;
    
    /**
     * Creates new form EquipoOcupado
     */
    public EquipoOcupado(IComputadoraNegocio computadoraNegocio, IAlumnoNegocio alumnoNegocio, IPrestamoComputadoraNegocio prestamoComputadoraNegocio) {
        this.computadoraNegocio = computadoraNegocio;
        this.alumnoNegocio = alumnoNegocio;
        this.prestamoComputadoraNegocio = prestamoComputadoraNegocio;
        
        initComponents();
        
        
        setImagenLabel(jblImagenITSON, rutaITSONLogo);
        setImagenLabel(jblPotros, rutaPotrosLogo);
        
        try {
            this.ip = obtenerIP();
        } catch (UnknownHostException ex) {
            Logger.getLogger(EquipoDisponible.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cargarDatos();
        
        
        metodoEjecutadorCada10Segundos();
        
    }
    
    
    /**
     * Metodo que coloca una imagen en los parametros especificados en la interfaz
     * @param nombreJlb el jlabel que sera reemplazado por una imagen
     * @param ruta la direccion donde se encuentra la imagen
     */
    private void setImagenLabel(JLabel nombreJlb, String ruta){
    
        ImageIcon image = new ImageIcon(ruta);
        
        Icon icon = new ImageIcon(
        image.getImage().getScaledInstance(nombreJlb.getWidth(), nombreJlb.getHeight(), Image.SCALE_DEFAULT));
        
        nombreJlb.setIcon(icon);
        
        this.repaint();
   
    }

    
    public void metodoEjecutadorCada10Segundos(){


        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        if(detener == true){
            scheduler.shutdown();
        }
        
        else{
        
            Runnable tarea = () -> {
            // Aquí va el código que deseas ejecutar cada 10 segundos
                System.out.println("Ejecutando tarea cada 10 segundos: " + System.currentTimeMillis());
                try {
                     comprobacionDisponibilidad();
                } catch (NegocioException ex) {
                    Logger.getLogger(EquipoDisponible.class.getName()).log(Level.SEVERE, null, ex);
                }
            };

            // Programa la tarea para que se ejecute cada 10 segundos, con un retraso inicial de 0 segundos
            scheduler.scheduleAtFixedRate(tarea, 0, 10, TimeUnit.SECONDS);
        } 
    }
        
    
    public String obtenerIP() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        return ip.getHostAddress(); 
    
        }

    
    public void comprobacionDisponibilidad() throws NegocioException{
        
        compu = computadoraNegocio.obtenerPorIP(ip);
        jblEquipoApartadoPor.setText("Numero de maquina #" + compu.getNumeroMaquina());
        
        List<PrestamoComputadoraDTO> prestamos = new ArrayList<>();
        
        prestamos = prestamoComputadoraNegocio.buscarPrestamoPorComputadora(compu.getId());
        PrestamoComputadoraDTO elBueno = prestamos.get(prestamos.size() - 1);
        
        System.out.println("esta apartada: " + elBueno.isSigueApartada());
        if(elBueno.isSigueApartada() == false){
            JOptionPane.showMessageDialog(this, "Tu tiempo ha terminado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            EquipoDisponible equipoDisponible = new EquipoDisponible(computadoraNegocio, alumnoNegocio, prestamoComputadoraNegocio);
            equipoDisponible.setVisible(true);
            this.dispose();
            detener = true;
            
            }
                        
        if(elBueno.isSigueApartada() == true){
            System.out.println("Entro a disponible");
            return;
            }
        
        compu = null;
    }
    
    private void cargarDatos(){
        
        
        try {
            
            ComputadoraDTO compu = computadoraNegocio.obtenerPorIP(ip);
            
            List<PrestamoComputadoraDTO> listaPrestamo = prestamoComputadoraNegocio.buscarPrestamoPorComputadora(compu.getId());
            
            System.out.println("lista prestamo" + listaPrestamo.size());
            
            PrestamoComputadoraDTO prueba = new PrestamoComputadoraDTO();
            
            PrestamoComputadoraDTO prestamo = listaPrestamo.get(listaPrestamo.size() - 1);
            
            jblNumeroCompu.setText("Numero de computadora #" + compu.getNumeroMaquina());
            
            AlumnoDTO alumno = alumnoNegocio.obtenerPorId(prestamo.getIdAlumno());
            
            jblEquipoApartadoPor.setText("Equipo apartado por: " + alumno.getNombres());
            
            
            // AlumnoDTO alumno = alumnoNegocio.obtenerPorId(prestamoComputadoraNegocio.)
        } catch (NegocioException ex) {
            Logger.getLogger(EquipoOcupado.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jblNumeroCompu = new javax.swing.JLabel();
        jblEquipoApartadoPor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jblImagenITSON = new javax.swing.JLabel();
        jblPotros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Bienvenido");

        jblNumeroCompu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jblNumeroCompu.setText("Computadora #1");

        jblEquipoApartadoPor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jblEquipoApartadoPor.setText("Equipo apartado por alumno");

        jButton1.setText("Desbloquear");

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jblNumeroCompu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jblEquipoApartadoPor)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 138, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(229, 229, 229))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jblNumeroCompu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jblEquipoApartadoPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jblImagenITSON, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jblPotros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jblImagenITSON, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jblPotros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jblEquipoApartadoPor;
    private javax.swing.JLabel jblImagenITSON;
    private javax.swing.JLabel jblNumeroCompu;
    private javax.swing.JLabel jblPotros;
    // End of variables declaration//GEN-END:variables
}
