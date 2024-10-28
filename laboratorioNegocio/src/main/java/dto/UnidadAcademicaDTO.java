package dto;

/**
 * Clase de transferencia de datos (DTO) para representar la información de una unidad académica.
 * Esta clase se utiliza para transferir datos entre la capa de negocio y la capa de presentación, 
 * encapsulando la información de la unidad académica sin exponer la entidad directamente.
 * 
 * @autor Oley
 */
public class UnidadAcademicaDTO {

    /**
     * Identificador único de la unidad académica.
     */
    private Long id;

    /**
     * Nombre de la unidad académica.
     */
    private String nombre;

    /**
     * Constructor por defecto de la clase UnidadAcademicaDTO.
     */
    public UnidadAcademicaDTO() {
    }

    /**
     * Constructor de la clase UnidadAcademicaDTO sin el campo id.
     * 
     * @param nombre Nombre de la unidad académica.
     */
    public UnidadAcademicaDTO(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor completo de la clase UnidadAcademicaDTO.
     * 
     * @param id Identificador único de la unidad académica.
     * @param nombre Nombre de la unidad académica.
     */
    public UnidadAcademicaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
