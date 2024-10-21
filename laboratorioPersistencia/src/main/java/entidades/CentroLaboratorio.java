/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
   @Column(name="horaInicio",nullable = false)
   private LocalDate horaInicio;
   @Column(name = "horaFinal",nullable = false)
   private LocalDate horaFinal;
   @Column
   private String contraseñaMaestra;

    public CentroLaboratorio() {
    }

    public CentroLaboratorio(String nombre, LocalDate horaInicio, LocalDate horaFinal, String contraseñaMaestra) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.contraseñaMaestra = contraseñaMaestra;
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

    public LocalDate getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDate horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getContraseñaMaestra() {
        return contraseñaMaestra;
    }

    public void setContraseñaMaestra(String contraseñaMaestra) {
        this.contraseñaMaestra = contraseñaMaestra;
    }
   
   
    
}
