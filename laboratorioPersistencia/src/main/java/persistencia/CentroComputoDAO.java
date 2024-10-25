/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.CentroComputo;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Oley
 */
public class CentroComputoDAO implements ICentroComputoDAO{
      private EntityManager entityManager;

    public CentroComputoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void agregarLaboratorio(CentroComputo centroComputo){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(centroComputo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }  
}
