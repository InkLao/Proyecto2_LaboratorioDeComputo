/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Oley
 */
@Entity
@Table(name = "tblAlumno")
public class Alumno implements Serializable {

    @Id
    @Column(name = "idAlumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;
    
    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", length = 50, nullable = false)
    private String apellidoMaterno;
    
    @Column(name = "contraseña", length = 50, nullable = false)
    private String contraseña;

    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Carrera carrera;

    public Alumno() {
    }

    public Alumno(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, Carrera carrera) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.carrera = carrera;
    }

    
    
    
    public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno, String contraseña, Carrera carrera) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.carrera = carrera;
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



}
