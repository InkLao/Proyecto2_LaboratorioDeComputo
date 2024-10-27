/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import entidades.CentroComputo;
import java.util.List;
import persistencia.ICentroComputoDAO;

/**
 *
 * @author eduar
 */
public interface ICentroComputoNegocio {
    
    public void agregarCentroComputo(CentroComputoDTO centroComputoDTO);
    
    public void editarCentroComputo(CentroComputoDTO centroComputoDTO);
    
    public CentroComputoDTO buscarCentroComputo(Long id) throws NegocioException;
    
    public void eliminarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException;
    
    public CentroComputoDTO actualizarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException;
    
    public List<CentroComputoDTO> obtenerTodosLosCentros() throws NegocioException;
    
    public List<CentroComputoDTO> obtenerTodosLosCentrosActivos() throws NegocioException;
     
    public CentroComputoDTO obtenerPorCentroNombre(String nombre) throws NegocioException;
    
    public CentroComputo convertirAEntidad(CentroComputoDTO centroComputoDTO);
    
    public CentroComputoDTO convertirADto(CentroComputo centroComputo);
}
