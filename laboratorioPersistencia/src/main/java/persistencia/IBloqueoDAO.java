/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Bloqueo;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IBloqueoDAO {
    
       public Bloqueo agregarBloqueo(Bloqueo bloqueo);
        
       public Bloqueo editarBloqueo(Bloqueo bloqueo);
       
       public Bloqueo buscarBloqueo(Long id) throws PersistenciaException;
       
       public Bloqueo eliminarBloqueo(Bloqueo bloqueo);
       
       public List<Bloqueo> obtenerTodos() throws PersistenciaException;
}
