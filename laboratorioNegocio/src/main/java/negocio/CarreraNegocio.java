/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.CarreraDTO;
import entidades.Carrera;
import persistencia.ICarreraDAO;

/**
 *
 * @author Oley
 */
public class CarreraNegocio implements ICarreraNegocio{
     private ICarreraDAO carreraDAO;

    public CarreraNegocio(ICarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }



    public void agregarCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = new Carrera(carreraDTO.getNombre(), carreraDTO.getTiempoMaxUsoDiario());
        carreraDAO.agregarCarrera(carrera);
    }
}

