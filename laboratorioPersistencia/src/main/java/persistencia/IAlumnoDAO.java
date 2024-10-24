/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Alumno;

/**
 *
 * @author Oley
 */
public interface IAlumnoDAO {
      void agregarAlumno(Alumno alumno);
       void editarAlumno(Alumno alumno);
         Alumno buscarAlumno(Long id);
            void eliminarAlumno(Long id);
}
