package negocio;

import NegocioException.NegocioException;
import dto.UnidadAcademicaDTO;
import entidades.UnidadAcademica;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de unidades académicas.
 * Proporciona métodos para agregar, obtener y buscar unidades académicas.
 * 
 * @autor Oley
 */
public interface IUnidadNegocio {

    /**
     * Agrega una nueva unidad académica al sistema.
     * 
     * @param unidadAcademicaDTO Objeto UnidadAcademicaDTO con la información de la unidad académica a agregar.
     */
    void agregarUnidadAcademica(UnidadAcademicaDTO unidadAcademicaDTO);

    /**
     * Obtiene todas las unidades académicas en formato DTO.
     * 
     * @return Lista de objetos UnidadAcademicaDTO con la información de las unidades académicas.
     */
    List<UnidadAcademicaDTO> obtenerUnidadesDTO();

    /**
     * Obtiene una unidad académica por su ID.
     * 
     * @param id ID de la unidad académica a buscar.
     * @return UnidadAcademicaDTO con la información de la unidad académica encontrada o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public UnidadAcademicaDTO obtenerPorId(Long id) throws NegocioException;
}
