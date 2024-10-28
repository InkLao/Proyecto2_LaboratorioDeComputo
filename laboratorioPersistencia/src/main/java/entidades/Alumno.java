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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa un alumno en el sistema, que contiene información personal, su
 * estado de eliminación, y sus asociaciones con la carrera, bloqueos y
 * préstamos de computadoras.
 *
 * @author Oley
 */
@Entity
@Table(name = "tblAlumno")
public class Alumno implements Serializable {

    /**
     * Identificador único del alumno.
     */
    @Id
    @Column(name = "idAlumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombres del alumno.
     */
    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    /**
     * Apellido paterno del alumno.
     */
    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;

    /**
     * Apellido materno del alumno.
     */
    @Column(name = "apellidoMaterno", length = 50, nullable = false)
    private String apellidoMaterno;

    /**
     * Contraseña del alumno para acceder al sistema.
     */
    @Column(name = "contraseña", length = 50, nullable = false)
    private String contraseña;

    /**
     * Indica si el alumno está marcado como eliminado en el sistema.
     */
    @Column(name = "estaEliminado", nullable = false)
    private boolean estaEliminado;

    /**
     * Carrera asociada al alumno.
     */
    @OneToOne()
    private Carrera carrera;

    /**
     * Lista de bloqueos asociados al alumno.
     */
    @OneToMany(mappedBy = "alumno")
    private List<Bloqueo> bloqueos;

    /**
     * Lista de préstamos de computadoras realizados por el alumno.
     */
    @OneToMany(mappedBy = "alumno")
    private List<PrestamoComputadora> prestamoComputadoras;

    /**
     * Constructor vacío para JPA.
     */
    public Alumno() {
    }

    /**
     * Constructor que inicializa todos los campos del alumno.
     *
     * @param id Identificador del alumno
     * @param nombres Nombres del alumno
     * @param apellidoPaterno Apellido paterno del alumno
     * @param apellidoMaterno Apellido materno del alumno
     * @param contraseña Contraseña del alumno
     * @param estaEliminado Estado de eliminación del alumno
     * @param carrera Carrera asociada al alumno
     */
    public Alumno(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, boolean estaEliminado, Carrera carrera) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.estaEliminado = estaEliminado;
        this.carrera = carrera;
    }

//    public Alumno(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, Carrera carrera) {
//        this.id = id;
//        this.nombres = nombres;
//        this.apellidoPaterno = apellidoPaterno;
//        this.apellidoMaterno = apellidoMaterno;
//        this.contraseña = contraseña;
//        this.carrera = carrera;
//    }
//
//    public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, boolean estaEliminado, Carrera carrera) {
//        this.nombres = nombres;
//        this.apellidoPaterno = apellidoPaterno;
//        this.apellidoMaterno = apellidoMaterno;
//        this.contraseña = contraseña;
//        this.estaEliminado = estaEliminado;
//        this.carrera = carrera;
//    }
//
//    public Alumno(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, boolean estaEliminado, Carrera carrera) {
//        this.id = id;
//        this.nombres = nombres;
//        this.apellidoPaterno = apellidoPaterno;
//        this.apellidoMaterno = apellidoMaterno;
//        this.contraseña = contraseña;
//        this.estaEliminado = estaEliminado;
//        this.carrera = carrera;
//    }
//
//    public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, Carrera carrera) {
//        this.nombres = nombres;
//        this.apellidoPaterno = apellidoPaterno;
//        this.apellidoMaterno = apellidoMaterno;
//        this.contraseña = contraseña;
//        this.carrera = carrera;
//    }
    
    /**
     * Obtiene el identificador del alumno.
     *
     * @return ID del alumno
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador del alumno.
     *
     * @param id Nuevo ID del alumno
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres del alumno.
     *
     * @return Nombres del alumno
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Asigna los nombres del alumno.
     *
     * @param nombres Nuevos nombres del alumno
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del alumno.
     *
     * @return Apellido paterno del alumno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Asigna el apellido paterno del alumno.
     *
     * @param apellidoPaterno Nuevo apellido paterno del alumno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del alumno.
     *
     * @return Apellido materno del alumno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Asigna el apellido materno del alumno.
     *
     * @param apellidoMaterno Nuevo apellido materno del alumno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la contraseña del alumno.
     *
     * @return Contraseña del alumno
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Asigna la contraseña del alumno.
     *
     * @param contraseña Nueva contraseña del alumno
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la carrera asociada al alumno.
     *
     * @return Carrera del alumno
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * Asigna la carrera del alumno.
     *
     * @param carrera Nueva carrera del alumno
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * Verifica si el alumno está marcado como eliminado.
     *
     * @return true si el alumno está eliminado, false en caso contrario
     */
    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    /**
     * Cambia el estado de eliminación del alumno.
     *
     * @param estaEliminado Nuevo estado de eliminación del alumno
     */
    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    /**
     * Obtiene la lista de bloqueos asociados al alumno.
     *
     * @return Lista de bloqueos del alumno
     */
    public List<Bloqueo> getBloqueos() {
        return bloqueos;
    }

    /**
     * Asigna una nueva lista de bloqueos al alumno.
     *
     * @param bloqueos Lista de bloqueos
     */
    public void setBloqueos(List<Bloqueo> bloqueos) {
        this.bloqueos = bloqueos;
    }

    /**
     * Obtiene la lista de préstamos de computadoras realizados por el alumno.
     *
     * @return Lista de préstamos de computadoras
     */
    public List<PrestamoComputadora> getPrestamoComputadoras() {
        return prestamoComputadoras;
    }

    /**
     * Asigna una nueva lista de préstamos de computadoras al alumno.
     *
     * @param prestamoComputadoras Lista de préstamos de computadoras
     */
    public void setPrestamoComputadoras(List<PrestamoComputadora> prestamoComputadoras) {
        this.prestamoComputadoras = prestamoComputadoras;
    }
}
