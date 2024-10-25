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
    
    
    //private EntityManager entityManager;
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");


    
    public BloqueoDAO(EntityManager entityManager, EntityManagerFactory emf) {
        //this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Bloqueo> obtenerTodos() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        List<Bloqueo> bloqueos = em.createQuery("SELECT b FROM Bloqueo b", Bloqueo.class).getResultList();
        em.close();
        return bloqueos;
    }
    
    @Override
    public Bloqueo agregarBloqueo(Bloqueo bloqueo) {
        
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return bloqueo;
    }  
    

    @Override
    public Bloqueo editarBloqueo(Bloqueo bloqueo) {

        EntityManager entityManager = emf.createEntityManager();

        
        System.out.println("bloqueoeditar " + bloqueo.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return bloqueo;
        
    }

    @Override
    public Bloqueo buscarBloqueo(Long id) throws PersistenciaException{
        
        try{
        EntityManager entityManager = emf.createEntityManager();
  
        Bloqueo bloqueo = entityManager.find(Bloqueo.class, id);
        
        entityManager.close();
        
        return bloqueo;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("error en buscarBloqueo id persistencia");
        }
        
        return null;
    }

    @Override
    public Bloqueo eliminarBloqueo(Bloqueo bloqueo) {

        EntityManager entityManager = emf.createEntityManager();

        
        entityManager.getTransaction().begin();
        entityManager.merge(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        
        return bloqueo;
        
        
        

    }
    
    
}
