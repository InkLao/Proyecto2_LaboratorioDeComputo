/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Carrera;
import entidades.UnidadAcademica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Oley
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{
     private EntityManager entityManager;

    public UnidadAcademicaDAO(EntityManager entityManager) {
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
}
