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
 * Clase que representa una Carrera en el sistema. Define el nombre y tiempo máximo de uso diario,
 * y tiene una relación con los alumnos inscritos en ella.
 * 
 * Esta entidad mapea a la tabla "tblCarrera" en la base de datos.
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
    @Column(name = "nombreCarrera",nullable = false)
    private String nombre;
  
    /**
     * Tiempo máximo de uso diario permitido, expresado en minutos.
     */
    @Column(name = "  tiempoMaxUsoDiario")
    private Integer tiempoMaxUsoDiario;
    
    /**
     * Lista de alumnos asociados a la carrera.
     */
    @OneToMany(mappedBy = "carrera")
    private List<Alumno> alumno;
    
    /**
     * Constructor por defecto de la clase Carrera.
     */
    public Carrera() {
    }

    /**
     * Constructor completo de la clase Carrera.
     * 
     * @param id Identificador único de la carrera.
     * @param nombre Nombre de la carrera.
     * @param tiempoMaxUsoDiario Tiempo máximo de uso diario permitido.
     */
    public Carrera(Long id, String nombre, Integer tiempoMaxUsoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    /**
     * Constructor de la clase Carrera sin el ID.
     * 
     * @param nombre Nombre de la carrera.
     * @param tiempoMaxUsoDiario Tiempo máximo de uso diario permitido.
     */
    public Carrera(String nombre, Integer tiempoMaxUsoDiario) {
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    /**
     * Obtiene el nombre de la carrera.
     * @return El nombre de la carrera.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la carrera.
     * @param nombre El nombre de la carrera.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tiempo máximo de uso diario permitido.
     * @return El tiempo máximo de uso diario en minutos.
     */
    public Integer getTiempoMaxUsoDiario() {
        return tiempoMaxUsoDiario;
    }

    /**
     * Establece el tiempo máximo de uso diario permitido.
     * @param tiempoMaxUsoDiario El tiempo máximo de uso diario en minutos.
     */
    public void setTiempoMaxUsoDiario(Integer tiempoMaxUsoDiario) {
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }
    
    /**
     * Obtiene el identificador único de la carrera.
     * @return El ID de la carrera.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la carrera.
     * @param id El ID de la carrera.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la lista de alumnos asociados a la carrera.
     * @return Lista de alumnos inscritos en la carrera.
     */
    public List<Alumno> getAlumno() {
        return alumno;
    }

    /**
     * Establece la lista de alumnos asociados a la carrera.
     * @param alumno Lista de alumnos inscritos en la carrera.
     */
    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }
}
