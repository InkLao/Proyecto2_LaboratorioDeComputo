/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.PrestamoComputadoraDTO;

/**
 *
 * @author Arturo ITSON
 */
public interface IPrestamoComputadoraNegocio {
    
    public PrestamoComputadoraDTO guardarPrestamo(PrestamoComputadoraDTO prestamoComputadoraDTO) throws NegocioException;
}
