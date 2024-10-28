package persistencia;

import Excepciones.PersistenciaException;
import entidades.UnidadAcademica;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad UnidadAcademica en la capa de persistencia.
 * Define los métodos necesarios para gestionar los datos de las unidades académicas en la base de datos.
 * 
 * @autor Oley
 */
public interface IUnidadAcademicaDAO {

    /**
     * Agrega una nueva unidad académica a la base de datos.
     * 
     * @param unidadAcademica La unidad académica a agregar.
     */
    void agregarUnidadAcademica(UnidadAcademica unidadAcademica);

    /**
     * Obtiene una lista de todas las unidades académicas en la base de datos.
     * 
     * @return Lista de todas las unidades académicas.
     */
    List<UnidadAcademica> obtenerTodas();

    /**
     * Busca una unidad académica por su ID en la base de datos.
     * 
     * @param id El ID de la unidad académica a buscar.
     * @return La unidad académica encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la unidad académica.
     */
    public UnidadAcademica buscarUnidadAcademica(Long id) throws PersistenciaException;
}
