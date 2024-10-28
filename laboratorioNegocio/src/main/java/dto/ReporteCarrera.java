/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Oley
 */

/**
 * Clase que representa un reporte de una carrera.
 * 
 * Contiene información sobre el nombre de la carrera, 
 * el tiempo de uso en minutos y la cantidad de alumnos.
 */
public class ReporteCarrera {
    private String nombreCarrera; // Nombre de la carrera
    private Integer minutosUso; // Tiempo de uso en minutos
    private Long cantidadAlumnos; // Cantidad de alumnos en la carrera
  /**
     * Constructor por defecto.
     */
    public ReporteCarrera() {
    }
  /**
     * Constructor que inicializa los atributos de la carrera.
     *
     * @param nombreCarrera Nombre de la carrera.
     * @param minutosUso    Tiempo de uso en minutos.
     * @param cantidadAlumnos Cantidad de alumnos en la carrera.
     */
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

