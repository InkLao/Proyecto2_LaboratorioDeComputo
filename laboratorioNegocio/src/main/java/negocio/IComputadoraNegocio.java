package negocio;

import NegocioException.NegocioException;
import dto.ComputadoraDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de computadoras.
 * Proporciona métodos para agregar, editar, buscar y eliminar computadoras, además de consultas específicas.
 * 
 * @author Arturo ITSON
 */
public interface IComputadoraNegocio {

    /**
     * Obtiene una lista de todas las computadoras en formato DTO para visualización en tabla.
     * 
     * @return Lista de objetos ComputadoraDTO con la información de las computadoras.
     * @throws NegocioException en caso de error durante la operación.
     */
    List<ComputadoraDTO> buscarComputadorasTabla() throws NegocioException;

    /**
     * Guarda una nueva computadora en el sistema.
     * 
     * @param computadora Objeto ComputadoraDTO con la información de la computadora a guardar.
     * @return ComputadoraDTO con la información de la computadora guardada.
     * @throws NegocioException en caso de error durante la operación.
     */
    ComputadoraDTO guardarComputadora(ComputadoraDTO computadora) throws NegocioException;

    /**
     * Obtiene una computadora por su ID.
     * 
     * @param id ID de la computadora a buscar.
     * @return ComputadoraDTO con la información de la computadora encontrada o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public ComputadoraDTO obtenerPorId(Long id) throws NegocioException;

    /**
     * Obtiene una computadora por su dirección IP.
     * 
     * @param ip Dirección IP de la computadora a buscar.
     * @return ComputadoraDTO con la información de la computadora encontrada o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public ComputadoraDTO obtenerPorIP(String ip) throws NegocioException;

    /**
     * Busca computadoras que coincidan con una dirección IP específica.
     * 
     * @param ip Dirección IP de las computadoras a buscar.
     * @return Lista de objetos ComputadoraDTO con las computadoras encontradas.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<ComputadoraDTO> buscarBloqueosTabla(String ip) throws NegocioException;

    /**
     * Busca computadoras por su estatus.
     * 
     * @param estatus Estatus de las computadoras a buscar.
     * @return Lista de objetos ComputadoraDTO que coinciden con el estatus especificado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<ComputadoraDTO> buscarBloqueosPorEstatusTabla(String estatus) throws NegocioException;

    /**
     * Busca una computadora por el número de máquina.
     * 
     * @param numMaquina Número de máquina de la computadora a buscar.
     * @return ComputadoraDTO con la información de la computadora encontrada o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public ComputadoraDTO buscarComputadorasPorNumMaquina(Integer numMaquina) throws NegocioException;

    /**
     * Obtiene una lista de computadoras que están en uso por alumnos.
     * 
     * @return Lista de objetos ComputadoraDTO de computadoras en uso por alumnos.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<ComputadoraDTO> buscarComputadorasUsoAlumnoTabla() throws NegocioException;

    /**
     * Obtiene todas las computadoras del sistema.
     * 
     * @return Lista de objetos ComputadoraDTO con la información de todas las computadoras.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<ComputadoraDTO> obtenerTodos() throws NegocioException;

    /**
     * Actualiza la información de una computadora existente.
     * 
     * @param computadora Objeto ComputadoraDTO con la información actualizada de la computadora.
     * @return ComputadoraDTO con la información de la computadora actualizada.
     * @throws NegocioException en caso de error durante la operación.
     */
    public ComputadoraDTO actualizarComputadora(ComputadoraDTO computadora) throws NegocioException;

    /**
     * Elimina una computadora del sistema.
     * 
     * @param computadora Objeto ComputadoraDTO con la información de la computadora a eliminar.
     * @throws NegocioException en caso de error durante la operación.
     */
    public void eliminarComputadora(ComputadoraDTO computadora) throws NegocioException;
}
