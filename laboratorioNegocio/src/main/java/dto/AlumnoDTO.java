package dto;

/**
 * Clase de transferencia de datos (DTO) para representar información de un alumno.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información del alumno sin exponer la entidad directamente.
 * 
 * @autor Oley
 */
public class AlumnoDTO {
    
    /**
     * Identificador único del alumno.
     */
    private Long id;

    /**
     * Nombres del alumno.
     */
    private String nombres;

    /**
     * Apellido paterno del alumno.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del alumno.
     */
    private String apellidoMaterno;

    /**
     * Contraseña del alumno.
     */
    private String contraseña;

    /**
     * Información de la carrera del alumno.
     */
    private CarreraDTO carrera;

    /**
     * Indica si el alumno está marcado como eliminado.
     */
    private boolean estaEliminado;

    /**
     * Constructor por defecto de la clase AlumnoDTO.
     */
    public AlumnoDTO() {
    }

    /**
     * Constructor de la clase AlumnoDTO sin ID y estado eliminado.
     * 
     * @param nombres Nombres del alumno.
     * @param apellidoPaterno Apellido paterno del alumno.
     * @param apellidoMaterno Apellido materno del alumno.
     * @param contraseña Contraseña del alumno.
     * @param carrera Información de la carrera del alumno.
     */
    public AlumnoDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, CarreraDTO carrera) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.carrera = carrera;
    }

    /**
     * Constructor completo de la clase AlumnoDTO.
     * 
     * @param id Identificador único del alumno.
     * @param nombres Nombres del alumno.
     * @param apellidoPaterno Apellido paterno del alumno.
     * @param apellidoMaterno Apellido materno del alumno.
     * @param contraseña Contraseña del alumno.
     * @param carrera Información de la carrera del alumno.
     * @param estaEliminado Estado de eliminación del alumno.
     */
    public AlumnoDTO(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, CarreraDTO carrera, boolean estaEliminado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.carrera = carrera;
        this.estaEliminado = estaEliminado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }
}
