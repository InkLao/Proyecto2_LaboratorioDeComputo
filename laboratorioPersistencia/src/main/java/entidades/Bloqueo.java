/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Oley
 */
@Entity
@Table(name = "tblBloqueo")
public class Bloqueo implements Serializable {

    @Id
    @Column(name = "idBloqueo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name = "motivo", nullable = false, length = 50)
    private  String motivo;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaBloqueo", nullable = false)
    private Calendar fechaBloqueo;

    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaLiberacion", nullable = false)
    private Calendar fechaLiberacion;
    
    @Column(name = "Eliminado", nullable = false)
    private boolean eliminado;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Alumno alumno;
    
    
    public Bloqueo() {
    }

    public Bloqueo(Long id, Calendar fechaBloqueo, Calendar fechaLiberacion, String motivo, boolean eliminado, Alumno alumno) {
        this.id = id;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = eliminado;
        this.alumno = alumno;
    }

    public Bloqueo(String motivo, Calendar fechaBloqueo, Calendar fechaLiberacion, boolean Eliminado, Alumno alumno) {
        
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = Eliminado;
        this.alumno = alumno;
    }



    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }



  
}
