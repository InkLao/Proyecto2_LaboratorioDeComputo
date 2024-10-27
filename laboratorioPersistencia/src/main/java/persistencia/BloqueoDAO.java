/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Bloqueo;
import java.util.Calendar;
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
public class BloqueoDAO implements IBloqueoDAO {

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
    public Bloqueo buscarBloqueo(Long id) throws PersistenciaException {

        try {
            EntityManager entityManager = emf.createEntityManager();

            Bloqueo bloqueo = entityManager.find(Bloqueo.class, id);

            entityManager.close();

            return bloqueo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error en buscarBloqueo id persistencia");
        }

        return null;
    }

    @Override
    public List<Bloqueo> buscarBloqueo(String motivo) throws PersistenciaException {

        try {
            EntityManager em = emf.createEntityManager();

            String consultaJPQL = """
                                    SELECT b from Bloqueo b
                                    WHERE b.motivo = :motivo
                                
                                """;
            TypedQuery<Bloqueo> query = em.createQuery(consultaJPQL, Bloqueo.class);
            query.setParameter("motivo", motivo);

            List<Bloqueo> bloqueo = query.getResultList();

            return bloqueo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    @Override
    public List<Bloqueo> buscarBloqueoPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            String consultaJPQL = """
                SELECT b FROM Bloqueo b
                WHERE b.fechaBloqueo >= :fechaInicio AND b.fechaLiberacion <= :fechaFinal
                """;

            TypedQuery<Bloqueo> query = em.createQuery(consultaJPQL, Bloqueo.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFinal", fechaFinal);

            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar bloqueos por fecha: " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
