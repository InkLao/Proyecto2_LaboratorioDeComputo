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
 * Clase de acceso a datos (DAO) para la entidad Bloqueo. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de bloqueos en la base de datos.
 * 
 * Implementa la interfaz {@link IBloqueoDAO}.
 * 
 * @autor Oley
 */
public class BloqueoDAO implements IBloqueoDAO {

    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor de la clase BloqueoDAO que recibe un EntityManager y un EntityManagerFactory.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     * @param emf El EntityManagerFactory para crear instancias de EntityManager.
     */
    public BloqueoDAO(EntityManager entityManager, EntityManagerFactory emf) {
        // Implementación de inicialización si es necesario
    }

    /**
     * Obtiene una lista de todos los bloqueos en la base de datos.
     * 
     * @return Lista de todos los bloqueos.
     * @throws PersistenciaException Si ocurre un error al obtener los bloqueos.
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
     * @param bloqueo El bloqueo a agregar.
     * @return El bloqueo agregado con los datos persistidos.
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
     * @param bloqueo El bloqueo con los datos actualizados.
     * @return El bloqueo editado.
     */
    @Override
    public Bloqueo editarBloqueo(Bloqueo bloqueo) {
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("bloqueo a editar " + bloqueo.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(bloqueo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bloqueo;
    }

    /**
     * Busca un bloqueo por su ID en la base de datos.
     * 
     * @param id El ID del bloqueo a buscar.
     * @return El bloqueo encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar el bloqueo.
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
            System.out.println("Error en buscarBloqueo id persistencia");
            throw new PersistenciaException("Error al buscar el bloqueo: " + e.getMessage());
        }
    }

    /**
     * Busca bloqueos por el motivo especificado en la base de datos.
     * 
     * @param motivo El motivo del bloqueo a buscar.
     * @return Lista de bloqueos con el motivo especificado, o {@code null} si ocurre un error.
     * @throws PersistenciaException Si ocurre un error al buscar el bloqueo.
     */
    @Override
    public List<Bloqueo> buscarBloqueo(String motivo) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                SELECT b FROM Bloqueo b
                WHERE b.motivo = :motivo
                """;
            TypedQuery<Bloqueo> query = em.createQuery(consultaJPQL, Bloqueo.class);
            query.setParameter("motivo", motivo);
            List<Bloqueo> bloqueos = query.getResultList();
            em.close();
            return bloqueos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar bloqueos por motivo: " + e.getMessage());
        }
    }

    /**
     * Marca un bloqueo como eliminado en la base de datos.
     * 
     * @param bloqueo El bloqueo a eliminar.
     * @return El bloqueo eliminado.
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
     * Busca bloqueos en la base de datos que tengan una fecha de bloqueo entre las fechas especificadas.
     * 
     * @param fechaInicio Fecha de inicio del rango.
     * @param fechaFinal Fecha de fin del rango.
     * @return Lista de bloqueos dentro del rango de fechas.
     * @throws PersistenciaException Si ocurre un error al buscar bloqueos por fecha.
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

