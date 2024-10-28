package persistencia;

import Excepciones.PersistenciaException;
import entidades.Alumno;
import entidades.Computadora;
import entidades.PrestamoComputadora;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad PrestamoComputadora en la capa de persistencia.
 * Define los métodos necesarios para gestionar los datos de los préstamos de computadoras en la base de datos.
 * 
 * @autor Arturo ITSON
 */
public interface IPrestamoComputadoraDAO {

    /**
     * Busca un préstamo de computadora por su ID en la base de datos.
     * 
     * @param id El ID del préstamo de computadora a buscar.
     * @return El préstamo de computadora encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar el préstamo de computadora.
     */
    public PrestamoComputadora buscarPrestamoComputadora(Long id) throws PersistenciaException;

    /**
     * Agrega un nuevo préstamo de computadora a la base de datos.
     * 
     * @param prestamoComputadora El préstamo de computadora a agregar.
     * @return El préstamo de computadora agregado con los datos persistidos.
     */
    public PrestamoComputadora agregarPrestamoComputadora(PrestamoComputadora prestamoComputadora);

    /**
     * Edita un préstamo de computadora existente en la base de datos.
     * 
     * @param prestamoComputadora El préstamo de computadora con los datos actualizados.
     * @return El préstamo de computadora editado.
     */
    public PrestamoComputadora editarPrestamoComputadora(PrestamoComputadora prestamoComputadora);

    /**
     * Busca el último préstamo realizado por un alumno específico.
     * 
     * @param alumno El alumno cuyo último préstamo se desea buscar.
     * @return Lista de préstamos de computadora realizados por el alumno.
     * @throws PersistenciaException Si ocurre un error al buscar el último préstamo del alumno.
     */
    public List<PrestamoComputadora> buscarUltimoPrestamoAlumno(Alumno alumno) throws PersistenciaException;

    /**
     * Busca el último préstamo realizado de una computadora específica.
     * 
     * @param computadora La computadora cuyo último préstamo se desea buscar.
     * @return Lista de préstamos de computadora relacionados con la computadora especificada.
     * @throws PersistenciaException Si ocurre un error al buscar el último préstamo de la computadora.
     */
    public List<PrestamoComputadora> buscarUltimoPrestamoPorComputadora(Computadora computadora) throws PersistenciaException;
}
