/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Oley
 */
@Entity
@Table(name="tblCentroLaboratorio")
public class CentroLaboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idCentroLaboratorio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
   @Column(name = "nombre",length = 75,nullable = false)
   private String nombre;
    
   @Temporal(TemporalType.DATE)
   @Column(name="horaInicio",nullable = false)
   private Calendar horaInicio;
   
   
   @Temporal(TemporalType.DATE)
   @Column(name = "horaFinal",nullable = false)
   private Calendar horaFinal;
   
   
   @Column(name = "contraMaestra",length = 25, nullable = false)
   private String contraseñaMaestra;

   
   @OneToOne(cascade = CascadeType.PERSIST)
   UnidadAcademica unidadAcademica;
   
   
   public CentroLaboratorio() {
    }

    public CentroLaboratorio(Long id, String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, UnidadAcademica unidadAcademica) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
        this.unidadAcademica = unidadAcademica;
    }

    public CentroLaboratorio(String nombre, Calendar horaInicio, Calendar horaFinal, String contraseñaMaestra, UnidadAcademica unidadAcademica) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
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


   
    
}
