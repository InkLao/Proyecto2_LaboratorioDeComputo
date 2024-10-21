/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.CentroLaboratorio;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Oley
 */
public class CentroLaboratorioDAO {
      private EntityManager entityManager;

    public CentroLaboratorioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void agregarLaboratorio(CentroLaboratorio centroLaboratorio){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(centroLaboratorio);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }  
}
