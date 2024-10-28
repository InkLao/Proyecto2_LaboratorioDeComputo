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
 * Clase que representa un Centro de Cómputo en el sistema. Define información como el nombre, 
 * horario de funcionamiento, contraseña maestra, y tiene relaciones con la unidad académica y las computadoras.
 * 
 * Esta entidad mapea a la tabla "tblCentroComputo" en la base de datos.
 * 
 * @autor Oley
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
     * Nombre del centro de cómputo, con una longitud máxima de 75 caracteres.
     */
    @Column(name = "nombre", length = 75, nullable = false)
    private String nombre;

    /**
     * Hora de inicio de funcionamiento del centro de cómputo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "horaInicio", nullable = false)
    private Calendar horaInicio;

    /**
     * Hora de cierre del centro de cómputo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "horaFinal", nullable = false)
    private Calendar horaFinal;

    /**
     * Contraseña maestra para el acceso administrativo al centro de cómputo.
     */
    @Column(name = "contraMaestra", length = 25, nullable = false)
    private String contraseñaMaestra;
    
    /**
     * Estado del centro de cómputo indicando si ha sido eliminado.
     */
    @Column(name = "Eliminado")
    private boolean eliminado;

    /**
     * Unidad académica a la que pertenece el centro de cómputo.
     */
    @OneToOne()
    UnidadAcademica unidadAcademica;
    
    /**
     * Lista de computadoras asignadas al centro de cómputo.
     */
    @OneToMany(mappedBy = "centroComputo")
    private List<Computadora> computadora;
    
    /**
     * Constructor por defecto de la clase CentroComputo.
     */
    public CentroComputo() {
    }

    /**
     * Constructor completo de la clase CentroComputo.
     * 
     * @param id Identificador único del centro de cómputo.
     * @param nombre Nombre del centro de cómputo.
     * @param horaInicio Hora de inicio de funcionamiento.
     * @param horaFinal Hora de cierre del centro de cómputo.
     * @param contraseñaMaestra Contraseña maestra de acceso administrativo.
     * @param eliminado Estado indicando si el centro ha sido eliminado.
     * @param unidadAcademica Unidad académica a la que pertenece el centro.
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
     * Constructor alternativo de la clase CentroComputo sin el ID.
     * 
     * @param nombre Nombre del centro de cómputo.
     * @param horaInicio Hora de inicio de funcionamiento.
     * @param horaFinal Hora de cierre del centro de cómputo.
     * @param contraseñaMaestra Contraseña maestra de acceso administrativo.
     * @param eliminado Estado indicando si el centro ha sido eliminado.
     * @param unidadAcademica Unidad académica a la que pertenece el centro.
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
     * Obtiene el identificador único del centro de cómputo.
     * @return El ID del centro de cómputo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del centro de cómputo.
     * @param id El ID del centro de cómputo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del centro de cómputo.
     * @return El nombre del centro de cómputo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del centro de cómputo.
     * @param nombre El nombre del centro de cómputo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la hora de inicio de funcionamiento del centro de cómputo.
     * @return La hora de inicio.
     */
    public Calendar getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de funcionamiento del centro de cómputo.
     * @param horaInicio La hora de inicio.
     */
    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de cierre del centro de cómputo.
     * @return La hora de cierre.
     */
    public Calendar getHoraFinal() {
        return horaFinal;
    }

    /**
     * Establece la hora de cierre del centro de cómputo.
     * @param horaFinal La hora de cierre.
     */
    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * Obtiene la contraseña maestra para acceso administrativo.
     * @return La contraseña maestra.
     */
    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    /**
     * Establece la contraseña maestra para acceso administrativo.
     * @param contraseñaMaestra La contraseña maestra.
     */
    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }

    /**
     * Obtiene la unidad académica a la que pertenece el centro de cómputo.
     * @return La unidad académica.
     */
    public UnidadAcademica getUnidadAcademica() {
        return unidadAcademica;
    }

    /**
     * Establece la unidad académica a la que pertenece el centro de cómputo.
     * @param unidadAcademica La unidad académica.
     */
    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    /**
     * Verifica si el centro de cómputo ha sido eliminado.
     * @return {@code true} si el centro ha sido eliminado, de lo contrario {@code false}.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Establece el estado de eliminación del centro de cómputo.
     * @param eliminado {@code true} si el centro ha sido eliminado, de lo contrario {@code false}.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Obtiene la lista de computadoras asignadas al centro de cómputo.
     * @return Lista de computadoras.
     */
    public List<Computadora> getComputadora() {
        return computadora;
    }

    /**
     * Establece la lista de computadoras asignadas al centro de cómputo.
     * @param computadora Lista de computadoras.
     */
    public void setComputadora(List<Computadora> computadora) {
        this.computadora = computadora;
    }
}
