/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa una carrera académica en el sistema, que incluye su nombre, el tiempo máximo de uso diario permitido, 
 * y su lista de alumnos asociados. Esta clase es una entidad de JPA para interactuar con la base de datos.
 * 
 * @author Oley
 */
@Entity
@Table(name = "tblCarrera")
public class Carrera implements Serializable {

    /**
     * Identificador único de la carrera.
     */
    @Id
    @Column(name = "idCarrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la carrera.
     */
    @Column(name = "nombreCarrera", nullable = false)
    private String nombre;
  
    /**
     * Tiempo máximo de uso diario permitido para esta carrera.
     */
    @Column(name = "tiempoMaxUsoDiario")
    private Integer tiempoMaxUsoDiario;
    
    /**
     * Lista de alumnos asociados a esta carrera.
     */
    @OneToMany(mappedBy = "carrera")
    private List<Alumno> alumno;
    
    /**
     * Constructor vacío requerido por JPA.
     */
    public Carrera() {
    }

    /**
     * Constructor que inicializa todos los campos de la carrera.
     *
     * @param id Identificador de la carrera
     * @param nombre Nombre de la carrera
     * @param tiempoMaxUsoDiario Tiempo máximo de uso diario permitido
     */
    public Carrera(Long id, String nombre, Integer tiempoMaxUsoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    /**
     * Constructor que inicializa la carrera sin un identificador específico.
     *
     * @param nombre Nombre de la carrera
     * @param tiempoMaxUsoDiario Tiempo máximo de uso diario permitido
     */
    public Carrera(String nombre, Integer tiempoMaxUsoDiario) {
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    // Métodos getter y setter

    /**
     * Obtiene el nombre de la carrera.
     * 
     * @return Nombre de la carrera
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre de la carrera.
     * 
     * @param nombre Nuevo nombre de la carrera
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tiempo máximo de uso diario permitido para la carrera.
     * 
     * @return Tiempo máximo de uso diario
     */
    public Integer getTiempoMaxUsoDiario() {
        return tiempoMaxUsoDiario;
    }

    /**
     * Asigna el tiempo máximo de uso diario permitido para la carrera.
     * 
     * @param tiempoMaxUsoDiario Nuevo tiempo máximo de uso diario
     */
    public void setTiempoMaxUsoDiario(Integer tiempoMaxUsoDiario) {
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }
    
    /**
     * Obtiene el identificador de la carrera.
     * 
     * @return ID de la carrera
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador de la carrera.
     * 
     * @param id Nuevo ID de la carrera
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la lista de alumnos asociados a la carrera.
     * 
     * @return Lista de alumnos
     */
    public List<Alumno> getAlumno() {
        return alumno;
    }

    /**
     * Asigna una nueva lista de alumnos a la carrera.
     * 
     * @param alumno Lista de alumnos
     */
    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }
}