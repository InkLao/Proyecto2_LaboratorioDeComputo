package dto;

import java.util.Calendar;

/**
 * Clase de transferencia de datos (DTO) para representar la información de un préstamo de computadora.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información del préstamo de computadora sin exponer la entidad directamente.
 * 
 * @autor Arturo ITSON
 */
public class PrestamoComputadoraDTO {
    
    /**
     * Identificador único del préstamo de computadora.
     */
    private long id;

    /**
     * Identificador del alumno asociado al préstamo.
     */
    private long idAlumno;

    /**
     * Identificador de la computadora asociada al préstamo.
     */
    private long idComputadora;

    /**
     * Número de la máquina asignada a la computadora prestada.
     */
    private Integer numMaquina;

    /**
     * Nombres del alumno que realiza el préstamo.
     */
    private String nombres;

    /**
     * Apellido paterno del alumno que realiza el préstamo.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del alumno que realiza el préstamo.
     */
    private String apellidoMaterno;

    /**
     * Duración del préstamo en minutos.
     */
    private Integer minutos;

    /**
     * Fecha en que se realizó el préstamo.
     */
    private Calendar fechaPrestamo;

    /**
     * Indica si la computadora sigue apartada.
     */
    private boolean sigueApartada;

    /**
     * Constructor por defecto de la clase PrestamoComputadoraDTO.
     */
    public PrestamoComputadoraDTO() {
    }

    /**
     * Constructor de la clase PrestamoComputadoraDTO con detalles del alumno y computadora, sin minutos y fecha.
     * 
     * @param idAlumno Identificador del alumno.
     * @param idComputadora Identificador de la computadora.
     * @param numMaquina Número de la máquina de la computadora.
     * @param nombres Nombres del alumno.
     * @param apellidoPaterno Apellido paterno del alumno.
     * @param apellidoMaterno Apellido materno del alumno.
     */
    public PrestamoComputadoraDTO(long idAlumno, long idComputadora, Integer numMaquina, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.idAlumno = idAlumno;
        this.idComputadora = idComputadora;
        this.numMaquina = numMaquina;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Constructor de la clase PrestamoComputadoraDTO con detalles de préstamo, sin ID.
     * 
     * @param idAlumno Identificador del alumno.
     * @param idComputadora Identificador de la computadora.
     * @param minutos Duración del préstamo en minutos.
     * @param fechaPrestamo Fecha en que se realizó el préstamo.
     * @param sigueApartada Indica si la computadora sigue apartada.
     */
    public PrestamoComputadoraDTO(long idAlumno, long idComputadora, Integer minutos, Calendar fechaPrestamo, boolean sigueApartada) {
        this.idAlumno = idAlumno;
        this.idComputadora = idComputadora;
        this.minutos = minutos;
        this.fechaPrestamo = fechaPrestamo;
        this.sigueApartada = sigueApartada;
    }

    /**
     * Constructor completo de la clase PrestamoComputadoraDTO.
     * 
     * @param id Identificador del préstamo.
     * @param idAlumno Identificador del alumno.
     * @param idComputadora Identificador de la computadora.
     * @param minutos Duración del préstamo en minutos.
     * @param fechaPrestamo Fecha en que se realizó el préstamo.
     * @param sigueApartada Indica si la computadora sigue apartada.
     */
    public PrestamoComputadoraDTO(long id, long idAlumno, long idComputadora, Integer minutos, Calendar fechaPrestamo, boolean sigueApartada) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idComputadora = idComputadora;
        this.minutos = minutos;
        this.fechaPrestamo = fechaPrestamo;
        this.sigueApartada = sigueApartada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(long idComputadora) {
        this.idComputadora = idComputadora;
    }

    public Integer getNumMaquina() {
        return numMaquina;
    }

    public void setNumMaquina(Integer numMaquina) {
        this.numMaquina = numMaquina;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public boolean isSigueApartada() {
        return sigueApartada;
    }

    public void setSigueApartada(boolean sigueApartada) {
        this.sigueApartada = sigueApartada;
    }

    /**
     * Representación en formato de texto de los datos del préstamo de computadora.
     *
     * @return Una cadena de texto con los datos del préstamo.
     */
    @Override
    public String toString() {
        return "PrestamoComputadoraDTO{" + "id=" + id + ", idAlumno=" + idAlumno + ", idComputadora=" + idComputadora + ", minutos=" + minutos + ", fechaPrestamo=" + fechaPrestamo + ", sigueApartada=" + sigueApartada + '}';
    }
}
