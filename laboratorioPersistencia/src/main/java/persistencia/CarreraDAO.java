/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Oley
 */
public class CarreraDAO implements ICarreraDAO{
       
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;   

    public CarreraDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }
    
    public void agregarCarrera(Carrera carrera){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(carrera);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }  

    @Override
    public Carrera obtenerCarreraPorNombre(String nombre) {
   try {
            return entityManager.createQuery("SELECT c FROM Carrera c WHERE c.nombre = :nombre", Carrera.class)
                                .setParameter("nombre", nombre)
                                .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
    }
    
    
    @Override
    public List<Carrera> obtenerTodos() throws PersistenciaException {
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
        
        em.close();
        
        return carreras;
    }
}
