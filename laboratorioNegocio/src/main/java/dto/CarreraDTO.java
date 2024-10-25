/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Oley
 */
public class CarreraDTO {
      private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private Integer tiempoMaxUsoDiario;

    public CarreraDTO() {
    }

    public CarreraDTO(Long id, String nombre, Integer tiempoMaxUsoDiario) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

    
    
    public CarreraDTO(String nombre, Integer tiempoMaxUsoDiario) {
        this.nombre = nombre;
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
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

    public Integer getTiempoMaxUsoDiario() {
        return tiempoMaxUsoDiario;
    }

    public void setTiempoMaxUsoDiario(Integer tiempoMaxUsoDiario) {
        this.tiempoMaxUsoDiario = tiempoMaxUsoDiario;
    }

   
}
