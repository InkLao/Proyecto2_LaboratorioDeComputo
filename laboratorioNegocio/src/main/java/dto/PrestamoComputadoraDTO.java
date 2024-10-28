/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;

/**
 *
 * @author Arturo ITSON
 */
public class PrestamoComputadoraDTO {
    
    private long id;
    private long idAlumno;
    private long idComputadora;
    private Integer numMaquina;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer minutos;
    private Calendar fechaPrestamo;
    private boolean sigueApartada;
    
    public PrestamoComputadoraDTO() {
    }

    public PrestamoComputadoraDTO(long idAlumno, long idComputadora, Integer numMaquina, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.idAlumno = idAlumno;
        this.idComputadora = idComputadora;
        this.numMaquina = numMaquina;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public PrestamoComputadoraDTO(long idAlumno, long idComputadora, Integer minutos, Calendar fechaPrestamo, boolean sigueApartada) {
        this.idAlumno = idAlumno;
        this.idComputadora = idComputadora;
        this.minutos = minutos;
        this.fechaPrestamo = fechaPrestamo;
        this.sigueApartada = sigueApartada;
    }

    public PrestamoComputadoraDTO(long id, long idAlumno, long idComputadora, Integer minutos, Calendar fechaPrestamo, boolean sigueApartada) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idComputadora = idComputadora;
        this.minutos = minutos;
        this.fechaPrestamo = fechaPrestamo;
        this.sigueApartada = sigueApartada;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    
    

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(long idComputadora) {
        this.idComputadora = idComputadora;
    }

    public Integer getNumMaquina() {
        return numMaquina;
    }

    public void setNumMaquina(Integer numMaquina) {
        this.numMaquina = numMaquina;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public boolean isSigueApartada() {
        return sigueApartada;
    }

    public void setSigueApartada(boolean sigueApartada) {
        this.sigueApartada = sigueApartada;
    }
    
    
    
}
