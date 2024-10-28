package negocio;

import NegocioException.NegocioException;
import dto.BloqueoDTO;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de bloqueos.
 * Proporciona métodos para realizar operaciones CRUD sobre bloqueos,
 * así como consultas adicionales por motivo y rango de fechas.
 * 
 * @author Arturo ITSON
 */
public interface IBloqueoNegocio {

    /**
     * Obtiene una lista de todos los bloqueos en formato DTO.
     * 
     * @return Lista de objetos BloqueoDTO con la información de los bloqueos.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<BloqueoDTO> buscarBloqueosTabla() throws NegocioException;

    /**
     * Guarda un nuevo bloqueo en el sistema.
     * 
     * @param bloqueo Objeto BloqueoDTO con la información del bloqueo a guardar.
     * @return BloqueoDTO con la información del bloqueo guardado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public BloqueoDTO guardarBloqueo(BloqueoDTO bloqueo) throws NegocioException;

    /**
     * Obtiene un bloqueo por su ID.
     * 
     * @param id ID del bloqueo a buscar.
     * @return BloqueoDTO con la información del bloqueo encontrado o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public BloqueoDTO obtenerPorId(Long id) throws NegocioException;

    /**
     * Obtiene todos los bloqueos del sistema.
     * 
     * @return Lista de objetos BloqueoDTO con la información de todos los bloqueos.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<BloqueoDTO> obtenerTodos() throws NegocioException;

    /**
     * Actualiza la información de un bloqueo existente.
     * 
     * @param bloqueo Objeto BloqueoDTO con la información actualizada del bloqueo.
     * @return BloqueoDTO con la información del bloqueo actualizado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public BloqueoDTO actualizarBloqueo(BloqueoDTO bloqueo) throws NegocioException;

    /**
     * Elimina un bloqueo del sistema.
     * 
     * @param bloqueo Objeto BloqueoDTO con la información del bloqueo a eliminar.
     * @throws NegocioException en caso de error durante la operación.
     */
    void eliminarBloqueo(BloqueoDTO bloqueo) throws NegocioException;

    /**
     * Busca bloqueos por motivo.
     * 
     * @param motivo Motivo del bloqueo a buscar.
     * @return Lista de objetos BloqueoDTO que coinciden con el motivo especificado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<BloqueoDTO> buscarBloqueosTabla(String motivo) throws NegocioException;

    /**
     * Busca bloqueos dentro de un rango de fechas.
     * 
     * @param fechaInicio Fecha de inicio del rango.
     * @param fechaFinal Fecha de fin del rango.
     * @return Lista de objetos BloqueoDTO que están dentro del rango de fechas especificado.
     * @throws NegocioException en caso de error durante la operación.
     */
    List<BloqueoDTO> buscarBloqueosPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws NegocioException;
}
