/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.UnidadAcademica;
import java.util.Calendar;

/**
 *
 * @author eduar
 */
public class CentroComputoDTO {

    private Long id;
    private String nombre;
    private Calendar horaInicio;
    private Calendar horaFinal;
    private String contraseñaMaestra; 
    UnidadAcademicaDTO unidadAcademica;

    public CentroComputoDTO() {
        
    }

    public CentroComputoDTO(Long id, String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, UnidadAcademicaDTO unidadAcademica) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.unidadAcademica = unidadAcademica;
    }

    public CentroComputoDTO(String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, UnidadAcademicaDTO unidadAcademica) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.unidadAcademica = unidadAcademica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }

    public UnidadAcademicaDTO getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademicaDTO(UnidadAcademicaDTO unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
}
