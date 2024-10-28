package negocio;

import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import entidades.CentroComputo;
import java.util.List;
import persistencia.ICentroComputoDAO;

/**
 * Interfaz que define las operaciones de negocio para gestionar centros de cómputo.
 * Proporciona métodos para CRUD, obtener centros activos y realizar conversiones entre entidad y DTO.
 * 
 * @author eduar
 */
public interface ICentroComputoNegocio {

    /**
     * Agrega un nuevo centro de cómputo al sistema.
     * 
     * @param centroComputoDTO Objeto CentroComputoDTO con la información del centro de cómputo a agregar.
     */
    public void agregarCentroComputo(CentroComputoDTO centroComputoDTO);

    /**
     * Edita la información de un centro de cómputo existente.
     * 
     * @param centroComputoDTO Objeto CentroComputoDTO con la información actualizada del centro de cómputo.
     */
    public void editarCentroComputo(CentroComputoDTO centroComputoDTO);

    /**
     * Busca un centro de cómputo por su ID.
     * 
     * @param id ID del centro de cómputo a buscar.
     * @return CentroComputoDTO con la información del centro de cómputo encontrado o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public CentroComputoDTO buscarCentroComputo(Long id) throws NegocioException;

    /**
     * Elimina un centro de cómputo del sistema.
     * 
     * @param centroComputo Objeto CentroComputoDTO con la información del centro de cómputo a eliminar.
     * @throws NegocioException en caso de error durante la operación.
     */
    public void eliminarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException;

    /**
     * Actualiza la información de un centro de cómputo existente.
     * 
     * @param centroComputo Objeto CentroComputoDTO con la información actualizada del centro de cómputo.
     * @return CentroComputoDTO con la información del centro de cómputo actualizado.
     * @throws NegocioException en caso de error durante la operación.
     */
    public CentroComputoDTO actualizarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException;

    /**
     * Obtiene todos los centros de cómputo disponibles en el sistema.
     * 
     * @return Lista de objetos CentroComputoDTO con la información de todos los centros de cómputo.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<CentroComputoDTO> obtenerTodosLosCentros() throws NegocioException;

    /**
     * Obtiene todos los centros de cómputo activos en el sistema.
     * 
     * @return Lista de objetos CentroComputoDTO con la información de los centros de cómputo activos.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<CentroComputoDTO> obtenerTodosLosCentrosActivos() throws NegocioException;

    /**
     * Busca un centro de cómputo por su nombre.
     * 
     * @param nombre Nombre del centro de cómputo a buscar.
     * @return CentroComputoDTO con la información del centro de cómputo encontrado o null si no existe.
     * @throws NegocioException en caso de error durante la operación.
     */
    public CentroComputoDTO obtenerPorCentroNombre(String nombre) throws NegocioException;

    /**
     * Convierte un objeto CentroComputoDTO a una entidad CentroComputo.
     * 
     * @param centroComputoDTO Objeto CentroComputoDTO a convertir.
     * @return Objeto CentroComputo con la información convertida.
     */
    public CentroComputo convertirAEntidad(CentroComputoDTO centroComputoDTO);

    /**
     * Convierte un objeto CentroComputo a un DTO CentroComputoDTO.
     * 
     * @param centroComputo Objeto CentroComputo a convertir.
     * @return Objeto CentroComputoDTO con la información convertida.
     */
    public CentroComputoDTO convertirADto(CentroComputo centroComputo);
}
