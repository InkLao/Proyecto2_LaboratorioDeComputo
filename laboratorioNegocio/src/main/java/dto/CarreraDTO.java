package dto;

/**
 * Clase de transferencia de datos (DTO) para representar la información de una carrera.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información de la carrera sin exponer la entidad directamente.
 * 
 * @autor Oley
 */
public class CarreraDTO {
    
    /**
     * Serial version UID para asegurar la compatibilidad en la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la carrera.
     */
    private Long id;

    /**
     * Nombre de la carrera.
     */
    private String nombre;

    /**
     * Tiempo máximo de uso diario permitido en la carrera, en minutos.
     */
    private Integer tiempoMaxUsoDiario;

    /**
     * Constructor por defecto de la clase CarreraDTO.
     */
    public CarreraDTO() {
    }

    /**
     * Constructor completo de la clase CarreraDTO.
     * 
     * @param id Identificador único de la carrera.
     * @param nombre Nombre de la carrera.
     * @param tiempoMaxUsoDiario Tiempo máximo de uso diario en minutos.
     */
    public CarreraDTO(Long id, String nombre, Integer tiempoMaxUsoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    /**
     * Constructor de la clase CarreraDTO sin el campo id.
     * 
     * @param nombre Nombre de la carrera.
     * @param tiempoMaxUsoDiario Tiempo máximo de uso diario en minutos.
     */
    public CarreraDTO(String nombre, Integer tiempoMaxUsoDiario) {
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
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

    public Integer getTiempoMaxUsoDiario() {
        return tiempoMaxUsoDiario;
    }

    public void setTiempoMaxUsoDiario(Integer tiempoMaxUsoDiario) {
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }
}
