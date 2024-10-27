/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Bloqueo;
import entidades.CentroComputo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oley
 */
public class CentroComputoDAO implements ICentroComputoDAO {

    private EntityManager entityManager;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    public CentroComputoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void agregarCentroComputo(CentroComputo centroComputo) {
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

    public void editarCentroComputo(CentroComputo centroComputo) {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(centroComputo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public CentroComputo buscarCentroComputo(Long id) {
        return entityManager.find(CentroComputo.class, id);
    }

    @Override
    public CentroComputo eliminarCentroComputo(CentroComputo centroComputo) {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(centroComputo);
        entityManager.getTransaction().commit();
        entityManager.close();

        return centroComputo;
    }

    @Override
    public List<CentroComputo> obtenerTodos() throws PersistenciaException {
        try {
            return entityManager.createQuery("SELECT c FROM CentroComputo c", CentroComputo.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los centros de cómputo", e);
        }
    }
    
    
    @Override
    public List<CentroComputo> obtenerTodosLosQueEstanActivos() throws PersistenciaException {
        
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from CentroComputo c
                                    WHERE c.eliminado = :eliminado
                                
                                """;
            TypedQuery<CentroComputo> query = em.createQuery(consultaJPQL, CentroComputo.class);
            query.setParameter("eliminado", false);
            
            List<CentroComputo> centroComputos = query.getResultList();
            
            return centroComputos;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }
    
    
    @Override
    public CentroComputo obtenerPorCentroNombre(String nombre) throws PersistenciaException{
        
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from CentroComputo c
                                    WHERE c.nombre = :nombre
                                
                                """;
            TypedQuery<CentroComputo> query = em.createQuery(consultaJPQL, CentroComputo.class);
            query.setParameter("nombre", nombre);
            
            CentroComputo centroComputo = query.getSingleResult();
            
            return centroComputo;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }

}
