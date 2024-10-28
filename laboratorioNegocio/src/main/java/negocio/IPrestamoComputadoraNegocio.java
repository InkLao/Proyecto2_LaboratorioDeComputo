/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.PrestamoComputadoraDTO;
import entidades.PrestamoComputadora;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IPrestamoComputadoraNegocio {
    
    public PrestamoComputadoraDTO obtenerPorId(Long id) throws NegocioException;
    
    public PrestamoComputadoraDTO guardarPrestamo(PrestamoComputadoraDTO prestamoComputadoraDTO) throws NegocioException;
    
    public PrestamoComputadoraDTO actualizarPrestamoComputadoraDTO(PrestamoComputadoraDTO prestamoComputadora) throws NegocioException;
    
    public List<PrestamoComputadoraDTO> buscarPrestamoPorAlumno(long idAlumno) throws NegocioException;
    
    public List<PrestamoComputadoraDTO> buscarPrestamoPorComputadora(long idComputadora) throws NegocioException;
}
