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
 *
 * @author Oley
 */
@Entity
@Table(name = "tblUnidadAcademica")
public class UnidadAcademica implements Serializable {

    @Id
    @Column(name = "idUnidadAcademica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name="nombre",nullable = false,length = 75)
    private String nombre;

    @OneToMany(mappedBy = "unidadAcademica")
    private List<CentroComputo> centroComputo;
    
    
    public UnidadAcademica() {
    }

    public UnidadAcademica(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<CentroComputo> getCentroComputo() {
        return centroComputo;
    }

    public void setCentroComputo(List<CentroComputo> centroComputo) {
        this.centroComputo = centroComputo;
    }
    
    
}
