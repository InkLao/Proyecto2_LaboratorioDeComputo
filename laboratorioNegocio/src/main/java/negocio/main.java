/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.AlumnoDTO;
import dto.CarreraDTO;
import dto.UnidadAcademicaDTO;
import entidades.UnidadAcademica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.AlumnoDAO;
import persistencia.CarreraDAO;
import persistencia.IAlumnoDAO;
import persistencia.ICarreraDAO;
import persistencia.IUnidadAcademicaDAO;
import persistencia.UnidadAcademicaDAO;

/**
 *
 * @author Oley
 */
public class main {
    public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }

        ICarreraDAO carreraDAO = new CarreraDAO(entityManager);
        ICarreraNegocio carreraNegocio = new CarreraNegocio(carreraDAO);

        CarreraDTO carreraDTO = new CarreraDTO();
        carreraDTO.setNombre("Ingeniería");
        carreraDTO.setTiempoMaxUsoDiario(8);

        System.out.println("Agregando Carrera: " + carreraDTO.getNombre());
        carreraNegocio.agregarCarrera(carreraDTO);
        System.out.println("Carrera agregada exitosamente.");
<<<<<<< Updated upstream

        IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManager);
        IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);

        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setNombres("Juan");
        alumnoDTO.setApellidoPaterno("Pérez");
        alumnoDTO.setApellidoMaterno("García");
        alumnoDTO.setContraseña("contraseña123");
        alumnoDTO.setCarrera(carreraDTO);

        alumnoNegocio.agregarAlumno(alumnoDTO);
        System.out.println("Alumno agregado exitosamente.");
    


    
       
//        IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManager);
//        IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
//
//        AlumnoDTO alumnoDTO = new AlumnoDTO(null, "Juan", "Pérez", "García", "contraseña123", carreraDTO);
//
//        alumnoNegocio.agregarAlumno(alumnoDTO);
//        System.out.println("Alumno agregado.");
//
//        AlumnoDTO encontrado = alumnoNegocio.buscarAlumno(1L);
//        System.out.println("Alumno encontrado: " + encontrado.getNombres());
//
//        encontrado.setNombres("Juan Carlos");
//        alumnoNegocio.editarAlumno(encontrado);
//        System.out.println("Alumno editado.");
//
//        alumnoNegocio.eliminarAlumno(1L);
//        System.out.println("Alumno eliminado.");
//        
=======
        
        IUnidadAcademicaDAO unidadAcademicaDAO=new UnidadAcademicaDAO(entityManager);
        IUnidadNegocio unidadNegocio=new UnidadNegocio(unidadAcademicaDAO);
        UnidadAcademicaDTO academicaDTO=new UnidadAcademicaDTO( "Arquitectura");
       unidadNegocio.agregarUnidadAcademica(academicaDTO);
           
        
>>>>>>> Stashed changes
        
    }
}
