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

        try {
            IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManager);
            AlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
            ICarreraDAO carreraDAO=new CarreraDAO(entityManager);
ICarreraNegocio carreraNegocio=new CarreraNegocio(carreraDAO);
  
            CarreraDTO carreraDTO = new CarreraDTO();
            carreraDTO.setNombre("Ingeniería en Software");
            carreraDTO.setTiempoMaxUsoDiario(240);
            carreraNegocio.agregarCarrera(carreraDTO);
            AlumnoDTO alumnoDTO = new AlumnoDTO(
                "Juan",
                "Pérez",
                "García",
                "contraseña123",
                carreraDTO
            );

            System.out.println("\n--- Agregando alumno ---");
            alumnoNegocio.agregarAlumno(alumnoDTO);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
            if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
                entityManagerFactory.close();
            }
        }
    }

}

     



    
    

