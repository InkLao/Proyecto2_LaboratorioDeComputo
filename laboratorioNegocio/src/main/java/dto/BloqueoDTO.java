package dto;

import java.util.Calendar;

/**
 * Clase de transferencia de datos (DTO) para representar la información de un bloqueo.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información del bloqueo sin exponer la entidad directamente.
 * 
 * @autor Arturo ITSON
 */
public class BloqueoDTO {
    
    /**
     * Identificador único del bloqueo.
     */
    private long id;

    /**
     * Fecha en que se realiza el bloqueo.
     */
    private Calendar fechaBloqueo;

    /**
     * Fecha en que el bloqueo será liberado.
     */
    private Calendar fechaLiberacion;

    /**
     * Motivo por el cual se ha realizado el bloqueo.
     */
    private String motivo;

    /**
     * Indica si el bloqueo está marcado como eliminado.
     */
    private boolean eliminado;

    /**
     * Identificador del alumno asociado al bloqueo.
     */
    private long Alumno;

    /**
     * Constructor por defecto de la clase BloqueoDTO.
     */
    public BloqueoDTO() {
    }

    /**
     * Constructor completo de la clase BloqueoDTO.
     * 
     * @param id Identificador único del bloqueo.
     * @param fechaBloqueo Fecha en que se realiza el bloqueo.
     * @param fechaLiberacion Fecha en que el bloqueo será liberado.
     * @param motivo Motivo del bloqueo.
     * @param eliminado Estado de eliminación del bloqueo.
     * @param Alumno Identificador del alumno asociado al bloqueo.
     */
    public BloqueoDTO(long id, Calendar fechaBloqueo, Calendar fechaLiberacion, String motivo, boolean eliminado, long Alumno) {
        this.id = id;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.Alumno = Alumno;
        this.eliminado = eliminado;
    }

    /**
     * Constructor de la clase BloqueoDTO sin el campo id.
     * 
     * @param fechaBloqueo Fecha en que se realiza el bloqueo.
     * @param fechaLiberacion Fecha en que el bloqueo será liberado.
     * @param motivo Motivo del bloqueo.
     * @param eliminado Estado de eliminación del bloqueo.
     * @param Alumno Identificador del alumno asociado al bloqueo.
     */
    public BloqueoDTO(Calendar fechaBloqueo, Calendar fechaLiberacion, String motivo, boolean eliminado, long Alumno) {
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = eliminado;
        this.Alumno = Alumno;
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

    /**
     * Representación en formato de texto de los datos del bloqueo.
     *
     * @return Una cadena de texto con los datos del bloqueo.
     */
    @Override
    public String toString() {
        return "BloqueoDTO{" + "id=" + id + ", fechaBloqueo=" + fechaBloqueo + ", fechaLiberacion=" + fechaLiberacion + ", motivo=" + motivo + ", eliminado=" + eliminado + ", Alumno=" + Alumno + '}';
    }
}
