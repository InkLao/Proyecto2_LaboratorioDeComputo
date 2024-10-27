/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Computadora;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IComputadoraDAO {
    
    
    public List<Computadora> obtenerTodos() throws PersistenciaException;
    
    public Computadora agregarComputadora(Computadora computadora);
    
    public Computadora editarComputadora(Computadora computadora);
            
    public Computadora buscarComputadora(Long id) throws PersistenciaException;
    
    public Computadora buscarComputadorasPorNumMaquina(Integer numMaquina) throws PersistenciaException;
    
    public List<Computadora> buscarComputadorasUsoAlumno() throws PersistenciaException;
    
    public List<Computadora> buscarComputadoras(String ip) throws PersistenciaException;
    
    public Computadora eliminarComputadora(Computadora computadora);
    
    public List<Computadora> buscarComputadorasPorEstatus(String estatus) throws PersistenciaException;
    
    
}
