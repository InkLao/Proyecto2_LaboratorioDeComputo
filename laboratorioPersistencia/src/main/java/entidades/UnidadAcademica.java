/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * Representa una unidad académica en el sistema, que contiene información sobre su nombre 
 * y una lista de centros de cómputo asociados a ella.
 * 
 * @author Oley
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
     * Nombre de la unidad académica.
     */
    @Column(name = "nombre", nullable = false, length = 75)
    private String nombre;

    /**
     * Lista de centros de cómputo asociados a la unidad académica.
     */
    @OneToMany(mappedBy = "unidadAcademica")
    private List<CentroComputo> centroComputo;
    
    /**
     * Constructor vacío requerido por JPA.
     */
    public UnidadAcademica() {
    }

    /**
     * Constructor que inicializa la unidad académica con un nombre específico.
     *
     * @param nombre Nombre de la unidad académica
     */
    public UnidadAcademica(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el identificador de la unidad académica.
     * 
     * @return ID de la unidad académica
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador de la unidad académica.
     * 
     * @param id Nuevo ID de la unidad académica
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la unidad académica.
     * 
     * @return Nombre de la unidad académica
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre de la unidad académica.
     * 
     * @param nombre Nuevo nombre de la unidad académica
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de centros de cómputo asociados a la unidad académica.
     * 
     * @return Lista de centros de cómputo
     */
    public List<CentroComputo> getCentroComputo() {
        return centroComputo;
    }

    /**
     * Asigna una nueva lista de centros de cómputo a la unidad académica.
     * 
     * @param centroComputo Lista de centros de cómputo
     */
    public void setCentroComputo(List<CentroComputo> centroComputo) {
        this.centroComputo = centroComputo;
    }
}