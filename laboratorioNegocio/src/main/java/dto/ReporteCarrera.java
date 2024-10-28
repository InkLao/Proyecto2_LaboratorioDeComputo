/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Oley
 */
public class ReporteCarrera {
    private String nombreCarrera;
    private Integer minutosUso;
    private Long cantidadAlumnos;

    public ReporteCarrera() {
    }

    public ReporteCarrera(String nombreCarrera, Integer minutosUso, Long cantidadAlumnos) {
        this.nombreCarrera = nombreCarrera;
        this.minutosUso = minutosUso;
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Integer getMinutosUso() {
        return minutosUso;
    }

    public void setMinutosUso(Integer minutosUso) {
        this.minutosUso = minutosUso;
    }

    public Long getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(Long cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    }

