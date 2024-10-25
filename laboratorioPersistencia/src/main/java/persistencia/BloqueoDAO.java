/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Bloqueo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Oley
 */
public class BloqueoDAO implements IBloqueoDAO{
    
    
    private EntityManager entityManager;
    
    private EntityManagerFactory entityManagerFactory;


    
    public BloqueoDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }
    
    
    @Override
    public List<Bloqueo> obtenerTodos() throws PersistenciaException {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Bloqueo> bloqueos = em.createQuery("SELECT b FROM Bloqueo b", Bloqueo.class).getResultList();
        em.close();
        return bloqueos;
    }
    
    @Override
    public Bloqueo agregarBloqueo(Bloqueo bloqueo) {
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            entityManager.persist(bloqueo);
            transaction.commit();
            
            return bloqueo;
        } 
        
        catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
            
        }
        
        finally{
            entityManager.close();
        }
        
        return null;
    }  
    

    @Override
    public Bloqueo editarBloqueo(Bloqueo bloqueo) {

        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            entityManager.merge(bloqueo);
            transaction.commit();
        }
        
        catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
     
        finally{
            entityManager.close();
        }
        
        return null;
    }

    @Override
    public Bloqueo buscarBloqueo(Long id) {
        
        return entityManager.find(Bloqueo.class, id);
        
    }

    @Override
    public Bloqueo eliminarBloqueo(Bloqueo bloqueo) {
        
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            entityManager.merge(bloqueo);
            transaction.commit();
        }
        
        catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
     
        finally{
            entityManager.close();
        }
        
        return null;

    }
    
    
}
