package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa un Software en el sistema. Define los detalles básicos del software,
 * como el nombre, y se utiliza para registrar y gestionar software en el centro de cómputo.
 * 
 * Esta entidad mapea a la tabla "tblSoftware" en la base de datos.
 * 
 * @autor Oley
 */
@Entity
@Table(name = "tblSoftware")
public class Software implements Serializable {

    /**
     * Identificador único del software.
     */
    @Id
    @Column(name = "idSoftware")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del software, con una longitud máxima de 50 caracteres.
     */
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    /**
     * Constructor por defecto de la clase Software.
     */
    public Software() {
    }

    /**
     * Constructor de la clase Software.
     * 
     * @param nombre Nombre del software.
     */
    public Software(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único del software.
     * @return El ID del software.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del software.
     * @param id El ID del software.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del software.
     * @return El nombre del software.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del software.
     * @param nombre El nombre del software.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
