package negocio;

import NegocioException.NegocioException;
import dto.PrestamoComputadoraDTO;
import entidades.PrestamoComputadora;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para gestionar préstamos de computadoras.
 * Incluye métodos para agregar, actualizar, buscar y obtener préstamos relacionados con alumnos y computadoras.
 * 
 * @autor Arturo ITSON
 */
public interface IPrestamoComputadoraNegocio {

    /**
     * Obtiene un préstamo de computadora por su ID.
     * 
     * @param id ID del préstamo de computadora a buscar.
     * @return PrestamoComputadoraDTO con la información del préstamo encontrado o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public PrestamoComputadoraDTO obtenerPorId(Long id) throws NegocioException;

    /**
     * Guarda un nuevo préstamo de computadora en el sistema.
     * 
     * @param prestamoComputadoraDTO Objeto PrestamoComputadoraDTO con la información del préstamo a guardar.
     * @return PrestamoComputadoraDTO con la información del préstamo guardado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public PrestamoComputadoraDTO guardarPrestamo(PrestamoComputadoraDTO prestamoComputadoraDTO) throws NegocioException;

    /**
     * Actualiza la información de un préstamo de computadora existente.
     * 
     * @param prestamoComputadora Objeto PrestamoComputadoraDTO con la información actualizada del préstamo.
     * @return PrestamoComputadoraDTO con la información del préstamo actualizado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public PrestamoComputadoraDTO actualizarPrestamoComputadoraDTO(PrestamoComputadoraDTO prestamoComputadora) throws NegocioException;

    /**
     * Busca préstamos de computadora realizados por un alumno específico.
     * 
     * @param idAlumno ID del alumno cuyos préstamos se desean buscar.
     * @return Lista de objetos PrestamoComputadoraDTO con los préstamos encontrados para el alumno.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<PrestamoComputadoraDTO> buscarPrestamoPorAlumno(long idAlumno) throws NegocioException;

    /**
     * Busca préstamos de una computadora específica.
     * 
     * @param idComputadora ID de la computadora cuyos préstamos se desean buscar.
     * @return Lista de objetos PrestamoComputadoraDTO con los préstamos encontrados para la computadora.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<PrestamoComputadoraDTO> buscarPrestamoPorComputadora(long idComputadora) throws NegocioException;
}
