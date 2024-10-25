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
public class BloqueoDTO {
    
    private long id;
    private Calendar fechaBloqueo;
    private Calendar fechaLiberacion;
    private String motivo;
    private boolean eliminado;
    private long Alumno;

    
    public BloqueoDTO() {
    }

    
    public BloqueoDTO(long id, Calendar fechaBloqueo, Calendar fechaLiberacion, String motivo, boolean eliminado, long Alumno) {
        this.id = id;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.Alumno = Alumno;
        this.eliminado = eliminado;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(Calendar fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    public Calendar getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(Calendar fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public long getAlumno() {
        return Alumno;
    }

    public void setAlumno(long Alumno) {
        this.Alumno = Alumno;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "BloqueoDTO{" + "id=" + id + ", fechaBloqueo=" + fechaBloqueo + ", fechaLiberacion=" + fechaLiberacion + ", motivo=" + motivo + ", eliminado=" + eliminado + ", Alumno=" + Alumno + '}';
    }
    
    
    
    
    
    
    
    
    
}
