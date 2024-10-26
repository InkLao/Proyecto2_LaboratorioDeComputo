/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IAlumnoDAO {
    Alumno agregarAlumno(Alumno alumno);
       Alumno editarAlumno(Alumno alumno);
         Alumno buscarAlumno(Long id);
            Alumno eliminarAlumno(Alumno alumno);
            List<Alumno> obtenerTodos();
            List<Alumno> buscarAlumno(String nombre);
}
