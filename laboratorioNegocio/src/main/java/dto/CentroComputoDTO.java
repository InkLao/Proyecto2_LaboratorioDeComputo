package dto;

import java.util.Calendar;

/**
 * Clase de transferencia de datos (DTO) para representar la información de un centro de cómputo.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información del centro de cómputo sin exponer la entidad directamente.
 * 
 * @autor eduar
 */
public class CentroComputoDTO {

    /**
     * Identificador único del centro de cómputo.
     */
    private Long id;

    /**
     * Nombre del centro de cómputo.
     */
    private String nombre;

    /**
     * Hora de inicio de operación del centro de cómputo.
     */
    private Calendar horaInicio;

    /**
     * Hora de cierre del centro de cómputo.
     */
    private Calendar horaFinal;

    /**
     * Contraseña maestra utilizada para administrar el centro de cómputo.
     */
    private String contraseñaMaestra;

    /**
     * Indica si el centro de cómputo está marcado como eliminado.
     */
    private boolean eliminado;

    /**
     * Información de la unidad académica a la que pertenece el centro de cómputo.
     */
    UnidadAcademicaDTO unidadAcademica;

    /**
     * Constructor por defecto de la clase CentroComputoDTO.
     */
    public CentroComputoDTO() {
    }

    /**
     * Constructor completo de la clase CentroComputoDTO.
     * 
     * @param id Identificador único del centro de cómputo.
     * @param nombre Nombre del centro de cómputo.
     * @param horaInicio Hora de inicio de operación.
     * @param horaFinal Hora de cierre.
     * @param contraseñaMaestra Contraseña maestra del centro.
     * @param eliminado Estado de eliminación del centro.
     * @param unidadAcademica Información de la unidad académica a la que pertenece.
     */
    public CentroComputoDTO(Long id, String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, boolean eliminado, UnidadAcademicaDTO unidadAcademica) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.eliminado = eliminado;
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Constructor de la clase CentroComputoDTO sin el campo id.
     * 
     * @param nombre Nombre del centro de cómputo.
     * @param horaInicio Hora de inicio de operación.
     * @param horaFinal Hora de cierre.
     * @param contraseñaMaestra Contraseña maestra del centro.
     * @param eliminado Estado de eliminación del centro.
     * @param unidadAcademica Información de la unidad académica a la que pertenece.
     */
    public CentroComputoDTO(String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, boolean eliminado, UnidadAcademicaDTO unidadAcademica) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.eliminado = eliminado;
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

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Representación en formato de texto de los datos del centro de cómputo.
     *
     * @return Una cadena de texto con los datos del centro de cómputo.
     */
    @Override
    public String toString() {
        return "CentroComputoDTO{" + "id=" + id + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", contrase\u00f1aMaestra=" + contraseñaMaestra + ", eliminado=" + eliminado + ", unidadAcademica=" + unidadAcademica + '}';
    }
}
