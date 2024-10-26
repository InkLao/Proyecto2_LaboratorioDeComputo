/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Oley
 */
@Entity
@Table(name = "tblCentroComputo")
public class CentroComputo implements Serializable {

    @Id
    @Column(name = "idCentroComputo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 75, nullable = false)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "horaInicio", nullable = false)
    private Calendar horaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "horaFinal", nullable = false)
    private Calendar horaFinal;

    @Column(name = "contraMaestra", length = 25, nullable = false)
    private String contraseñaMaestra;
    
    @Column(name = "Eliminado")
    private boolean eliminado;

    @OneToOne(cascade = CascadeType.PERSIST)
    UnidadAcademica unidadAcademica;

    public CentroComputo() {
    }

    public CentroComputo(Long id, String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, boolean eliminado, UnidadAcademica unidadAcademica) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.eliminado = eliminado;
        this.unidadAcademica = unidadAcademica;
    }

    public CentroComputo(String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, boolean eliminado, UnidadAcademica unidadAcademica) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.eliminado = eliminado;
        this.unidadAcademica = unidadAcademica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }

    public UnidadAcademica getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademica unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
