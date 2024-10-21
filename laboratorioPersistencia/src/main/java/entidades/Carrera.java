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
  private  int tiempoMaxUsoDiario;
  
    public Carrera() {
    }

    public Carrera( String nombre, int tiempoMaxUsoDiario) {
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoMaxUsoDiario() {
        return tiempoMaxUsoDiario;
    }

    public void setTiempoMaxUsoDiario(int tiempoMaxUsoDiario) {
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }
    
  
  
  
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Carrera[ id=" + id + " ]";
    }
    
}
