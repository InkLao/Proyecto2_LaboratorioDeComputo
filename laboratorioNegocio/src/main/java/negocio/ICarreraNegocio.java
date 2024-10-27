/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.CarreraDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ICarreraNegocio {
      void agregarCarrera(CarreraDTO carreraDTO);
          CarreraDTO obtenerCarreraPorNombre(String nombre);
          
          public List<CarreraDTO> obtenerTodos() throws NegocioException;

}
