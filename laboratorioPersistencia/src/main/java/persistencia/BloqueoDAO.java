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
 * Implementación de la interfaz `IBloqueoDAO` para gestionar las operaciones CRUD de la entidad `Bloqueo` 
 * en la base de datos.
 * 
 * @author Oley
 */
public class BloqueoDAO implements IBloqueoDAO {

    /**
     * Fábrica de `EntityManager` para la gestión de transacciones en la base de datos.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor de la clase BloqueoDAO.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     * @param emf Fábrica de `EntityManager` para la gestión de transacciones
     */
    public BloqueoDAO(EntityManager entityManager, EntityManagerFactory emf) {
        // No se utiliza el entityManager en este momento, pero podría ser necesario para futuras modificaciones.
    }

    /**
     * Obtiene todos los bloqueos almacenados en la base de datos.
     *
     * @return Lista de todos los bloqueos
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    @Override
    public List<Bloqueo> obtenerTodos() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        List<Bloqueo> bloqueos = em.createQuery("SELECT b FROM Bloqueo b", Bloqueo.class).getResultList();
        em.close();
        return bloqueos;
    }

    /**
     * Agrega un nuevo bloqueo a la base de datos.
     *
     * @param bloqueo Bloqueo a agregar
     * @return Bloqueo agregado
     */
    @Override
    public Bloqueo agregarBloqueo(Bloqueo bloqueo) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bloqueo;
    }

    /**
     * Edita un bloqueo existente en la base de datos.
     *
     * @param bloqueo Bloqueo a editar
     * @return Bloqueo editado
     */
    @Override
    public Bloqueo editarBloqueo(Bloqueo bloqueo) {
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("bloqueo editar " + bloqueo.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bloqueo;
    }

    /**
     * Busca un bloqueo por su identificador en la base de datos.
     *
     * @param id Identificador del bloqueo
     * @return Bloqueo encontrado o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
     */
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

    /**
     * Busca bloqueos por motivo en la base de datos.
     *
     * @param motivo Motivo del bloqueo
     * @return Lista de bloqueos que coinciden con el motivo
     * @throws PersistenciaException si ocurre un error durante la operación
     */
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

    /**
     * Elimina un bloqueo de la base de datos (marcado como eliminado).
     *
     * @param bloqueo Bloqueo a eliminar
     * @return Bloqueo eliminado
     */
    @Override
    public Bloqueo eliminarBloqueo(Bloqueo bloqueo) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bloqueo;
    }

    /**
     * Busca bloqueos en un rango de fechas de aplicación.
     *
     * @param fechaInicio Fecha de inicio del rango
     * @param fechaFinal Fecha final del rango
     * @return Lista de bloqueos que están en el rango de fechas
     * @throws PersistenciaException si ocurre un error durante la operación
     */
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