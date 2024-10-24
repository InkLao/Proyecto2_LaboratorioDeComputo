/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Carrera;
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

    private Alumno convertirADto(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return null;
        }
        Carrera carrera = new Carrera();
        return new Alumno(alumnoDTO.getId(), alumnoDTO.getNombres(), 
                          alumnoDTO.getApellidoPaterno(), alumnoDTO.getApellidoMaterno(),
                          alumnoDTO.getContraseña(), carrera);
    }

    private AlumnoDTO convertirADto(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        CarreraDTO carreraDTO = new CarreraDTO();
        return new AlumnoDTO(alumno.getId(), alumno.getNombres(), 
                             alumno.getApellidoPaterno(), alumno.getApellidoMaterno(),
                             alumno.getContraseña(), carreraDTO);
    }
}
