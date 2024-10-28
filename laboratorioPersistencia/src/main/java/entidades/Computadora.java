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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa una computadora en el sistema, que contiene información sobre su estado, dirección IP, número de máquina, 
 * uso por alumnos, y su estado de eliminación. También tiene asociaciones con el centro de cómputo al que pertenece 
 * y una lista de préstamos realizados.
 * 
 * @author eduar
 */
@Entity
@Table(name = "computadora")
public class Computadora implements Serializable {
    
    /**
     * Identificador único de la computadora.
     */
    @Id
    @Column(name = "idComputadora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Estado actual de la computadora (e.g., disponible, en uso, en reparación).
     */
    @Column(name = "estatus", nullable = false)
    private String estatus;
    
    /**
     * Dirección IP única de la computadora.
     */
    @Column(name = "direccionIP", nullable = false, unique = true)
    private String direccionIP;
    
    /**
     * Número asignado a la computadora dentro del centro de cómputo.
     */
    @Column(name = "numeroMaquina", nullable = false)
    private Integer numeroMaquina;
    
    /**
     * Indica si la computadora está destinada para uso de alumnos.
     */
    @Column(name = "usoAlumno", nullable = false)
    private boolean usoAlumno;
    
    /**
     * Indica si la computadora ha sido marcada como eliminada.
     */
    @Column(name = "eliminado")
    private boolean eliminado;
    
    /**
     * Centro de cómputo al que pertenece esta computadora.
     */
    @ManyToOne()
    @JoinColumn(name = "centroComputo")
    private CentroComputo centroComputo;
    
    /**
     * Lista de préstamos asociados a esta computadora.
     */
    @OneToMany(mappedBy = "computadora")
    private List<PrestamoComputadora> prestamoComputadoras;
    
    /**
     * Constructor vacío requerido por JPA.
     */
    public Computadora() {
    }
    
    /**
     * Constructor que inicializa todos los campos de la computadora.
     *
     * @param id Identificador de la computadora
     * @param estatus Estado de la computadora
     * @param direccionIP Dirección IP de la computadora
     * @param numeroMaquina Número de máquina asignado
     * @param usoAlumno Indica si es para uso de alumnos
     * @param eliminado Estado de eliminación
     * @param centroComputo Centro de cómputo al que pertenece
     */
    public Computadora(Long id, String estatus, String direccionIP, Integer numeroMaquina, boolean usoAlumno, boolean eliminado, CentroComputo centroComputo) {
        this.id = id;
        this.estatus = estatus;
        this.direccionIP = direccionIP;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.eliminado = eliminado;
        this.centroComputo = centroComputo;
    }

    /**
     * Constructor que inicializa la computadora sin un identificador específico.
     *
     * @param estatus Estado de la computadora
     * @param direccionIP Dirección IP de la computadora
     * @param numeroMaquina Número de máquina asignado
     * @param usoAlumno Indica si es para uso de alumnos
     * @param eliminado Estado de eliminación
     * @param centroComputo Centro de cómputo al que pertenece
     */
    public Computadora(String estatus, String direccionIP, Integer numeroMaquina, boolean usoAlumno, boolean eliminado, CentroComputo centroComputo) {
        this.estatus = estatus;
        this.direccionIP = direccionIP;
        this.numeroMaquina = numeroMaquina;
        this.usoAlumno = usoAlumno;
        this.eliminado = eliminado;
        this.centroComputo = centroComputo;
    }


    /**
     * Obtiene el identificador de la computadora.
     * 
     * @return ID de la computadora
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador de la computadora.
     * 
     * @param id Nuevo ID de la computadora
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el estado de la computadora.
     * 
     * @return Estado de la computadora
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Asigna el estado de la computadora.
     * 
     * @param estatus Nuevo estado de la computadora
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * Obtiene la dirección IP de la computadora.
     * 
     * @return Dirección IP de la computadora
     */
    public String getDireccionIP() {
        return direccionIP;
    }

    /**
     * Asigna la dirección IP de la computadora.
     * 
     * @param direccionIP Nueva dirección IP de la computadora
     */
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    /**
     * Obtiene el número de máquina de la computadora.
     * 
     * @return Número de máquina de la computadora
     */
    public Integer getNumeroMaquina() {
        return numeroMaquina;
    }

    /**
     * Asigna el número de máquina de la computadora.
     * 
     * @param numeroMaquina Nuevo número de máquina
     */
    public void setNumeroMaquina(Integer numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    /**
     * Verifica si la computadora es para uso de alumnos.
     * 
     * @return true si es para uso de alumnos, false en caso contrario
     */
    public boolean isUsoAlumno() {
        return usoAlumno;
    }

    /**
     * Cambia el estado de uso para alumnos de la computadora.
     * 
     * @param usoAlumno Nuevo estado de uso para alumnos
     */
    public void setUsoAlumno(boolean usoAlumno) {
        this.usoAlumno = usoAlumno;
    }

    /**
     * Obtiene el centro de cómputo asociado a la computadora.
     * 
     * @return Centro de cómputo asociado
     */
    public CentroComputo getCentroComputo() {
        return centroComputo;
    }

    /**
     * Asigna el centro de cómputo asociado a la computadora.
     * 
     * @param centroComputo Nuevo centro de cómputo
     */
    public void setCentroComputo(CentroComputo centroComputo) {
        this.centroComputo = centroComputo;
    }

    /**
     * Verifica si la computadora está marcada como eliminada.
     * 
     * @return true si la computadora está eliminada, false en caso contrario
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Cambia el estado de eliminación de la computadora.
     * 
     * @param eliminado Nuevo estado de eliminación
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Obtiene la lista de préstamos asociados a esta computadora.
     * 
     * @return Lista de préstamos de computadoras
     */
    public List<PrestamoComputadora> getPrestamoComputadoras() {
        return prestamoComputadoras;
    }

    /**
     * Asigna una nueva lista de préstamos a esta computadora.
     * 
     * @param prestamoComputadoras Lista de préstamos
     */
    public void setPrestamoComputadoras(List<PrestamoComputadora> prestamoComputadoras) {
        this.prestamoComputadoras = prestamoComputadoras;
    }

    /**
     * Representación en cadena del objeto Computadora.
     * 
     * @return String que representa el estado de la computadora
     */
    @Override
    public String toString() {
        return "Computadora{" + "id=" + id + ", estatus=" + estatus + ", direccionIP=" + direccionIP + ", numeroMaquina=" + numeroMaquina + ", usoAlumno=" + usoAlumno + ", eliminado=" + eliminado + ", centroComputo=" + centroComputo + '}';
    }
}