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
    
    public CentroComputoDTO buscarCentroComputo(Long id);
    
    public void eliminarCentroComputo(Long id);
    
    public List<CentroComputoDTO> obtenerTodosLosCentros() throws NegocioException;
}
