/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Arturo ITSON
 */
public class ComputadoraDTO {
 
    private long id;
    private String ip;
    private String estatus;
    private Integer numeroMaquina;
    private boolean usoAlumno;
    private Integer centroLaboratorio;
    private boolean eliminado;

    
    public ComputadoraDTO() {
    }

    public ComputadoraDTO(long id, String ip, String estatus, Integer numeroMaquina, boolean usoAlumno, Integer centroLaboratorio, boolean eliminado) {
        this.id = id;
        this.ip = ip;
        this.estatus = estatus;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.centroLaboratorio = centroLaboratorio;
        this.eliminado = eliminado;
    }

    public ComputadoraDTO(String ip, String estatus, Integer numeroMaquina, boolean usoAlumno, Integer centroLaboratorio, boolean eliminado) {
        this.ip = ip;
        this.estatus = estatus;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.centroLaboratorio = centroLaboratorio;
        this.eliminado = eliminado;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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

    public Integer getCentroLaboratorio() {
        return centroLaboratorio;
    }

    public void setCentroLaboratorio(Integer centroLaboratorio) {
        this.centroLaboratorio = centroLaboratorio;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    
    @Override
    public String toString() {
        return "ComputadoraDTO{" + "id=" + id + ", ip=" + ip + ", estatus=" + estatus + ", numeroMaquina=" + numeroMaquina + ", usoAlumno=" + usoAlumno + ", centroLaboratorio=" + centroLaboratorio + ", eliminado=" + eliminado + '}';
    }
    
    
    
    
}
