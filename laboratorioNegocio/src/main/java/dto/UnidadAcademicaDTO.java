/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Oley
 */
public class UnidadAcademicaDTO {
      private Long id;
    private String nombre;

    public UnidadAcademicaDTO() {
    }

    public UnidadAcademicaDTO( String nombre) {
        this.nombre = nombre;
    }
    
    public UnidadAcademicaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}

