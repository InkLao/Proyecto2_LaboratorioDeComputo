package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.BloqueoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Bloqueo;
import entidades.Carrera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.AlumnoDAO;
import persistencia.IAlumnoDAO;

/**
 * Clase que representa la lógica de negocio para la gestión de alumnos.
 * Esta clase proporciona métodos para realizar operaciones CRUD sobre objetos Alumno.
 * 
 * @autor Oley
 */
public class AlumnoNegocio implements IAlumnoNegocio {

    /**
     * DAO para realizar operaciones de persistencia sobre Alumno.
     */
    private IAlumnoDAO alumnoDAO;

    /**
     * Constructor de la clase AlumnoNegocio que recibe un IAlumnoDAO.
     * 
     * @param alumnoDAO DAO para realizar operaciones de persistencia sobre Alumno.
     */
    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    /**
     * Busca un alumno por su ID y lo convierte en un DTO.
     * 
     * @param id Identificador del alumno a buscar.
     * @return AlumnoDTO con la información del alumno, o null si no se encuentra.
     */
    @Override
    public AlumnoDTO buscarAlumno(Long id) {
        Alumno alumno = alumnoDAO.buscarAlumno(id);
        return convertirADto(alumno);
    }

    /**
     * Obtiene una lista de todos los alumnos para la tabla de visualización.
     * 
     * @return Lista de AlumnoDTO con la información de todos los alumnos.
     */
    @Override
    public List<AlumnoDTO> buscarAlumnosTabla() {
        try {
            List<Alumno> alumnos = alumnoDAO.obtenerTodos();
            return alumnos.stream().map(this::convertirADto).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error al buscar alumnos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Guarda un alumno en la base de datos a partir de su DTO.
     * 
     * @param alumnoDTO DTO con la información del alumno a guardar.
     * @return AlumnoDTO con la información del alumno guardado.
     */
    @Override
    public AlumnoDTO guardarAlumnos(AlumnoDTO alumnoDTO) {
        try {
            Alumno alumno = convertirAEntidad(alumnoDTO);
            Alumno alumnoGuardado = alumnoDAO.agregarAlumno(alumno);
            return convertirADto(alumnoGuardado);
        } catch (Exception e) {
            System.out.println("Error al guardar el alumno: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene un alumno por su ID.
     * 
     * @param id Identificador del alumno.
     * @return AlumnoDTO con la información del alumno.
     */
    @Override
    public AlumnoDTO obtenerPorId(Long id) {
        Alumno entidad = alumnoDAO.buscarAlumno(id);
        return convertirADto(entidad);
    }

    /**
     * Obtiene una lista de todos los alumnos.
     * 
     * @return Lista de AlumnoDTO con la información de todos los alumnos.
     */
    @Override
    public List<AlumnoDTO> obtenerTodos() {
        return buscarAlumnosTabla();
    }

    /**
     * Actualiza la información de un alumno en la base de datos.
     * 
     * @param alumnoDTO DTO con la información actualizada del alumno.
     * @return AlumnoDTO con la información del alumno actualizado.
     */
    @Override
    public AlumnoDTO actualizarAlumnos(AlumnoDTO alumnoDTO) {
        try {
            Alumno entidad = alumnoDAO.buscarAlumno(alumnoDTO.getId());
            if (entidad == null) {
                throw new NegocioException("Alumno no encontrado");
            }
            entidad.setNombres(alumnoDTO.getNombres());
            entidad.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
            entidad.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
            entidad.setContraseña(alumnoDTO.getContraseña());
            entidad.setEstaEliminado(alumnoDTO.isEstaEliminado());
            alumnoDAO.editarAlumno(entidad);
            return convertirADto(entidad);
        } catch (Exception e) {
            System.out.println("Error al actualizar el alumno: " + e.getMessage());
            return null;
        }
    }

    /**
     * Marca un alumno como eliminado en la base de datos.
     * 
     * @param alumnoDTO DTO con la información del alumno a eliminar.
     */
    @Override
    public void eliminarAlumnos(AlumnoDTO alumnoDTO) {
        try {
            Alumno alumno = alumnoDAO.buscarAlumno(alumnoDTO.getId());
            if (alumno != null) {
                alumno.setEstaEliminado(true);
                alumnoDAO.eliminarAlumno(alumno);
            } else {
                throw new NegocioException("Alumno no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }

    /**
     * Busca alumnos por su nombre.
     * 
     * @param nombre Nombre del alumno a buscar.
     * @return Lista de AlumnoDTO con la información de los alumnos que coinciden.
     */
    @Override
    public List<AlumnoDTO> buscarAlumnosTabla(String nombre) {
        try {
            List<Alumno> alumnos = alumnoDAO.buscarAlumno(nombre);
            return alumnos.stream().map(this::convertirADto).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error al buscar alumnos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Convierte un objeto CarreraDTO a Carrera.
     * 
     * @param carreraDTO DTO de la carrera.
     * @return Objeto Carrera.
     */
    @Override
    public Carrera convertirAEntidad(CarreraDTO carreraDTO) {
        if (carreraDTO == null) {
            return null;
        }
        return new Carrera(carreraDTO.getId(), carreraDTO.getNombre(), carreraDTO.getTiempoMaxUsoDiario());
    }

    /**
     * Convierte un objeto AlumnoDTO a Alumno.
     * 
     * @param alumnoDTO DTO del alumno.
     * @return Objeto Alumno.
     */
    @Override
    public Alumno convertirAEntidad(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return null;
        }
        Carrera carrera = convertirAEntidad(alumnoDTO.getCarrera());
        return new Alumno(
                alumnoDTO.getId(),
                alumnoDTO.getNombres(),
                alumnoDTO.getApellidoPaterno(),
                alumnoDTO.getApellidoMaterno(),
                alumnoDTO.getContraseña(),
                alumnoDTO.isEstaEliminado(),
                carrera
        );
    }

    /**
     * Convierte un objeto Alumno a AlumnoDTO.
     * 
     * @param alumno Objeto Alumno.
     * @return AlumnoDTO con la información del alumno.
     */
    private AlumnoDTO convertirADto(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        CarreraDTO carreraDTO = convertirADTO(alumno.getCarrera());
        return new AlumnoDTO(
            alumno.getId(),
            alumno.getNombres(),
            alumno.getApellidoPaterno(),
            alumno.getApellidoMaterno(),
            alumno.getContraseña(),
            carreraDTO,
            alumno.isEstaEliminado()
        );
    }

    /**
     * Convierte un objeto Carrera a CarreraDTO.
     * 
     * @param carrera Objeto Carrera.
     * @return CarreraDTO con la información de la carrera.
     */
    private CarreraDTO convertirADTO(Carrera carrera) {
        if (carrera == null) {
            return null;
        }
        return new CarreraDTO(carrera.getId(), carrera.getNombre(), carrera.getTiempoMaxUsoDiario());
    }
}
