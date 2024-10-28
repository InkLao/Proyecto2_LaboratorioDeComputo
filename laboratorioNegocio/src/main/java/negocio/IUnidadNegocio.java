/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.UnidadAcademicaDTO;
import entidades.UnidadAcademica;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IUnidadNegocio {
    void agregarUnidadAcademica(UnidadAcademicaDTO  unidadAcademicaDTO);
    List<UnidadAcademicaDTO> obtenerUnidadesDTO();
    
    public UnidadAcademicaDTO obtenerPorId(Long id) throws NegocioException;
}


