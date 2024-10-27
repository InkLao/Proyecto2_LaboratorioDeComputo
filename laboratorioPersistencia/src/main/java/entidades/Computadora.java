/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@Entity
@Table(name = "computadora")
public class Computadora implements Serializable {
    
    @Id
    @Column(name = "idComputadora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "estatus", nullable = false)
    private String estatus;
    
    @Column(name = "direccionIP", nullable = false, unique = true)
    private String direccionIP;
    
    @Column(name = "numeroMaquina", nullable = false)
    private Integer numeroMaquina;
    
    @Column(name = "usoAlumno", nullable = false)
    private boolean usoAlumno;
    
    @Column(name = "eliminado")
    private boolean eliminado;
    

    @ManyToOne()
    @JoinColumn(name = "centroComputo")
    private CentroComputo centroComputo;
    
    public Computadora() {
    }
    

    public Computadora(Long id, String estatus, String direccionIP, Integer numeroMaquina, boolean usoAlumno, boolean eliminado, CentroComputo centroComputo) {
        this.id = id;
        this.estatus = estatus;
        this.direccionIP = direccionIP;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.eliminado = eliminado;
        this.centroComputo = centroComputo;
    }

    public Computadora(String estatus, String direccionIP, Integer numeroMaquina, boolean usoAlumno, boolean eliminado, CentroComputo centroComputo) {
        this.estatus = estatus;
        this.direccionIP = direccionIP;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.eliminado = eliminado;
        this.centroComputo = centroComputo;
    }




    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public Integer getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(Integer numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public boolean isUsoAlumno() {
        return usoAlumno;
    }

    public void setUsoAlumno(boolean usoAlumno) {
        this.usoAlumno = usoAlumno;
    }

    public CentroComputo getCentroComputo() {
        return centroComputo;
    }

    public void setCentroComputo(CentroComputo centroComputo) {
        this.centroComputo = centroComputo;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "Computadora{" + "id=" + id + ", estatus=" + estatus + ", direccionIP=" + direccionIP + ", numeroMaquina=" + numeroMaquina + ", usoAlumno=" + usoAlumno + ", eliminado=" + eliminado + ", centroComputo=" + centroComputo + '}';
    }
    
    
    
    
}
