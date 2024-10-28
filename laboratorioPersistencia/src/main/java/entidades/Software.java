/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa un software en el sistema, que contiene información sobre su no
 *
 * @author Oley
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
     * Nombre del software.
     */
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Software() {
    }

    /**
     * Constructor que inicializa el software con un nombre específico.
     *
     * @param nombre Nombre del software
     */
    public Software(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter

    /**
     * Obtiene el identificador del software.
     * 
     * @return ID del software
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador del software.
     * 
     * @param id Nuevo ID del software
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del software.
     * 
     * @return Nombre del software
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del software.
     * 
     * @param nombre Nuevo nombre del software
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}