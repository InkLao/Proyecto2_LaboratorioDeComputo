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
@Table(name = "tblBloqueo")
public class Bloqueo implements Serializable {

    @Id
    @Column(name = "idBloqueo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "motivo",nullable = false,length = 50)
    private  String motivo;
    @Column(name = "fechaBloqueo",nullable = false)
    private LocalDate fechaBloqueo;

    public Bloqueo() {
    }

    public Bloqueo(String motivo, LocalDate fechaBloqueo) {
        this.motivo = motivo;
        this.fechaBloqueo = fechaBloqueo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(LocalDate fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
}
