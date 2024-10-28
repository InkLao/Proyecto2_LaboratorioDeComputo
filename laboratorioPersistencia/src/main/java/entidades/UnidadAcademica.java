package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa una Unidad Académica en el sistema. Define el nombre
 * de la unidad y su relación con los centros de cómputo asociados.
 * 
 * Esta entidad mapea a la tabla "tblUnidadAcademica" en la base de datos.
 * 
 * @autor Oley
 */
@Entity
@Table(name = "tblUnidadAcademica")
public class UnidadAcademica implements Serializable {

    /**
     * Identificador único de la unidad académica.
     */
    @Id
    @Column(name = "idUnidadAcademica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nombre de la unidad académica, con una longitud máxima de 75 caracteres.
     */
    @Column(name="nombre",nullable = false,length = 75)
    private String nombre;

    /**
     * Lista de centros de cómputo asociados a la unidad académica.
     */
    @OneToMany(mappedBy = "unidadAcademica")
    private List<CentroComputo> centroComputo;
    
    /**
     * Constructor por defecto de la clase UnidadAcademica.
     */
    public UnidadAcademica() {
    }

    /**
     * Constructor completo de la clase UnidadAcademica.
     * 
     * @param id Identificador único de la unidad académica.
     * @param nombre Nombre de la unidad académica.
     */
    public UnidadAcademica(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor de la clase UnidadAcademica sin el ID.
     * 
     * @param nombre Nombre de la unidad académica.
     */
    public UnidadAcademica(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único de la unidad académica.
     * @return El ID de la unidad académica.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la unidad académica.
     * @param id El ID de la unidad académica.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la unidad académica.
     * @return El nombre de la unidad académica.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la unidad académica.
     * @param nombre El nombre de la unidad académica.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de centros de cómputo asociados a la unidad académica.
     * @return Lista de centros de cómputo.
     */
    public List<CentroComputo> getCentroComputo() {
        return centroComputo;
    }

    /**
     * Establece la lista de centros de cómputo asociados a la unidad académica.
     * @param centroComputo Lista de centros de cómputo.
     */
    public void setCentroComputo(List<CentroComputo> centroComputo) {
        this.centroComputo = centroComputo;
    }
}
