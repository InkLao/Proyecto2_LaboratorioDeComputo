/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import entidades.Carrera;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oley
 */
public class AlumnoPrueba {
    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager em = emf.createEntityManager();
        IAlumnoDAO alumnoDAO = new AlumnoDAO(emf);
  

        // Crea una instancia de CarreraDAO
        CarreraDAO carreraDAO = new CarreraDAO(em);
Carrera carrera2=new Carrera("isw", 6);
carreraDAO.agregarCarrera(carrera2);
        // Prueba el método obtenerCarreraPorNombre
        String nombreCarrera = "isw"; // Cambia esto al nombre que desees buscar
        Carrera carrera = carreraDAO.obtenerCarreraPorNombre(nombreCarrera);

        if (carrera != null) {
            System.out.println("Carrera encontrada: " + carrera.getNombre());
        } else {
            System.out.println("No se encontró la carrera con el nombre: " + nombreCarrera);
        }

        // 1. Agregar un nuevo alumno
        Alumno nuevoAlumno = new Alumno(1L, "orla", "ley", "fon", "1233444", false, carrera);
        alumnoDAO.agregarAlumno(nuevoAlumno);
        System.out.println("Alumno agregado: " + nuevoAlumno);
//
        // 2. Buscar un alumno por ID
        Alumno encontrado = alumnoDAO.buscarAlumno(nuevoAlumno.getId());
        System.out.println("Alumno encontrado: " + (encontrado != null ? encontrado : "No encontrado"));
//
        // 3. Editar un alumno
        if (encontrado != null) {
            encontrado.setNombres("Juanito");
            Alumno alumnoEditado = alumnoDAO.editarAlumno(encontrado);
            System.out.println("Alumno editado: " + alumnoEditado);
        }
//
//        // 4. Obtener todos los alumnos
//        List<Alumno> todosLosAlumnos = alumnoDAO.obtenerTodos();
//        System.out.println("Lista de todos los alumnos:");
//        for (Alumno alumno : todosLosAlumnos) {
//            System.out.println(alumno);
//        }
//
//        // 5. Buscar alumno por nombre
//        List<Alumno> alumnosPorNombre = alumnoDAO.buscarAlumno("Juanito");
//        System.out.println("Alumnos encontrados con nombre 'Juanito':");
//        for (Alumno alumno : alumnosPorNombre) {
//            System.out.println(alumno);
//        }
//
//        // 6. Eliminar un alumno
//        if (encontrado != null) {
//            alumnoDAO.eliminarAlumno(encontrado);
//            System.out.println("Alumno eliminado: " + encontrado);
//        }
    }
}
