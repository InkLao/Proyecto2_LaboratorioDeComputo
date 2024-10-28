/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Arturo ITSON
 */
@Entity
@Table(name = "tblPrestamoComputadora")
public class PrestamoComputadora implements Serializable {

    @Id
    @Column(name = "idPrestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaPrestamo", nullable = false)
    private Calendar fechaPrestamo;
    
    @Column(name = "minutos", nullable = false)
    private Integer minutos;
    
    @Column(name = "sigueApartada")
    private boolean sigueAparta;
    
    @ManyToOne()
    @JoinColumn(name = "alumno")
    private Alumno alumno;
    
    @ManyToOne()
    @JoinColumn(name = "computadora")
    private Computadora computadora;

    
    public PrestamoComputadora() {
    }

    public PrestamoComputadora(Long id, Calendar fechaPrestamo, Integer minutos, boolean sigueApartada, Alumno alumno, Computadora computadora) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.minutos = minutos;
        this.sigueAparta = sigueApartada;
        this.alumno = alumno;
        this.computadora = computadora;
    }

    public PrestamoComputadora(Calendar fechaPrestamo, Integer minutos, boolean sigueApartada, Alumno alumno, Computadora computadora) {
        this.fechaPrestamo = fechaPrestamo;
        this.minutos = minutos;
        this.sigueAparta = sigueApartada;
        this.alumno = alumno;
        this.computadora = computadora;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Computadora getComputadora() {
        return computadora;
    }

    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }

    public boolean isSigueAparta() {
        return sigueAparta;
    }

    public void setSigueAparta(boolean sigueAparta) {
        this.sigueAparta = sigueAparta;
    }




    @Override
    public String toString() {
        return "PrestamoComputadora{" + "id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", minutos=" + minutos + ", sigueAparta=" + sigueAparta + ", alumno=" + alumno + ", computadora=" + computadora + '}';
    }


    
    
}
