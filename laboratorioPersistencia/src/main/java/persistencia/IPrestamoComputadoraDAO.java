/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Alumno;
import entidades.Computadora;
import entidades.PrestamoComputadora;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IPrestamoComputadoraDAO {
    
    public PrestamoComputadora buscarPrestamoComputadora(Long id) throws PersistenciaException;
    
    public PrestamoComputadora agregarPrestamoComputadora(PrestamoComputadora prestamoComputadora);
    
    public PrestamoComputadora editarPrestamoComputadora(PrestamoComputadora prestamoComputadora);
    
    public List<PrestamoComputadora> buscarUltimoPrestamoAlumno(Alumno Alumno) throws PersistenciaException;
    
    public List<PrestamoComputadora> buscarUltimoPrestamoPorComputadora(Computadora Computadora) throws PersistenciaException;
    
}
