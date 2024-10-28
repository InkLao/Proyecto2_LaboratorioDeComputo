package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Carrera;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para gestionar alumnos.
 * Proporciona métodos para realizar operaciones CRUD y conversión entre entidades y DTOs.
 * 
 * @author Oley
 */
public interface IAlumnoNegocio {
    
    /**
     * Obtiene una lista de todos los alumnos en forma de DTO.
     * 
     * @return Lista de objetos AlumnoDTO con la información de los alumnos.
     */
    List<AlumnoDTO> buscarAlumnosTabla();
    
    /**
     * Guarda un nuevo alumno en el sistema.
     * 
     * @param alumnoDTO Objeto AlumnoDTO con la información del alumno a guardar.
     * @return AlumnoDTO con la información del alumno guardado.
     */
    AlumnoDTO guardarAlumnos(AlumnoDTO alumnoDTO);
    
    /**
     * Obtiene un alumno por su ID.
     * 
     * @param id ID del alumno a buscar.
     * @return AlumnoDTO con la información del alumno encontrado, o null si no existe.
     */
    AlumnoDTO obtenerPorId(Long id);
    
    /**
     * Obtiene todos los alumnos del sistema.
     * 
     * @return Lista de objetos AlumnoDTO con la información de todos los alumnos.
     */
    List<AlumnoDTO> obtenerTodos();
    
    /**
     * Actualiza la información de un alumno existente.
     * 
     * @param alumnoDTO Objeto AlumnoDTO con la información actualizada del alumno.
     * @return AlumnoDTO con la información del alumno actualizado.
     */
    AlumnoDTO actualizarAlumnos(AlumnoDTO alumnoDTO);
    
    /**
     * Elimina un alumno del sistema.
     * 
     * @param alumnoDTO Objeto AlumnoDTO con la información del alumno a eliminar.
     */
    void eliminarAlumnos(AlumnoDTO alumnoDTO);
    
    /**
     * Busca alumnos por nombre.
     * 
     * @param nombre Nombre del alumno a buscar.
     * @return Lista de objetos AlumnoDTO que coinciden con el nombre especificado.
     */
    List<AlumnoDTO> buscarAlumnosTabla(String nombre);
    
    /**
     * Busca un alumno por su ID.
     * 
     * @param id ID del alumno a buscar.
     * @return AlumnoDTO con la información del alumno encontrado, o null si no existe.
     */
    AlumnoDTO buscarAlumno(Long id);
    
    /**
     * Convierte un objeto CarreraDTO a una entidad Carrera.
     * 
     * @param carrera Objeto CarreraDTO a convertir.
     * @return Objeto Carrera con la información convertida.
     */
    public Carrera convertirAEntidad(CarreraDTO carrera);
    
    /**
     * Convierte un objeto AlumnoDTO a una entidad Alumno.
     * 
     * @param alumno Objeto AlumnoDTO a convertir.
     * @return Objeto Alumno con la información convertida.
     */
    public Alumno convertirAEntidad(AlumnoDTO alumno);
    
    public long contarAlumnos();
}
