/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.CarreraDTO;
import entidades.Carrera;
import java.util.List;
import java.util.stream.Collectors;
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
    
    @Override
    public List<CarreraDTO> obtenerTodos() throws NegocioException {
        
        try {
            return carreraDAO.obtenerTodos().stream()
                    .map(entidad -> new CarreraDTO(entidad.getId(), entidad.getNombre(), entidad.getTiempoMaxUsoDiario()))
                    .collect(Collectors.toList());
        } 
        
        catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
     private CarreraDTO convertirACarreraDTO(Carrera carrera) {
        CarreraDTO carreraDTO = new CarreraDTO();
        carreraDTO.setId(carrera.getId());
        carreraDTO.setNombre(carrera.getNombre());
        return carreraDTO;
    }
}

