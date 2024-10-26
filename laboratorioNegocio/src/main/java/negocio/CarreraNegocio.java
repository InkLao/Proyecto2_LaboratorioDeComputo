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

    @Override
    public CarreraDTO obtenerCarreraPorNombre(String nombre) {
 Carrera carrera = carreraDAO.obtenerCarreraPorNombre(nombre);
        return carrera != null ? convertirACarreraDTO(carrera) : null;
    }
     private CarreraDTO convertirACarreraDTO(Carrera carrera) {
        CarreraDTO carreraDTO = new CarreraDTO();
        carreraDTO.setId(carrera.getId());
        carreraDTO.setNombre(carrera.getNombre());
        return carreraDTO;
    }
}

