/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ICarreraDAO {
      void agregarCarrera(Carrera carrera);
          Carrera obtenerCarreraPorNombre(String nombre);
          
          public List<Carrera> obtenerTodos() throws PersistenciaException;

}
