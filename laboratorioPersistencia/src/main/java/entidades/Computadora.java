/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(nullable = false)
    private String estatus;
    
    @Column(nullable = false, unique = true)
    private String direccionIP;
    
    @Column(nullable = false)
    private int numeroMaquina;
    
    private List<String> softwareInstalado;

    public Computadora(Long id, String estatus, String direccionIP, int numeroMaquina, List<String> softwareInstalado) {
        this.id = id;
        this.estatus = estatus;
        this.direccionIP = direccionIP;
        this.numeroMaquina = numeroMaquina;
        this.softwareInstalado = softwareInstalado;
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

    public int getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(int numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public List<String> getSoftwareInstalado() {
        return softwareInstalado;
    }

    public void setSoftwareInstalado(List<String> softwareInstalado) {
        this.softwareInstalado = softwareInstalado;
    }

}
