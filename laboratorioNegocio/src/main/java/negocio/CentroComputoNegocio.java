/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import dto.UnidadAcademicaDTO;
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

    public void agregarCentroComputo(CentroComputoDTO centroComputoDTO) {
        CentroComputo centroComputo = convertirAEntidad(centroComputoDTO);
        centroComputoDAO.agregarCentroComputo(centroComputo);
    }

    public void editarCentroComputo(CentroComputoDTO centroComputoDTO) {
        CentroComputo centroComputo = convertirAEntidad(centroComputoDTO);
        centroComputoDAO.editarCentroComputo(centroComputo);
    }

    public CentroComputoDTO buscarCentroComputo(Long id) {
        CentroComputo centroComputo = centroComputoDAO.buscarCentroComputo(id);
        return convertirADto(centroComputo);
    }

    public void eliminarCentroComputo(Long id) {
        centroComputoDAO.eliminarCentroComputo(id);
    }

    // Método de conversión de DTO a entidad
    private CentroComputo convertirAEntidad(CentroComputoDTO centroComputoDTO) {
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

    // Método de conversión de entidad a DTO
    private CentroComputoDTO convertirADto(CentroComputo centroComputo) {
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
                unidadAcademicaDTO
        );
    }

}
