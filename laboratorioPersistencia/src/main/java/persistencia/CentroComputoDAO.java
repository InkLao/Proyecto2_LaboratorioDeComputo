/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.CentroComputo;
import java.util.List;
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
    
    public void agregarCentroComputo(CentroComputo centroComputo){
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
    
    public void editarCentroComputo(CentroComputo centroComputo){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(centroComputo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public CentroComputo buscarCentroComputo(Long id) {
        return entityManager.find(CentroComputo.class, id);
    }

    public void eliminarCentroComputo(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            CentroComputo centroComputo = buscarCentroComputo(id);
            if (centroComputo != null) {
                entityManager.remove(centroComputo);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<CentroComputo> obtenerTodos() throws PersistenciaException {
    try {
        return entityManager.createQuery("SELECT c FROM CentroComputo c", CentroComputo.class).getResultList();
    } catch (Exception e) {
        throw new PersistenciaException("Error al obtener todos los centros de cómputo", e);
    }
}

}
