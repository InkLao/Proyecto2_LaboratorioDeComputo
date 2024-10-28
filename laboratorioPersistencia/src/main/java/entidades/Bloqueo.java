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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contiene información sobre la fecha de inicio y liberación del bloqueo, el
 * motivo, y el estado de eliminación. Esta clase es una entidad de JPA para
 * interactuar con la base de datos.
 *
 * @author Oley
 */
@Entity
@Table(name = "tblBloqueo")
public class Bloqueo implements Serializable {

    /**
     * Identificador único del bloqueo.
     */
    @Id
    @Column(name = "idBloqueo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Motivo del bloqueo.
     */
    @Column(name = "motivo", nullable = false, length = 50)
    private String motivo;

    /**
     * Fecha en la que se aplicó el bloqueo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaBloqueo", nullable = false)
    private Calendar fechaBloqueo;

    /**
     * Fecha en la que se liberará o se liberó el bloqueo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaLiberacion", nullable = false)
    private Calendar fechaLiberacion;

    /**
     * Indica si el bloqueo ha sido marcado como eliminado.
     */
    @Column(name = "Eliminado", nullable = false)
    private boolean eliminado;

    /**
     * Alumno asociado al bloqueo.
     */
    @ManyToOne()
    @JoinColumn(name = "alumno")
    private Alumno alumno;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Bloqueo() {
    }

    /**
     * Constructor que inicializa todos los campos del bloqueo.
     *
     * @param id Identificador del bloqueo
     * @param fechaBloqueo Fecha de aplicación del bloqueo
     * @param fechaLiberacion Fecha de liberación del bloqueo
     * @param motivo Motivo del bloqueo
     * @param eliminado Estado de eliminación del bloqueo
     * @param alumno Alumno asociado al bloqueo
     */
    public Bloqueo(Long id, Calendar fechaBloqueo, Calendar fechaLiberacion, String motivo, boolean eliminado, Alumno alumno) {
        this.id = id;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = eliminado;
        this.alumno = alumno;
    }

    /**
     * Constructor que inicializa el bloqueo sin un identificador específico.
     *
     * @param motivo Motivo del bloqueo
     * @param fechaBloqueo Fecha de aplicación del bloqueo
     * @param fechaLiberacion Fecha de liberación del bloqueo
     * @param Eliminado Estado de eliminación del bloqueo
     * @param alumno Alumno asociado al bloqueo
     */
    public Bloqueo(String motivo, Calendar fechaBloqueo, Calendar fechaLiberacion, boolean Eliminado, Alumno alumno) {
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = Eliminado;
        this.alumno = alumno;
    }


    /**
     * Obtiene el identificador del bloqueo.
     *
     * @return ID del bloqueo
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador del bloqueo.
     *
     * @param id Nuevo ID del bloqueo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el motivo del bloqueo.
     *
     * @return Motivo del bloqueo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Asigna el motivo del bloqueo.
     *
     * @param motivo Nuevo motivo del bloqueo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha de aplicación del bloqueo.
     *
     * @return Fecha de aplicación del bloqueo
     */
    public Calendar getFechaBloqueo() {
        return fechaBloqueo;
    }

    /**
     * Asigna la fecha de aplicación del bloqueo.
     *
     * @param fechaBloqueo Nueva fecha de aplicación del bloqueo
     */
    public void setFechaBloqueo(Calendar fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    /**
     * Obtiene la fecha de liberación del bloqueo.
     *
     * @return Fecha de liberación del bloqueo
     */
    public Calendar getFechaLiberacion() {
        return fechaLiberacion;
    }

    /**
     * Asigna la fecha de liberación del bloqueo.
     *
     * @param fechaLiberacion Nueva fecha de liberación del bloqueo
     */
    public void setFechaLiberacion(Calendar fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    /**
     * Obtiene el alumno asociado al bloqueo.
     *
     * @return Alumno asociado al bloqueo
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Asigna el alumno asociado al bloqueo.
     *
     * @param alumno Nuevo alumno asociado al bloqueo
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Verifica si el bloqueo está marcado como eliminado.
     *
     * @return true si el bloqueo está eliminado, false en caso contrario
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Cambia el estado de eliminación del bloqueo.
     *
     * @param eliminado Nuevo estado de eliminación del bloqueo
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Representación en cadena del objeto Bloqueo.
     *
     * @return String que representa el estado del bloqueo
     */
    @Override
    public String toString() {
        return "Bloqueo{" + "id=" + id + ", motivo=" + motivo + ", fechaBloqueo=" + fechaBloqueo + ", fechaLiberacion=" + fechaLiberacion + ", eliminado=" + eliminado + ", alumno=" + alumno + '}';
    }
}
