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
@Table(name = "tblCarrera")
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idCarrera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombreCarrera",nullable = false)
    private String nombre;
  
    @Column(name = "  tiempoMaxUsoDiario")
    private Integer tiempoMaxUsoDiario;
    
    
    public Carrera() {
    }

    public Carrera(Long id, String nombre, Integer tiempoMaxUsoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    public Carrera(String nombre, Integer tiempoMaxUsoDiario) {
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
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
    
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
