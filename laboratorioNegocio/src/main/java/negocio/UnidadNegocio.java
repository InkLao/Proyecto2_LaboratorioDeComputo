/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.UnidadAcademicaDTO;
import entidades.UnidadAcademica;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.IUnidadAcademicaDAO;

/**
 *
 * @author Oley
 */
public class UnidadNegocio implements  IUnidadNegocio{
    private IUnidadAcademicaDAO unidadAcademicaDAO;

    public UnidadNegocio(IUnidadAcademicaDAO unidadAcademicaDAO) {
        this.unidadAcademicaDAO = unidadAcademicaDAO;
    }

    @Override
    public void agregarUnidadAcademica(UnidadAcademicaDTO unidadAcademicaDTO) {
UnidadAcademica unidadAcademica=new UnidadAcademica(unidadAcademicaDTO.getNombre());
  unidadAcademicaDAO.agregarUnidadAcademica(unidadAcademica);
    }
    
    @Override
    public List<UnidadAcademicaDTO> obtenerUnidadesDTO() {
        List<UnidadAcademica> entidades = unidadAcademicaDAO.obtenerTodas();
        return entidades.stream()
                .map(entidad -> new UnidadAcademicaDTO(entidad.getId(), entidad.getNombre()))
                .collect(Collectors.toList());
    }
    
    @Override
    public UnidadAcademicaDTO obtenerPorId(Long id) throws NegocioException {
        
        try {
            System.out.println("id busca " + id);
            UnidadAcademica entidad = unidadAcademicaDAO.buscarUnidadAcademica(id);
            if (entidad == null) {
                throw new NegocioException("unidad no encontrado");
            }
            
            System.out.println("encontro este id " + entidad.getId());
            
            return new UnidadAcademicaDTO(entidad.getId(), entidad.getNombre());
        } 
        
        catch (Exception e) {
            throw new NegocioException("Error al obtener lss unidadesAcademicas por id");
        }    
    } 
    
    
    
}
