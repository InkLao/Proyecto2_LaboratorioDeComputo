/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.CarreraDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.CarreraDAO;
import persistencia.ICarreraDAO;

/**
 *
 * @author Oley
 */
public class main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ICarreraDAO carreraDAO = new CarreraDAO(entityManager);
        ICarreraNegocio carreraNegocio = new CarreraNegocio(carreraDAO);

        CarreraDTO carreraDTO = new CarreraDTO( "Ingeniería", 8);

        carreraNegocio.agregarCarrera(carreraDTO);

        System.out.println("Carrera agregada exitosamente.");
        
        
    }
}
