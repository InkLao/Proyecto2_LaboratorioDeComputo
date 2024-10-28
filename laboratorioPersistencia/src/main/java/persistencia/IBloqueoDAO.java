package persistencia;

import Excepciones.PersistenciaException;
import entidades.Bloqueo;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Bloqueo en la capa de persistencia.
 * Define los métodos necesarios para gestionar los datos de los bloqueos en la base de datos.
 * 
 * @autor Arturo ITSON
 */
public interface IBloqueoDAO {
    
    /**
     * Agrega un nuevo bloqueo a la base de datos.
     * 
     * @param bloqueo El bloqueo a agregar.
     * @return El bloqueo agregado con los datos persistidos.
     */
    public Bloqueo agregarBloqueo(Bloqueo bloqueo);

    /**
     * Edita un bloqueo existente en la base de datos.
     * 
     * @param bloqueo El bloqueo con los datos actualizados.
     * @return El bloqueo editado.
     */
    public Bloqueo editarBloqueo(Bloqueo bloqueo);

    /**
     * Busca un bloqueo por su ID en la base de datos.
     * 
     * @param id El ID del bloqueo a buscar.
     * @return El bloqueo encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar el bloqueo.
     */
    public Bloqueo buscarBloqueo(Long id) throws PersistenciaException;

    /**
     * Marca un bloqueo como eliminado en la base de datos.
     * 
     * @param bloqueo El bloqueo a eliminar.
     * @return El bloqueo eliminado.
     */
    public Bloqueo eliminarBloqueo(Bloqueo bloqueo);

    /**
     * Obtiene una lista de todos los bloqueos en la base de datos.
     * 
     * @return Lista de todos los bloqueos.
     * @throws PersistenciaException Si ocurre un error al obtener los bloqueos.
     */
    public List<Bloqueo> obtenerTodos() throws PersistenciaException;

    /**
     * Busca bloqueos por el motivo especificado en la base de datos.
     * 
     * @param motivo El motivo del bloqueo a buscar.
     * @return Lista de bloqueos con el motivo especificado.
     * @throws PersistenciaException Si ocurre un error al buscar los bloqueos.
     */
    public List<Bloqueo> buscarBloqueo(String motivo) throws PersistenciaException;

    /**
     * Busca bloqueos en la base de datos que tengan una fecha de bloqueo entre las fechas especificadas.
     * 
     * @param fechaInicio Fecha de inicio del rango.
     * @param fechaFinal Fecha de fin del rango.
     * @return Lista de bloqueos dentro del rango de fechas.
     * @throws PersistenciaException Si ocurre un error al buscar los bloqueos por fecha.
     */
    public List<Bloqueo> buscarBloqueoPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws PersistenciaException;
}
