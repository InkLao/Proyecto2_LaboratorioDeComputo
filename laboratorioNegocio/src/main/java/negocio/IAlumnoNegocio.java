/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Carrera;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IAlumnoNegocio {
      List<AlumnoDTO> buscarAlumnosTabla() ;
    
     AlumnoDTO guardarAlumnos(AlumnoDTO alumnoDTO) ;
    
     AlumnoDTO obtenerPorId(Long id) ;
    
     List<AlumnoDTO> obtenerTodos() ;
    
     AlumnoDTO actualizarAlumnos(AlumnoDTO alumnoDTO) ;
    
    void eliminarAlumnos(AlumnoDTO alumnoDTO) ;
    
     List<AlumnoDTO> buscarAlumnosTabla(String nombre) ;
    AlumnoDTO buscarAlumno(Long id);
    
    public Carrera convertirAEntidad(CarreraDTO carrera);
    public Alumno convertirAEntidad(AlumnoDTO alumno);
}

