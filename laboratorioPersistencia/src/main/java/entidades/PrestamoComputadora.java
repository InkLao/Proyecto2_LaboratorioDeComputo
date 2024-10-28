package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un préstamo de una computadora a un alumno en el sistema.
 * Define detalles sobre la fecha del préstamo, la duración y si la computadora sigue apartada.
 * 
 * Esta entidad mapea a la tabla "tblPrestamoComputadora" en la base de datos.
 * 
 * @autor Arturo ITSON
 */
@Entity
@Table(name = "tblPrestamoComputadora")
public class PrestamoComputadora implements Serializable {

    /**
     * Identificador único del préstamo de computadora.
     */
    @Id
    @Column(name = "idPrestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Fecha en la que se realizó el préstamo de la computadora.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaPrestamo", nullable = false)
    private Calendar fechaPrestamo;
    
    /**
     * Duración del préstamo en minutos.
     */
    @Column(name = "minutos", nullable = false)
    private Integer minutos;
    
    /**
     * Indica si la computadora sigue apartada después del préstamo.
     */
    @Column(name = "sigueApartada")
    private boolean sigueAparta;
    
    /**
     * Alumno que solicitó el préstamo de la computadora.
     */
    @ManyToOne()
    @JoinColumn(name = "alumno")
    private Alumno alumno;
    
    /**
     * Computadora que fue prestada al alumno.
     */
    @ManyToOne()
    @JoinColumn(name = "computadora")
    private Computadora computadora;

    /**
     * Constructor por defecto de la clase PrestamoComputadora.
     */
    public PrestamoComputadora() {
    }

    /**
     * Constructor completo de la clase PrestamoComputadora.
     * 
     * @param id Identificador único del préstamo.
     * @param fechaPrestamo Fecha en la que se realizó el préstamo.
     * @param minutos Duración del préstamo en minutos.
     * @param sigueApartada Estado que indica si la computadora sigue apartada.
     * @param alumno Alumno que solicitó el préstamo.
     * @param computadora Computadora que fue prestada.
     */
    public PrestamoComputadora(Long id, Calendar fechaPrestamo, Integer minutos, boolean sigueApartada, Alumno alumno, Computadora computadora) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.minutos = minutos;
        this.sigueAparta = sigueApartada;
        this.alumno = alumno;
        this.computadora = computadora;
    }

    /**
     * Constructor alternativo de la clase PrestamoComputadora sin el ID.
     * 
     * @param fechaPrestamo Fecha en la que se realizó el préstamo.
     * @param minutos Duración del préstamo en minutos.
     * @param sigueApartada Estado que indica si la computadora sigue apartada.
     * @param alumno Alumno que solicitó el préstamo.
     * @param computadora Computadora que fue prestada.
     */
    public PrestamoComputadora(Calendar fechaPrestamo, Integer minutos, boolean sigueApartada, Alumno alumno, Computadora computadora) {
        this.fechaPrestamo = fechaPrestamo;
        this.minutos = minutos;
        this.sigueAparta = sigueApartada;
        this.alumno = alumno;
        this.computadora = computadora;
    }

    /**
     * Obtiene el identificador único del préstamo de computadora.
     * @return El ID del préstamo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del préstamo de computadora.
     * @param id El ID del préstamo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha en la que se realizó el préstamo.
     * @return La fecha del préstamo.
     */
    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Establece la fecha en la que se realizó el préstamo.
     * @param fechaPrestamo La fecha del préstamo.
     */
    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Obtiene la duración del préstamo en minutos.
     * @return Duración del préstamo en minutos.
     */
    public Integer getMinutos() {
        return minutos;
    }

    /**
     * Establece la duración del préstamo en minutos.
     * @param minutos Duración del préstamo en minutos.
     */
    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    /**
     * Obtiene el alumno que solicitó el préstamo.
     * @return El alumno que solicitó el préstamo.
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Establece el alumno que solicitó el préstamo.
     * @param alumno El alumno que solicitó el préstamo.
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Obtiene la computadora que fue prestada.
     * @return La computadora prestada.
     */
    public Computadora getComputadora() {
        return computadora;
    }

    /**
     * Establece la computadora que fue prestada.
     * @param computadora La computadora prestada.
     */
    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }

    /**
     * Verifica si la computadora sigue apartada después del préstamo.
     * @return {@code true} si la computadora sigue apartada, de lo contrario {@code false}.
     */
    public boolean isSigueAparta() {
        return sigueAparta;
    }

    /**
     * Establece si la computadora sigue apartada después del préstamo.
     * @param sigueAparta {@code true} si la computadora sigue apartada, de lo contrario {@code false}.
     */
    public void setSigueAparta(boolean sigueAparta) {
        this.sigueAparta = sigueAparta;
    }

    /**
     * Devuelve una representación en cadena de los detalles del préstamo de computadora.
     * @return Representación en cadena de la clase PrestamoComputadora.
     */
    @Override
    public String toString() {
        return "PrestamoComputadora{" + "id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", minutos=" + minutos + ", sigueAparta=" + sigueAparta + ", alumno=" + alumno + ", computadora=" + computadora + '}';
    }
}
