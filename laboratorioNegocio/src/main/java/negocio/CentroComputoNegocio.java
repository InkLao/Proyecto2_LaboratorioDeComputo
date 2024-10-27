/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import dto.UnidadAcademicaDTO;
import entidades.Bloqueo;
import entidades.CentroComputo;
import entidades.UnidadAcademica;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.ICentroComputoDAO;

/**
 *
 * @author eduar
 */
public class CentroComputoNegocio implements ICentroComputoNegocio {

    private ICentroComputoDAO centroComputoDAO;

    public CentroComputoNegocio(ICentroComputoDAO centroComputoDAO) {
        this.centroComputoDAO = centroComputoDAO;
    }

    @Override
    public void agregarCentroComputo(CentroComputoDTO centroComputoDTO) {
        CentroComputo centroComputo = convertirAEntidad(centroComputoDTO);
        centroComputoDAO.agregarCentroComputo(centroComputo);
    }

    @Override
    public void editarCentroComputo(CentroComputoDTO centroComputoDTO) {
        CentroComputo centroComputo = convertirAEntidad(centroComputoDTO);
        centroComputoDAO.editarCentroComputo(centroComputo);
    }

    @Override
    public CentroComputoDTO buscarCentroComputo(Long id) throws NegocioException{
        CentroComputo centroComputo = centroComputoDAO.buscarCentroComputo(id);
        return convertirADto(centroComputo);
    }

    @Override
    public void eliminarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException {
        try {

            CentroComputo cc = new CentroComputo();
            cc = centroComputoDAO.buscarCentroComputo(centroComputo.getId());

            System.out.println(cc.getId());
            cc.setEliminado(true);

            centroComputoDAO.eliminarCentroComputo(cc);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    @Override
    public CentroComputoDTO actualizarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException {
        
        try{
            
            CentroComputo entidad = centroComputoDAO.buscarCentroComputo(centroComputo.getId());
            if (entidad == null) {
                throw new NegocioException("centro no encontrado");
            }
            
          //  entidad.setAlumno(alumnoNegocio.convertirAEntidad(alumnoNegocio.buscarAlumno(bloqueo.getAlumno())));
            entidad.setNombre(centroComputo.getNombre());
            entidad.setEliminado(centroComputo.isEliminado());
            entidad.setHoraInicio(centroComputo.getHoraInicio());
            entidad.setHoraFinal(centroComputo.getHoraFinal());
            entidad.setContraseñaMaestra(centroComputo.getContraseñaMaestra());
            
            
            System.out.println(entidad.getId() + " id negocio");
            
            centroComputoDAO.editarCentroComputo(entidad);
            
            System.out.println("listo");
 
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return centroComputo;
    } 

    // Método de conversión de DTO a entidad
    @Override
    public CentroComputo convertirAEntidad(CentroComputoDTO centroComputoDTO) {
        if (centroComputoDTO == null) {
            return null;
        }
        UnidadAcademica unidadAcademica = new UnidadAcademica();
        unidadAcademica.setId(centroComputoDTO.getUnidadAcademica().getId());
        unidadAcademica.setNombre(centroComputoDTO.getUnidadAcademica().getNombre());

        return new CentroComputo(
                centroComputoDTO.getNombre(),
                centroComputoDTO.getHoraInicio(),
                centroComputoDTO.getHoraFinal(),
                centroComputoDTO.getContraseñaMaestra(),
                centroComputoDTO.isEliminado(),
                unidadAcademica
        );
    }

    @Override
    public List<CentroComputoDTO> obtenerTodosLosCentros() throws NegocioException {
        try {
            List<CentroComputo> centros = centroComputoDAO.obtenerTodos();  // Método DAO para obtener todos los registros
            return centros.stream()
                    .map(this::convertirADto) // Usa el método existente de conversión
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException("Error al obtener todos los centros de cómputo.");
        }
    }
    
    
    @Override
    public List<CentroComputoDTO> obtenerTodosLosCentrosActivos() throws NegocioException {
        try {
            List<CentroComputo> centros = centroComputoDAO.obtenerTodosLosQueEstanActivos();  // Método DAO para obtener todos los registros
            return centros.stream()
                    .map(this::convertirADto) // Usa el método existente de conversión
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException("Error al obtener todos los centros de cómputo.");
        }
    }   
    
    
    @Override
    public CentroComputoDTO obtenerPorCentroNombre(String nombre) throws NegocioException {
        
        try {
            System.out.println("nombre busca " + nombre);
            CentroComputo entidad = centroComputoDAO.obtenerPorCentroNombre(nombre);
            if (entidad == null) {
                throw new NegocioException("centro no encontrado");
            }
            
            System.out.println("encontro este id " + entidad.getId());
            
            return new CentroComputoDTO(entidad.getId(), entidad.getNombre(), entidad.getHoraInicio(), entidad.getHoraFinal(), entidad.getContraseñaMaestra(), entidad.isEliminado(), this.convertirADTO(entidad.getUnidadAcademica()));
        } 
        
        catch (Exception e) {
            throw new NegocioException("Error al obtener los bloqueos por id");
        }    
    }

    // Método de conversión de entidad a DTO
    @Override
    public CentroComputoDTO convertirADto(CentroComputo centroComputo) {
        if (centroComputo == null) {
            return null;
        }
        UnidadAcademicaDTO unidadAcademicaDTO = new UnidadAcademicaDTO();
        unidadAcademicaDTO.setId(centroComputo.getUnidadAcademica().getId());
        unidadAcademicaDTO.setNombre(centroComputo.getUnidadAcademica().getNombre());

        return new CentroComputoDTO(
                centroComputo.getId(),
                centroComputo.getNombre(),
                centroComputo.getHoraInicio(),
                centroComputo.getHoraFinal(),
                centroComputo.getContraseñaMaestra(),
                centroComputo.isEliminado(),
                unidadAcademicaDTO
        );
    }
    
    private UnidadAcademicaDTO convertirADTO(UnidadAcademica unidad){
        if (unidad == null) {
            return null;
        }
        
        return new UnidadAcademicaDTO(unidad.getId(), unidad.getNombre());
    }

}
