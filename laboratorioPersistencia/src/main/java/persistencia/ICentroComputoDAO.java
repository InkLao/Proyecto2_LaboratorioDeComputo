package persistencia;

import Excepciones.PersistenciaException;
import entidades.CentroComputo;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad CentroComputo en la capa de persistencia.
 * Define los métodos necesarios para gestionar los datos de los centros de cómputo en la base de datos.
 * 
 * @autor eduar
 */
public interface ICentroComputoDAO {

    /**
     * Agrega un nuevo centro de cómputo a la base de datos.
     * 
     * @param centroComputo El centro de cómputo a agregar.
     */
    void agregarCentroComputo(CentroComputo centroComputo);

    /**
     * Edita un centro de cómputo existente en la base de datos.
     * 
     * @param centroComputo El centro de cómputo con los datos actualizados.
     */
    void editarCentroComputo(CentroComputo centroComputo);

    /**
     * Busca un centro de cómputo por su ID en la base de datos.
     * 
     * @param id El ID del centro de cómputo a buscar.
     * @return El centro de cómputo encontrado o {@code null} si no existe.
     */
    CentroComputo buscarCentroComputo(Long id);

    /**
     * Marca un centro de cómputo como eliminado en la base de datos.
     * 
     * @param centroComputo El centro de cómputo a eliminar.
     * @return El centro de cómputo eliminado.
     */
    CentroComputo eliminarCentroComputo(CentroComputo centroComputo);

    /**
     * Obtiene una lista de todos los centros de cómputo en la base de datos.
     * 
     * @return Lista de todos los centros de cómputo.
     * @throws PersistenciaException Si ocurre un error al obtener los centros de cómputo.
     */
    public List<CentroComputo> obtenerTodos() throws PersistenciaException;

    /**
     * Obtiene un centro de cómputo de la base de datos según su nombre.
     * 
     * @param nombre El nombre del centro de cómputo a buscar.
     * @return El centro de cómputo encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar el centro de cómputo.
     */
    public CentroComputo obtenerPorCentroNombre(String nombre) throws PersistenciaException;

    /**
     * Obtiene una lista de todos los centros de cómputo activos en la base de datos.
     * 
     * @return Lista de centros de cómputo activos.
     * @throws PersistenciaException Si ocurre un error al obtener los centros de cómputo activos.
     */
    public List<CentroComputo> obtenerTodosLosQueEstanActivos() throws PersistenciaException;
}
