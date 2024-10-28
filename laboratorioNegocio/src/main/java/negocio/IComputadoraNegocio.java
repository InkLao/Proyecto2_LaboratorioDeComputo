/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.ComputadoraDTO;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IComputadoraNegocio {
    
    
    
    public List<ComputadoraDTO> buscarComputadorasTabla() throws NegocioException;
    
    public ComputadoraDTO guardarComputadora(ComputadoraDTO computadora) throws NegocioException;
    
    public ComputadoraDTO obtenerPorId(Long id) throws NegocioException;
    
    public ComputadoraDTO obtenerPorIP(String ip) throws NegocioException;
    
    public List<ComputadoraDTO> buscarBloqueosTabla(String ip) throws NegocioException;
    
    public List<ComputadoraDTO> buscarBloqueosPorEstatusTabla(String estatus) throws NegocioException;
    
    public ComputadoraDTO buscarComputadorasPorNumMaquina(Integer numMaquina) throws NegocioException;
    
    public List<ComputadoraDTO> buscarComputadorasUsoAlumnoTabla() throws NegocioException;
    
    public List<ComputadoraDTO> obtenerTodos() throws NegocioException;
    
    public ComputadoraDTO actualizarComputadora(ComputadoraDTO computadora) throws NegocioException;
    
    public void eliminarComputadora(ComputadoraDTO computadora) throws NegocioException;
    
    
}
