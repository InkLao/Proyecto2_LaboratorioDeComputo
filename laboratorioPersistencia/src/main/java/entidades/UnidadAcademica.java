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
 *
 * @author Oley
 */
@Entity
@Table(name = "tblUnidadAcademica")
public class UnidadAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idUnidadAcademica")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nombre",nullable = false,length = 75)
    private String nombre;

    public UnidadAcademica() {
    }

    public UnidadAcademica(String nombre) {
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
