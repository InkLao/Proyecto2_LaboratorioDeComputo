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
 * Clase que representa una Computadora en el sistema. Define los detalles
 * específicos de cada computadora, como el estado, la dirección IP y el número de máquina.
 * 
 * Esta entidad mapea a la tabla "computadora" en la base de datos.
 * 
 * @autor eduar
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
     * Estado actual de la computadora (e.g., disponible, en uso, en mantenimiento).
     */
    @Column(name = "estatus", nullable = false)
    private String estatus;
    
    /**
     * Dirección IP única de la computadora.
     */
    @Column(name = "direccionIP", nullable = false, unique = true)
    private String direccionIP;
    
    /**
     * Número asignado a la máquina dentro del centro de cómputo.
     */
    @Column(name = "numeroMaquina", nullable = false)
    private Integer numeroMaquina;
    
    /**
     * Indica si la computadora es de uso exclusivo para alumnos.
     */
    @Column(name = "usoAlumno", nullable = false)
    private boolean usoAlumno;
    
    /**
     * Estado de la computadora que indica si ha sido eliminada.
     */
    @Column(name = "eliminado")
    private boolean eliminado;
    
    /**
     * Centro de cómputo al que pertenece la computadora.
     */
    @ManyToOne()
    @JoinColumn(name = "centroComputo")
    private CentroComputo centroComputo;
    
    /**
     * Lista de préstamos asociados a la computadora.
     */
    @OneToMany(mappedBy = "computadora")
    private List<PrestamoComputadora> prestamoComputadoras;
    
    /**
     * Constructor por defecto de la clase Computadora.
     */
    public Computadora() {
    }

    /**
     * Constructor completo de la clase Computadora.
     * 
     * @param id Identificador único de la computadora.
     * @param estatus Estado actual de la computadora.
     * @param direccionIP Dirección IP de la computadora.
     * @param numeroMaquina Número de máquina en el centro de cómputo.
     * @param usoAlumno Indica si es de uso exclusivo para alumnos.
     * @param eliminado Estado indicando si la computadora ha sido eliminada.
     * @param centroComputo Centro de cómputo al que pertenece la computadora.
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
     * Constructor alternativo de la clase Computadora sin el ID.
     * 
     * @param estatus Estado actual de la computadora.
     * @param direccionIP Dirección IP de la computadora.
     * @param numeroMaquina Número de máquina en el centro de cómputo.
     * @param usoAlumno Indica si es de uso exclusivo para alumnos.
     * @param eliminado Estado indicando si la computadora ha sido eliminada.
     * @param centroComputo Centro de cómputo al que pertenece la computadora.
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
     * Obtiene el identificador único de la computadora.
     * @return El ID de la computadora.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la computadora.
     * @param id El ID de la computadora.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el estado actual de la computadora.
     * @return El estado de la computadora.
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Establece el estado actual de la computadora.
     * @param estatus El estado de la computadora.
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * Obtiene la dirección IP de la computadora.
     * @return La dirección IP.
     */
    public String getDireccionIP() {
        return direccionIP;
    }

    /**
     * Establece la dirección IP de la computadora.
     * @param direccionIP La dirección IP.
     */
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    /**
     * Obtiene el número de la máquina en el centro de cómputo.
     * @return El número de máquina.
     */
    public Integer getNumeroMaquina() {
        return numeroMaquina;
    }

    /**
     * Establece el número de la máquina en el centro de cómputo.
     * @param numeroMaquina El número de máquina.
     */
    public void setNumeroMaquina(Integer numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    /**
     * Verifica si la computadora es de uso exclusivo para alumnos.
     * @return {@code true} si es para uso de alumnos, de lo contrario {@code false}.
     */
    public boolean isUsoAlumno() {
        return usoAlumno;
    }

    /**
     * Establece si la computadora es de uso exclusivo para alumnos.
     * @param usoAlumno {@code true} si es para uso de alumnos, de lo contrario {@code false}.
     */
    public void setUsoAlumno(boolean usoAlumno) {
        this.usoAlumno = usoAlumno;
    }

    /**
     * Obtiene el centro de cómputo al que pertenece la computadora.
     * @return El centro de cómputo.
     */
    public CentroComputo getCentroComputo() {
        return centroComputo;
    }

    /**
     * Establece el centro de cómputo al que pertenece la computadora.
     * @param centroComputo El centro de cómputo.
     */
    public void setCentroComputo(CentroComputo centroComputo) {
        this.centroComputo = centroComputo;
    }

    /**
     * Verifica si la computadora ha sido eliminada.
     * @return {@code true} si la computadora ha sido eliminada, de lo contrario {@code false}.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Establece el estado de eliminación de la computadora.
     * @param eliminado {@code true} si la computadora ha sido eliminada, de lo contrario {@code false}.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Obtiene la lista de préstamos asociados a la computadora.
     * @return Lista de préstamos de la computadora.
     */
    public List<PrestamoComputadora> getPrestamoComputadoras() {
        return prestamoComputadoras;
    }

    /**
     * Establece la lista de préstamos asociados a la computadora.
     * @param prestamoComputadoras Lista de préstamos de la computadora.
     */
    public void setPrestamoComputadoras(List<PrestamoComputadora> prestamoComputadoras) {
        this.prestamoComputadoras = prestamoComputadoras;
    }
    
    /**
     * Devuelve una representación en cadena de los detalles de la computadora.
     * @return Representación en cadena de la clase Computadora.
     */
    @Override
    public String toString() {
        return "Computadora{" + "id=" + id + ", estatus=" + estatus + ", direccionIP=" + direccionIP + ", numeroMaquina=" + numeroMaquina + ", usoAlumno=" + usoAlumno + ", eliminado=" + eliminado + ", centroComputo=" + centroComputo + '}';
    }
}
