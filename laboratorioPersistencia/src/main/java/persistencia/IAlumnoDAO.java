/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad `Alumno`.
 * Proporciona métodos para agregar, editar, eliminar y buscar alumnos, así como
 * obtener todos los alumnos almacenados en la base de datos.
 *
 * @author Oley
 */
public interface IAlumnoDAO {

    /**
     * Agrega un nuevo alumno a la base de datos.
     *
     * @param alumno Alumno a agregar
     * @return Alumno agregado
     */
    Alumno agregarAlumno(Alumno alumno);

    /**
     * Edita la información de un alumno existente en la base de datos.
     *
     * @param alumno Alumno a editar
     * @return Alumno editado
     */
    Alumno editarAlumno(Alumno alumno);

    /**
     * Busca un alumno por su identificador.
     *
     * @param id Identificador del alumno
     * @return Alumno encontrado o null si no existe
     */
    Alumno buscarAlumno(Long id);

    /**
     * Marca un alumno como eliminado en la base de datos.
     *
     * @param alumno Alumno a eliminar
     * @return Alumno eliminado
     */
    Alumno eliminarAlumno(Alumno alumno);

    /**
     * Obtiene todos los alumnos almacenados en la base de datos.
     *
     * @return Lista de todos los alumnos
     */
    List<Alumno> obtenerTodos();

    /**
     * Busca alumnos por nombre en la base de datos.
     *
     * @param nombre Nombre del alumno
     * @return Lista de alumnos que coinciden con el nombre
     */
    List<Alumno> buscarAlumno(String nombre);
}
