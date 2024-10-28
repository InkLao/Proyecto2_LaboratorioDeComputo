/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.BloqueoDTO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IBloqueoNegocio {
    
    public List<BloqueoDTO> buscarBloqueosTabla() throws NegocioException;
    
    public BloqueoDTO guardarBloqueo(BloqueoDTO bloqueo) throws NegocioException;
    
    public BloqueoDTO obtenerPorId(Long id) throws NegocioException;
    
    public List<BloqueoDTO> obtenerTodos() throws NegocioException;
    
    public BloqueoDTO actualizarBloqueo(BloqueoDTO bloqueo) throws NegocioException;
    
    void eliminarBloqueo(BloqueoDTO bloqueo) throws NegocioException;
    
    public List<BloqueoDTO> buscarBloqueosTabla(String motivo) throws NegocioException;
    
    List<BloqueoDTO> buscarBloqueosPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws NegocioException;
    
}
