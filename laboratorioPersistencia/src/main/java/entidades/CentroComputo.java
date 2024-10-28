/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa un centro de cómputo en el sistema, que contiene información sobre su nombre, 
 * horario de funcionamiento, contraseña maestra y su estado de eliminación.
 * También tiene asociaciones con una unidad académica y una lista de computadoras.
 * 
 * @author Oley
 */
@Entity
@Table(name = "tblCentroComputo")
public class CentroComputo implements Serializable {

    /**
     * Identificador único del centro de cómputo.
     */
    @Id
    @Column(name = "idCentroComputo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del centro de cómputo.
     */
    @Column(name = "nombre", length = 75, nullable = false)
    private String nombre;

    /**
     * Hora de inicio de operaciones del centro de cómputo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "horaInicio", nullable = false)
    private Calendar horaInicio;

    /**
     * Hora de finalización de operaciones del centro de cómputo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "horaFinal", nullable = false)
    private Calendar horaFinal;

    /**
     * Contraseña maestra para acceder a configuraciones avanzadas del centro de cómputo.
     */
    @Column(name = "contraMaestra", length = 25, nullable = false)
    private String contraseñaMaestra;
    
    /**
     * Indica si el centro de cómputo ha sido marcado como eliminado.
     */
    @Column(name = "Eliminado")
    private boolean eliminado;

    /**
     * Unidad académica asociada al centro de cómputo.
     */
    @OneToOne()
    UnidadAcademica unidadAcademica;
    
    /**
     * Lista de computadoras disponibles en el centro de cómputo.
     */
    @OneToMany(mappedBy = "centroComputo")
    private List<Computadora> computadora;
    
    /**
     * Constructor vacío requerido por JPA.
     */
    public CentroComputo() {
    }

    /**
     * Constructor que inicializa todos los campos del centro de cómputo.
     *
     * @param id Identificador del centro de cómputo
     * @param nombre Nombre del centro de cómputo
     * @param horaInicio Hora de inicio de operaciones
     * @param horaFinal Hora de finalización de operaciones
     * @param contraseñaMaestra Contraseña maestra para el centro de cómputo
     * @param eliminado Estado de eliminación del centro de cómputo
     * @param unidadAcademica Unidad académica asociada
     */
    public CentroComputo(Long id, String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, boolean eliminado, UnidadAcademica unidadAcademica) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.eliminado = eliminado;
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Constructor que inicializa el centro de cómputo sin un identificador específico.
     *
     * @param nombre Nombre del centro de cómputo
     * @param horaInicio Hora de inicio de operaciones
     * @param horaFinal Hora de finalización de operaciones
     * @param contraseñaMaestra Contraseña maestra para el centro de cómputo
     * @param eliminado Estado de eliminación del centro de cómputo
     * @param unidadAcademica Unidad académica asociada
     */
    public CentroComputo(String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, boolean eliminado, UnidadAcademica unidadAcademica) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.eliminado = eliminado;
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Obtiene el identificador del centro de cómputo.
     * 
     * @return ID del centro de cómputo
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador del centro de cómputo.
     * 
     * @param id Nuevo ID del centro de cómputo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del centro de cómputo.
     * 
     * @return Nombre del centro de cómputo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del centro de cómputo.
     * 
     * @param nombre Nuevo nombre del centro de cómputo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la hora de inicio de operaciones del centro de cómputo.
     * 
     * @return Hora de inicio de operaciones
     */
    public Calendar getHoraInicio() {
        return horaInicio;
    }

    /**
     * Asigna la hora de inicio de operaciones del centro de cómputo.
     * 
     * @param horaInicio Nueva hora de inicio
     */
    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de finalización de operaciones del centro de cómputo.
     * 
     * @return Hora de finalización de operaciones
     */
    public Calendar getHoraFinal() {
        return horaFinal;
    }

    /**
     * Asigna la hora de finalización de operaciones del centro de cómputo.
     * 
     * @param horaFinal Nueva hora de finalización
     */
    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * Obtiene la contraseña maestra del centro de cómputo.
     * 
     * @return Contraseña maestra
     */
    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    /**
     * Asigna la contraseña maestra del centro de cómputo.
     * 
     * @param contraseñaMaestra Nueva contraseña maestra
     */
    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }

    /**
     * Obtiene la unidad académica asociada al centro de cómputo.
     * 
     * @return Unidad académica asociada
     */
    public UnidadAcademica getUnidadAcademica() {
        return unidadAcademica;
    }

    /**
     * Asigna la unidad académica asociada al centro de cómputo.
     * 
     * @param unidadAcademica Nueva unidad académica
     */
    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Verifica si el centro de cómputo está marcado como eliminado.
     * 
     * @return true si el centro de cómputo está eliminado, false en caso contrario
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Cambia el estado de eliminación del centro de cómputo.
     * 
     * @param eliminado Nuevo estado de eliminación
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Obtiene la lista de computadoras en el centro de cómputo.
     * 
     * @return Lista de computadoras
     */
    public List<Computadora> getComputadora() {
        return computadora;
    }

    /**
     * Asigna una nueva lista de computadoras al centro de cómputo.
     * 
     * @param computadora Lista de computadoras
     */
    public void setComputadora(List<Computadora> computadora) {
        this.computadora = computadora;
    }
}