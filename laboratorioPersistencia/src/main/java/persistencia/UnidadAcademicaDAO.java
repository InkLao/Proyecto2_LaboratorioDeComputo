/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import entidades.UnidadAcademica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Oley
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{
     
    
    private EntityManager entityManager;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    
    public UnidadAcademicaDAO(EntityManager entityManager, EntityManagerFactory emf) {
        this.entityManager = entityManager;
    }
    
    public void agregarUnidadAcademica(UnidadAcademica  unidadAcademica){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(unidadAcademica);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }
    
    @Override
    public List<UnidadAcademica> obtenerTodas() {
        return entityManager.createQuery("SELECT u FROM UnidadAcademica u", UnidadAcademica.class).getResultList();
    }
    
    
    @Override
    public UnidadAcademica buscarUnidadAcademica(Long id) throws PersistenciaException{
        
        try{
        EntityManager entityManager = emf.createEntityManager();
  
        UnidadAcademica unidadAcademica = entityManager.find(UnidadAcademica.class, id);
        
        entityManager.close();
        
        return unidadAcademica;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("error en buscarBloqueo id persistencia");
        }
        
        return null;
    }
    
    
}
