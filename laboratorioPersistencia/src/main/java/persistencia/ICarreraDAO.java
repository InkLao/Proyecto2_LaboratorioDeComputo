package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Carrera en la capa de
 * persistencia. Define los métodos necesarios para gestionar los datos de las
 * carreras en la base de datos.
 *
 * @autor Oley
 */
public interface ICarreraDAO {

    /**
     * Agrega una nueva carrera a la base de datos.
     *
     * @param carrera La carrera a agregar.
     */
    void agregarCarrera(Carrera carrera);

    /**
     * Obtiene una carrera de la base de datos según su nombre.
     *
     * @param nombre El nombre de la carrera a buscar.
     * @return La carrera encontrada o {@code null} si no existe.
     */
    Carrera obtenerCarreraPorNombre(String nombre);

    /**
     * Obtiene una lista de todas las carreras en la base de datos.
     *
     * @return Lista de todas las carreras.
     * @throws PersistenciaException Si ocurre un error al obtener las carreras.
     */
    public List<Carrera> obtenerTodos() throws PersistenciaException;

    /**
     * Calcula el tiempo máximo de uso diario total para todas las carreras.
     *
     * @return El tiempo máximo de uso diario total como Integer, o null si
     * ocurre un error.
     */
    public Integer obtenerTiempoMaxUsoDiarioTotal();

}
