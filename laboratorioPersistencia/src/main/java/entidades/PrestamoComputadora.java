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
 * Representa un préstamo de computadora en el sistema, que incluye información sobre la fecha 
 * del préstamo, la duración en minutos, y las asociaciones con el alumno que realiza el préstamo 
 * y la computadora que es prestada.
 * 
 * @author Arturo ITSON
 */
@Entity
@Table(name = "tblPrestamoComputadora")
public class PrestamoComputadora implements Serializable {

    /**
     * Identificador único del préstamo de computadora.
     */
    @Id
    @Column(name = "idPrestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Fecha en la que se realizó el préstamo de la computadora.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaPrestamo", nullable = false)
    private Calendar fechaPrestamo;
    
    /**
     * Duración del préstamo en minutos.
     */
    @Column(name = "minutos", nullable = false)
    private Integer minutos;
    
    /**
     * Alumno que realizó el préstamo.
     */
    @ManyToOne()
    @JoinColumn(name = "alumno")
    private Alumno alumno;
    
    /**
     * Computadora que fue prestada.
     */
    @ManyToOne()
    @JoinColumn(name = "computadora")
    private Computadora computadora;

    /**
     * Constructor vacío requerido por JPA.
     */
    public PrestamoComputadora() {
    }

    /**
     * Constructor que inicializa todos los campos del préstamo de computadora.
     *
     * @param id Identificador del préstamo
     * @param fechaPrestamo Fecha en la que se realizó el préstamo
     * @param minutos Duración del préstamo en minutos
     * @param alumno Alumno que realizó el préstamo
     * @param computadora Computadora que fue prestada
     */
    public PrestamoComputadora(Long id, Calendar fechaPrestamo, Integer minutos, Alumno alumno, Computadora computadora) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.minutos = minutos;
        this.alumno = alumno;
        this.computadora = computadora;
    }

    /**
     * Constructor que inicializa el préstamo de computadora sin un identificador específico.
     *
     * @param fechaPrestamo Fecha en la que se realizó el préstamo
     * @param minutos Duración del préstamo en minutos
     * @param alumno Alumno que realizó el préstamo
     * @param computadora Computadora que fue prestada
     */
    public PrestamoComputadora(Calendar fechaPrestamo, Integer minutos, Alumno alumno, Computadora computadora) {
        this.fechaPrestamo = fechaPrestamo;
        this.minutos = minutos;
        this.alumno = alumno;
        this.computadora = computadora;
    }

    /**
     * Obtiene el identificador del préstamo de computadora.
     * 
     * @return ID del préstamo
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador del préstamo de computadora.
     * 
     * @param id Nuevo ID del préstamo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha del préstamo de la computadora.
     * 
     * @return Fecha del préstamo
     */
    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Asigna la fecha del préstamo de la computadora.
     * 
     * @param fechaPrestamo Nueva fecha del préstamo
     */
    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Obtiene la duración del préstamo en minutos.
     * 
     * @return Duración del préstamo en minutos
     */
    public Integer getMinutos() {
        return minutos;
    }

    /**
     * Asigna la duración del préstamo en minutos.
     * 
     * @param minutos Nueva duración del préstamo
     */
    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    /**
     * Obtiene el alumno que realizó el préstamo.
     * 
     * @return Alumno que realizó el préstamo
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Asigna el alumno que realizó el préstamo.
     * 
     * @param alumno Nuevo alumno que realizó el préstamo
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Obtiene la computadora prestada.
     * 
     * @return Computadora prestada
     */
    public Computadora getComputadora() {
        return computadora;
    }

    /**
     * Asigna la computadora prestada.
     * 
     * @param computadora Nueva computadora prestada
     */
    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }

    /**
     * Representación en cadena del objeto PrestamoComputadora.
     * 
     * @return String que representa el estado del préstamo de computadora
     */
    @Override
    public String toString() {
        return "PrestamoComputadora{" + "id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", minutos=" + minutos + ", alumno=" + alumno + ", computadora=" + computadora + '}';
    }
}