package persistencia;

import entidades.Alumno;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Alumno en la capa de persistencia.
 * Define los métodos necesarios para gestionar los datos de los alumnos en la base de datos.
 * 
 * @autor Oley
 */
public interface IAlumnoDAO {
    
    /**
     * Agrega un nuevo alumno a la base de datos.
     * 
     * @param alumno El alumno a agregar.
     * @return El alumno agregado con los datos persistidos.
     */
    Alumno agregarAlumno(Alumno alumno);

    /**
     * Edita un alumno existente en la base de datos.
     * 
     * @param alumno El alumno con los datos actualizados.
     * @return El alumno editado.
     */
    Alumno editarAlumno(Alumno alumno);

    /**
     * Busca un alumno por su ID en la base de datos.
     * 
     * @param id El ID del alumno a buscar.
     * @return El alumno encontrado o {@code null} si no existe.
     */
    Alumno buscarAlumno(Long id);

    /**
     * Marca un alumno como eliminado en la base de datos.
     * 
     * @param alumno El alumno a eliminar.
     * @return El alumno eliminado.
     */
    Alumno eliminarAlumno(Alumno alumno);

    /**
     * Obtiene una lista de todos los alumnos en la base de datos.
     * 
     * @return Lista de todos los alumnos.
     */
    List<Alumno> obtenerTodos();

    /**
     * Busca alumnos por su nombre en la base de datos.
     * 
     * @param nombre El nombre del alumno a buscar.
     * @return Lista de alumnos con el nombre especificado.
     */
    List<Alumno> buscarAlumno(String nombre);
}
