/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.AlumnoDAO;
import persistencia.CarreraDAO;
import persistencia.IAlumnoDAO;
import persistencia.ICarreraDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Oley
 */
public class probarAlumno {
    public static void main(String[] args) {
      // Configuración del EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Crear instancia de IAlumnoDAO
        IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManagerFactory);
        AlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);

        // Probar guardar un nuevo alumno
        System.out.println("Guardando un nuevo alumno...");
        CarreraDTO carreraDTO = new CarreraDTO("ISW", 7);
        AlumnoDTO nuevoAlumno = new AlumnoDTO(1L, "Orlando", "leyva", "fontes", "12", carreraDTO, false);
        AlumnoDTO alumnoGuardado = alumnoNegocio.guardarAlumnos(nuevoAlumno);
        System.out.println("Alumno guardado: " + alumnoGuardado);

        // Probar buscar un alumno por ID
        System.out.println("Buscando alumno con ID 1...");
        AlumnoDTO alumnoBuscado = alumnoNegocio.buscarAlumno(1L);
        System.out.println("Alumno encontrado: " + alumnoBuscado);

        // Probar obtener todos los alumnos
        System.out.println("Obteniendo todos los alumnos...");
        List<AlumnoDTO> todosLosAlumnos = alumnoNegocio.obtenerTodos();
        todosLosAlumnos.forEach(alumno -> System.out.println(alumno));

        // Probar actualizar un alumno
        System.out.println("Actualizando alumno con ID 1...");
        if (alumnoBuscado != null) {
            alumnoBuscado.setApellidoPaterno("Gómez-Pérez");
            AlumnoDTO alumnoActualizado = alumnoNegocio.actualizarAlumnos(alumnoBuscado);
            System.out.println("Alumno actualizado: " + alumnoActualizado);
        }

        // Probar eliminar un alumno
        System.out.println("Eliminando alumno con ID 1...");
        if (alumnoBuscado != null) {
            alumnoNegocio.eliminarAlumnos(alumnoBuscado);
            System.out.println("Alumno eliminado.");
        }

        // Cerrar EntityManager y Factory
        entityManager.close();
        entityManagerFactory.close();
    }
}
