/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Carrera;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.AlumnoDAO;
import persistencia.IAlumnoDAO;

/**
 *
 * @author Oley
 */
public class AlumnoNegocio implements  IAlumnoNegocio{
   private IAlumnoDAO alumnoDAO;

    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public void agregarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = convertirADto(alumnoDTO);
        alumnoDAO.agregarAlumno(alumno);
    }

    public void editarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = convertirADto(alumnoDTO);
        alumnoDAO.editarAlumno(alumno);
    }

    public AlumnoDTO buscarAlumno(Long id) {
        Alumno alumno = alumnoDAO.buscarAlumno(id);
        return convertirADto(alumno);
    }

    public void eliminarAlumno(Long id) {
        alumnoDAO.eliminarAlumno(id);
    }

    public Alumno convertirADto(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return null;
        }
        Carrera carrera = null;
        if (alumnoDTO.getCarrera() != null) {
            carrera = new Carrera();
            carrera.setId(alumnoDTO.getCarrera().getId());
            carrera.setNombre(alumnoDTO.getCarrera().getNombre());
        }
        return new Alumno(
            alumnoDTO.getId(),
            alumnoDTO.getNombres(),
            alumnoDTO.getApellidoPaterno(),
            alumnoDTO.getApellidoMaterno(),
            alumnoDTO.getContraseña(),
            carrera
        );
    }

    public AlumnoDTO convertirADto(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        CarreraDTO carreraDTO = null;
        if (alumno.getCarrera() != null) {
            carreraDTO = new CarreraDTO();
            carreraDTO.setId(alumno.getCarrera().getId());
            carreraDTO.setNombre(alumno.getCarrera().getNombre());
        }
        return new AlumnoDTO(
            alumno.getNombres(),
            alumno.getApellidoPaterno(),
            alumno.getApellidoMaterno(),
            alumno.getContraseña(),
            carreraDTO
        );
    }
    
    
    @Override
    public Alumno convertirAEntidad(AlumnoDTO alumno) {
        if (alumno == null) {
            return null;
        }
        CarreraDTO carreraDTO = null;
        if (alumno.getCarrera() != null) {
            carreraDTO = new CarreraDTO();
            carreraDTO.setId(alumno.getCarrera().getId());
            carreraDTO.setNombre(alumno.getCarrera().getNombre());
        }
        return new Alumno(
            alumno.getNombres(),
            alumno.getApellidoPaterno(),
            alumno.getApellidoMaterno(),
            alumno.getContraseña(),
            this.convertirAEntidad(alumno.getCarrera())
        );
    }    
    
    @Override
    public Carrera convertirAEntidad(CarreraDTO carrera) {
        if (carrera == null) {
            return null;
        }
        return new Carrera(              
                carrera.getNombre(),
                carrera.getTiempoMaxUsoDiario() 
        );
    }    
    
    public CarreraDTO convertirADTO(Carrera carrera) {
        if (carrera == null) {
            return null;
        }
        return new CarreraDTO(
                carrera.getNombre(),
                carrera.getTiempoMaxUsoDiario()         
        );
    } 
}
