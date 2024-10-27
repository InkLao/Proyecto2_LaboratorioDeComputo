/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;

import dto.AlumnoDTO;
import dto.BloqueoDTO;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import negocio.IAlumnoNegocio;
import negocio.IBloqueoNegocio;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 *
 * @author eduar
 */
public class ReporteBloqueoFiltros extends javax.swing.JFrame {

    private IBloqueoNegocio bloqueoNegocio;
    private IAlumnoNegocio alumnoNegocio;
    private MenuReportes mr;

    /**
     * Creates new form ReporteBloqueoFiltros
     */
    public ReporteBloqueoFiltros(IBloqueoNegocio bloqueoNegocio, IAlumnoNegocio alumnoNegocio) {
        this.bloqueoNegocio = bloqueoNegocio;
        this.alumnoNegocio = alumnoNegocio;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datePickerFechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        datePickerFechaFinal = new com.github.lgooddatepicker.components.DatePicker();
        btnRegresar = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Reporte Bloqueos");

        jLabel2.setText("Fecha Inicio");

        jLabel3.setText("Fecha Final");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarReporte))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(datePickerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(datePickerFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePickerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnGenerarReporte))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        mr.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        LocalDate fechaInicio = datePickerFechaInicio.getDate();
        LocalDate fechaFinal = datePickerFechaFinal.getDate();

        if (fechaInicio != null && fechaFinal != null) {
            try {
                Calendar inicio = Calendar.getInstance();
                inicio.set(fechaInicio.getYear(), fechaInicio.getMonthValue() - 1, fechaInicio.getDayOfMonth());
                Calendar fin = Calendar.getInstance();
                fin.set(fechaFinal.getYear(), fechaFinal.getMonthValue() - 1, fechaFinal.getDayOfMonth());

                List<BloqueoDTO> bloqueos = bloqueoNegocio.buscarBloqueosPorFecha(inicio, fin);

                // Crear una lista de Mapas para el reporte
                List<Map<String, Object>> reporteDatos = new ArrayList<>();
                for (BloqueoDTO bloqueo : bloqueos) {
                    AlumnoDTO alumno = alumnoNegocio.obtenerPorId(bloqueo.getAlumno());
                    String nombreCompleto = alumno.getNombres() + " " + alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno();

                    Map<String, Object> datos = new HashMap<>();
                    datos.put("nombreCompleto", nombreCompleto);  // Asegúrate de que esta variable tiene un valor String
                    datos.put("fechaBloqueo", bloqueo.getFechaBloqueo().getTime()); // Convierte Calendar a Date
                    datos.put("fechaLiberacion", bloqueo.getFechaLiberacion().getTime()); // Convierte Calendar a Date
                    datos.put("motivo", bloqueo.getMotivo());

                    reporteDatos.add(datos);
                }

                InputStream reporteStream = getClass().getClassLoader().getResourceAsStream("reportes/Bloqueos.jrxml");
                if (reporteStream == null) {
                    throw new RuntimeException("El archivo Bloqueos.jrxml no se encuentra en la ruta especificada.");
                }
                JasperReport reporte = JasperCompileManager.compileReport(reporteStream);

                Map<String, Object> parametros = new HashMap<>();
                parametros.put("fechaInicio", inicio.getTime());
                parametros.put("fechaFinal", fin.getTime());

                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRMapCollectionDataSource(new ArrayList<Map<String, ?>>(reporteDatos)));

                JasperViewer.viewReport(jasperPrint, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona ambas fechas.");
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRegresar;
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaFinal;
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
