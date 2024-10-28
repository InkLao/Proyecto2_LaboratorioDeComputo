/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dto.CarreraDTO;
import dto.UnidadAcademicaDTO;
import javax.swing.JOptionPane;
import negocio.IAlumnoNegocio;
import negocio.IBloqueoNegocio;
import negocio.ICarreraNegocio;
import negocio.ICentroComputoNegocio;
import negocio.IComputadoraNegocio;
import negocio.IUnidadNegocio;

/**
 *
 * @author Oley
 */
public class Administrador extends javax.swing.JFrame {

    
    private InicioSesion inicioSesion;
    private ICarreraNegocio carreraNegocio;
    private IUnidadNegocio unidadNegocio;
    private IAlumnoNegocio alumnoNegocio;
    private IBloqueoNegocio bloqueoNegocio;
    private ICentroComputoNegocio centroComputoNegocio;
    private IComputadoraNegocio computadoraNegocio;

    /**
     * Creates new form Administrador
     */
    public Administrador(InicioSesion inicioSesion, ICarreraNegocio carreraNegocio, IUnidadNegocio unidadNegocio, IAlumnoNegocio alumnoNegocio,
                         IBloqueoNegocio bloqueoNegocio, ICentroComputoNegocio centroComputoNegocio, IComputadoraNegocio computadoraNegocio) {
        this.carreraNegocio = carreraNegocio;
        this.unidadNegocio = unidadNegocio;
        this.alumnoNegocio= alumnoNegocio;
        this.bloqueoNegocio = bloqueoNegocio;
        this.centroComputoNegocio = centroComputoNegocio;
        this.computadoraNegocio = computadoraNegocio;
        
        this.inicioSesion = inicioSesion;
        
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnComputadoras = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnBloqueos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnGestionCentroComputos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");

        jLabel1.setText("Administrador");

        jButton1.setText("Insertar licencias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Insertar Unidades");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnComputadoras.setText("Gestionar Computadoras");
        btnComputadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputadorasActionPerformed(evt);
            }
        });

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Gestion Alumnos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnBloqueos.setText("Gestion Bloqueos");
        btnBloqueos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloqueosActionPerformed(evt);
            }
        });

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnGestionCentroComputos.setText("Gestión Centro de Computos");
        btnGestionCentroComputos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionCentroComputosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGestionCentroComputos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jButton4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(btnBloqueos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(btnComputadoras)
                            .addGap(38, 38, 38)
                            .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(btnBloqueos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnReportes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnComputadoras)))
                .addGap(33, 33, 33)
                .addComponent(btnGestionCentroComputos)
                .addGap(50, 50, 50)
                .addComponent(jButton4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        inicioSesion.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
          CarreraDTO carrera1 = new CarreraDTO();
carrera1.setNombre("Licenciatura en Administración");
carrera1.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera1);

CarreraDTO carrera2 = new CarreraDTO();
carrera2.setNombre("Licenciatura en Administración de Empresas Turísticas");
carrera2.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera2);

CarreraDTO carrera3 = new CarreraDTO();
carrera3.setNombre("Licenciatura en Administración Estratégica");
carrera3.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera3);

CarreraDTO carrera4 = new CarreraDTO();
carrera4.setNombre("Licenciatura en Arquitectura");
carrera4.setTiempoMaxUsoDiario(3);
carreraNegocio.agregarCarrera(carrera4);

CarreraDTO carrera5 = new CarreraDTO();
carrera5.setNombre("Licenciatura en Ciencias de la Educación");
carrera5.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera5);

CarreraDTO carrera6 = new CarreraDTO();
carrera6.setNombre("Licenciatura en Ciencias del Ejercicio Físico");
carrera6.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera6);

CarreraDTO carrera7 = new CarreraDTO();
carrera7.setNombre("Licenciatura en Contaduría Pública");
carrera7.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera7);

CarreraDTO carrera8 = new CarreraDTO();
carrera8.setNombre("Licenciatura en Dirección de la Cultura Física y el Deporte");
carrera8.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera8);

CarreraDTO carrera9 = new CarreraDTO();
carrera9.setNombre("Licenciatura en Diseño Gráfico");
carrera9.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera9);

CarreraDTO carrera10 = new CarreraDTO();
carrera10.setNombre("Licenciatura en Derecho");
carrera10.setTiempoMaxUsoDiario(5);
carreraNegocio.agregarCarrera(carrera10);

CarreraDTO carrera11 = new CarreraDTO();
carrera11.setNombre("Licenciatura en Economía y Finanzas");
carrera11.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera11);

CarreraDTO carrera12 = new CarreraDTO();
carrera12.setNombre("Licenciatura en Educación Artística y Gestión Cultural");
carrera12.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera12);

CarreraDTO carrera13 = new CarreraDTO();
carrera13.setNombre("Licenciatura en Educación Infantil");
carrera13.setTiempoMaxUsoDiario(3);
carreraNegocio.agregarCarrera(carrera13);

CarreraDTO carrera14 = new CarreraDTO();
carrera14.setNombre("Licenciatura en Educación Inicial y Gestión de Instituciones");
carrera14.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera14);

CarreraDTO carrera15 = new CarreraDTO();
carrera15.setNombre("Licenciatura en Emprendimiento e Innovación");
carrera15.setTiempoMaxUsoDiario(4);
carreraNegocio.agregarCarrera(carrera15);

CarreraDTO carrera16 = new CarreraDTO();
carrera16.setNombre("Licenciatura en Enfermería");
carrera16.setTiempoMaxUsoDiario(7);
carreraNegocio.agregarCarrera(carrera16);

CarreraDTO carrera17 = new CarreraDTO();
carrera17.setNombre("Licenciatura en Gastronomía");
carrera17.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera17);

CarreraDTO carrera18 = new CarreraDTO();
carrera18.setNombre("Licenciatura en Mercadotecnia");
carrera18.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera18);

CarreraDTO carrera19 = new CarreraDTO();
carrera19.setNombre("Licenciatura en Psicología");
carrera19.setTiempoMaxUsoDiario(2);
carreraNegocio.agregarCarrera(carrera19);

CarreraDTO carrera20 = new CarreraDTO();
carrera20.setNombre("Licenciatura en Tecnología de Alimentos");
carrera20.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera20);

CarreraDTO carrera21 = new CarreraDTO();
carrera21.setNombre("Ingeniería en Biosistemas");
carrera21.setTiempoMaxUsoDiario(6);
carreraNegocio.agregarCarrera(carrera21);

CarreraDTO carrera22 = new CarreraDTO();
carrera22.setNombre("Ingeniería en Biotecnología");
carrera22.setTiempoMaxUsoDiario(6);
carreraNegocio.agregarCarrera(carrera22);

CarreraDTO carrera23 = new CarreraDTO();
carrera23.setNombre("Ingeniería en Ciencias Ambientales");
carrera23.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera23);

CarreraDTO carrera24 = new CarreraDTO();
carrera24.setNombre("Ingeniería Civil");
carrera24.setTiempoMaxUsoDiario(5);
carreraNegocio.agregarCarrera(carrera24);

CarreraDTO carrera25 = new CarreraDTO();
carrera25.setNombre("Ingeniería Electromecánica");
carrera25.setTiempoMaxUsoDiario(6);
carreraNegocio.agregarCarrera(carrera25);

CarreraDTO carrera26 = new CarreraDTO();
carrera26.setNombre("Ingeniería en Electrónica");
carrera26.setTiempoMaxUsoDiario(3);
carreraNegocio.agregarCarrera(carrera26);

CarreraDTO carrera27 = new CarreraDTO();
carrera27.setNombre("Ingeniería Industrial y de Sistemas");
carrera27.setTiempoMaxUsoDiario(3);
carreraNegocio.agregarCarrera(carrera27);

CarreraDTO carrera28 = new CarreraDTO();
carrera28.setNombre("Ingeniería en Logística");
carrera28.setTiempoMaxUsoDiario(1);
carreraNegocio.agregarCarrera(carrera28);

CarreraDTO carrera29 = new CarreraDTO();
carrera29.setNombre("Ingeniería en Manufactura");
carrera29.setTiempoMaxUsoDiario(2);
carreraNegocio.agregarCarrera(carrera29);

CarreraDTO carrera30 = new CarreraDTO();
carrera30.setNombre("Ingeniería en Mecatrónica");
carrera30.setTiempoMaxUsoDiario(6);
carreraNegocio.agregarCarrera(carrera30);

CarreraDTO carrera31 = new CarreraDTO();
carrera31.setNombre("Ingeniería Química");
carrera31.setTiempoMaxUsoDiario(2);
carreraNegocio.agregarCarrera(carrera31);

CarreraDTO carrera32 = new CarreraDTO();
carrera32.setNombre("Ingeniería en Software");
carrera32.setTiempoMaxUsoDiario(7);
carreraNegocio.agregarCarrera(carrera32);

CarreraDTO carrera33 = new CarreraDTO();
carrera33.setNombre("Medicina Veterinaria y Zootecnia");
carrera33.setTiempoMaxUsoDiario(6);
carreraNegocio.agregarCarrera(carrera33);

//    JOptionPane.showMessageDialog(this, "Carreras agregadas exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            InsertarLicencias insertarLicencias = new InsertarLicencias(this);
            insertarLicencias.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar las carreras ya estan agregadas: " + e.getMessage());

//    JOptionPane.showMessageDialog(this, "Error al agregar las carreras: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            UnidadAcademicaDTO academicaDTO = new UnidadAcademicaDTO(" Obregón. Centro");
            unidadNegocio.agregarUnidadAcademica(academicaDTO);

            UnidadAcademicaDTO academicaDTO1 = new UnidadAcademicaDTO("Obregón. Náinari");
            unidadNegocio.agregarUnidadAcademica(academicaDTO1);

             UnidadAcademicaDTO academicaDTO2 = new UnidadAcademicaDTO("Guaymas");
            unidadNegocio.agregarUnidadAcademica(academicaDTO2);

             UnidadAcademicaDTO academicaDTO3 = new UnidadAcademicaDTO("Empalme");
            unidadNegocio.agregarUnidadAcademica(academicaDTO3);

             UnidadAcademicaDTO academicaDTO4 = new UnidadAcademicaDTO("Navojoa. Centro");
            unidadNegocio.agregarUnidadAcademica(academicaDTO4);

             UnidadAcademicaDTO academicaDTO5 = new UnidadAcademicaDTO("Navojoa. Sur");
            unidadNegocio.agregarUnidadAcademica(academicaDTO5);
            
            
            
            
            
            
            
            this.setVisible(false);
            InsertarUnidades insertarUnidades = new InsertarUnidades(this);
            insertarUnidades.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar las unidades ya estan agregadas: " + e.getMessage());

        }

      

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnComputadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadorasActionPerformed
        this.setVisible(false);
        GestionComputadoras gestionComputadoras = new GestionComputadoras(this, computadoraNegocio, centroComputoNegocio);
        gestionComputadoras.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnComputadorasActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        this.setVisible(false);
        MenuReportes menuReportes = new MenuReportes(this, bloqueoNegocio, alumnoNegocio,carreraNegocio);
        menuReportes.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        GestionAlumnos gestionAlumnos = new GestionAlumnos(this, alumnoNegocio, carreraNegocio);
        gestionAlumnos.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnBloqueosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloqueosActionPerformed
        this.setVisible(false);
        GestionBloqueos gestionBloqueos = new GestionBloqueos(this, bloqueoNegocio, alumnoNegocio);
        gestionBloqueos.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBloqueosActionPerformed

    private void btnGestionCentroComputosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionCentroComputosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        GestionCentroComputos gcp = new GestionCentroComputos(unidadNegocio, this, centroComputoNegocio);
        gcp.setVisible(true);
    }//GEN-LAST:event_btnGestionCentroComputosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloqueos;
    private javax.swing.JButton btnComputadoras;
    private javax.swing.JButton btnGestionCentroComputos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
