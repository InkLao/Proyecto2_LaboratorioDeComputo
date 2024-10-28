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
 * Clase que representa un Alumno en el sistema. Incluye información personal y
 * su relación con la carrera, bloqueos y préstamos de computadora.
 * 
 * Esta entidad mapea a la tabla "tblAlumno" en la base de datos.
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
     * Nombre(s) del alumno, con una longitud máxima de 50 caracteres.
     */
    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    /**
     * Apellido paterno del alumno, con una longitud máxima de 50 caracteres.
     */
    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;

    /**
     * Apellido materno del alumno, con una longitud máxima de 50 caracteres.
     */
    @Column(name = "apellidoMaterno", length = 50, nullable = false)
    private String apellidoMaterno;

    /**
     * Contraseña del alumno para autenticación, con una longitud máxima de 50 caracteres.
     */
    @Column(name = "contraseña", length = 50, nullable = false)
    private String contraseña;
    
    /**
     * Estado del alumno indicando si ha sido eliminado.
     */
    @Column(name = "estaEliminado", nullable = false)
    private boolean estaEliminado;

    /**
     * Carrera a la que pertenece el alumno.
     */
    @OneToOne()
    private Carrera carrera;
    
    /**
     * Lista de bloqueos asociados al alumno.
     */
    @OneToMany(mappedBy = "alumno")
    private List<Bloqueo> bloqueos;
    
    /**
     * Lista de préstamos de computadoras asociados al alumno.
     */
    @OneToMany(mappedBy = "alumno")
    private List<PrestamoComputadora> prestamoComputadoras;

    /**
     * Constructor por defecto de la clase Alumno.
     */
    public Alumno() {
    }

    /**
     * Constructor completo de la clase Alumno.
     * 
     * @param id Identificador único del alumno.
     * @param nombres Nombre(s) del alumno.
     * @param apellidoPaterno Apellido paterno del alumno.
     * @param apellidoMaterno Apellido materno del alumno.
     * @param contraseña Contraseña del alumno.
     * @param estaEliminado Estado del alumno indicando si ha sido eliminado.
     * @param carrera Carrera a la que pertenece el alumno.
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
     * Obtiene el identificador único del alumno.
     * @return El ID del alumno.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del alumno.
     * @param id El ID del alumno.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre(s) del alumno.
     * @return El nombre del alumno.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece el nombre(s) del alumno.
     * @param nombres El nombre del alumno.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del alumno.
     * @return El apellido paterno del alumno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del alumno.
     * @param apellidoPaterno El apellido paterno del alumno.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del alumno.
     * @return El apellido materno del alumno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del alumno.
     * @param apellidoMaterno El apellido materno del alumno.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la contraseña del alumno.
     * @return La contraseña del alumno.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del alumno.
     * @param contraseña La contraseña del alumno.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la carrera a la que pertenece el alumno.
     * @return La carrera del alumno.
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * Establece la carrera a la que pertenece el alumno.
     * @param carrera La carrera del alumno.
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * Verifica si el alumno ha sido eliminado.
     * @return {@code true} si el alumno ha sido eliminado, de lo contrario {@code false}.
     */
    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    /**
     * Establece el estado de eliminación del alumno.
     * @param estaEliminado {@code true} si el alumno ha sido eliminado, de lo contrario {@code false}.
     */
    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }

    /**
     * Obtiene la lista de bloqueos asociados al alumno.
     * @return Lista de bloqueos.
     */
    public List<Bloqueo> getBloqueos() {
        return bloqueos;
    }

    /**
     * Establece la lista de bloqueos asociados al alumno.
     * @param bloqueos Lista de bloqueos.
     */
    public void setBloqueos(List<Bloqueo> bloqueos) {
        this.bloqueos = bloqueos;
    }

    /**
     * Obtiene la lista de préstamos de computadoras asociados al alumno.
     * @return Lista de préstamos de computadora.
     */
    public List<PrestamoComputadora> getPrestamoComputadoras() {
        return prestamoComputadoras;
    }

    /**
     * Establece la lista de préstamos de computadoras asociados al alumno.
     * @param prestamoComputadoras Lista de préstamos de computadora.
     */
    public void setPrestamoComputadoras(List<PrestamoComputadora> prestamoComputadoras) {
        this.prestamoComputadoras = prestamoComputadoras;
    }
}
