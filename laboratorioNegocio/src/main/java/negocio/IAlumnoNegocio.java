/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Carrera;

/**
 *
 * @author Oley
 */
public interface IAlumnoNegocio {
    void agregarAlumno(AlumnoDTO alumno);
    void editarAlumno(AlumnoDTO alumno);
    AlumnoDTO buscarAlumno(Long id);
    void eliminarAlumno(Long id);
    
    public Carrera convertirAEntidad(CarreraDTO carrera);
    public Alumno convertirAEntidad(AlumnoDTO alumno);
}

