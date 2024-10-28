package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un Bloqueo asociado a un alumno en el sistema. Incluye 
 * detalles sobre el motivo, la fecha de inicio y la fecha de liberación del bloqueo.
 * 
 * Esta entidad mapea a la tabla "tblBloqueo" en la base de datos.
 * 
 * @author Oley
 */
@Entity
@Table(name = "tblBloqueo")
public class Bloqueo implements Serializable {

    /**
     * Identificador único del bloqueo.
     */
    @Id
    @Column(name = "idBloqueo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Motivo del bloqueo, con una longitud máxima de 50 caracteres.
     */
    @Column(name = "motivo", nullable = false, length = 50)
    private String motivo;
    
    /**
     * Fecha en la que se inició el bloqueo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaBloqueo", nullable = false)
    private Calendar fechaBloqueo;

    /**
     * Fecha en la que se liberará el bloqueo.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaLiberacion", nullable = false)
    private Calendar fechaLiberacion;
    
    /**
     * Estado del bloqueo indicando si ha sido eliminado.
     */
    @Column(name = "Eliminado", nullable = false)
    private boolean eliminado;
    
    /**
     * Referencia al alumno asociado a este bloqueo.
     */
    @ManyToOne()
    @JoinColumn(name = "alumno")
    private Alumno alumno;
    
    /**
     * Constructor por defecto de la clase Bloqueo.
     */
    public Bloqueo() {
    }

    /**
     * Constructor completo de la clase Bloqueo.
     * 
     * @param id Identificador único del bloqueo.
     * @param fechaBloqueo Fecha de inicio del bloqueo.
     * @param fechaLiberacion Fecha de liberación del bloqueo.
     * @param motivo Motivo del bloqueo.
     * @param eliminado Estado del bloqueo indicando si ha sido eliminado.
     * @param alumno Alumno asociado al bloqueo.
     */
    public Bloqueo(Long id, Calendar fechaBloqueo, Calendar fechaLiberacion, String motivo, boolean eliminado, Alumno alumno) {
        this.id = id;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = eliminado;
        this.alumno = alumno;
    }

    /**
     * Constructor alternativo de la clase Bloqueo sin el ID.
     * 
     * @param motivo Motivo del bloqueo.
     * @param fechaBloqueo Fecha de inicio del bloqueo.
     * @param fechaLiberacion Fecha de liberación del bloqueo.
     * @param Eliminado Estado del bloqueo indicando si ha sido eliminado.
     * @param alumno Alumno asociado al bloqueo.
     */
    public Bloqueo(String motivo, Calendar fechaBloqueo, Calendar fechaLiberacion, boolean Eliminado, Alumno alumno) {
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
        this.eliminado = Eliminado;
        this.alumno = alumno;
    }

    /**
     * Obtiene el identificador único del bloqueo.
     * @return El ID del bloqueo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del bloqueo.
     * @param id El ID del bloqueo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el motivo del bloqueo.
     * @return El motivo del bloqueo.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo del bloqueo.
     * @param motivo El motivo del bloqueo.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha de inicio del bloqueo.
     * @return La fecha de inicio del bloqueo.
     */
    public Calendar getFechaBloqueo() {
        return fechaBloqueo;
    }

    /**
     * Establece la fecha de inicio del bloqueo.
     * @param fechaBloqueo La fecha de inicio del bloqueo.
     */
    public void setFechaBloqueo(Calendar fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    /**
     * Obtiene la fecha de liberación del bloqueo.
     * @return La fecha de liberación del bloqueo.
     */
    public Calendar getFechaLiberacion() {
        return fechaLiberacion;
    }

    /**
     * Establece la fecha de liberación del bloqueo.
     * @param fechaLiberacion La fecha de liberación del bloqueo.
     */
    public void setFechaLiberacion(Calendar fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    /**
     * Obtiene el alumno asociado al bloqueo.
     * @return El alumno asociado al bloqueo.
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * Establece el alumno asociado al bloqueo.
     * @param alumno El alumno asociado al bloqueo.
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Verifica si el bloqueo ha sido eliminado.
     * @return {@code true} si el bloqueo ha sido eliminado, de lo contrario {@code false}.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Establece el estado de eliminación del bloqueo.
     * @param eliminado {@code true} si el bloqueo ha sido eliminado, de lo contrario {@code false}.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    /**
     * Devuelve una representación en cadena de los detalles del bloqueo.
     * @return Representación en cadena de la clase Bloqueo.
     */
    @Override
    public String toString() {
        return "Bloqueo{" + "id=" + id + ", motivo=" + motivo + ", fechaBloqueo=" + fechaBloqueo + ", fechaLiberacion=" + fechaLiberacion + ", eliminado=" + eliminado + ", alumno=" + alumno + '}';
    }
}
