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
 * Clase de acceso a datos (DAO) para la entidad CentroComputo. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de los centros de cómputo en la base de datos.
 * 
 * Implementa la interfaz {@link ICentroComputoDAO}.
 * 
 * @autor Oley
 */
public class CentroComputoDAO implements ICentroComputoDAO {

    /**
     * Administrador de entidades para gestionar la persistencia de datos.
     */
    private EntityManager entityManager;

    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor de la clase CentroComputoDAO que recibe un EntityManager.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     */
    public CentroComputoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Agrega un nuevo centro de cómputo a la base de datos.
     * 
     * @param centroComputo El centro de cómputo a agregar.
     */
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

    /**
     * Edita un centro de cómputo existente en la base de datos.
     * 
     * @param centroComputo El centro de cómputo con los datos actualizados.
     */
    public void editarCentroComputo(CentroComputo centroComputo) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(centroComputo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Busca un centro de cómputo por su ID en la base de datos.
     * 
     * @param id El ID del centro de cómputo a buscar.
     * @return El centro de cómputo encontrado o {@code null} si no existe.
     */
    @Override
    public CentroComputo buscarCentroComputo(Long id) {
        return entityManager.find(CentroComputo.class, id);
    }

    /**
     * Marca un centro de cómputo como eliminado en la base de datos.
     * 
     * @param centroComputo El centro de cómputo a eliminar.
     * @return El centro de cómputo eliminado.
     */
    @Override
    public CentroComputo eliminarCentroComputo(CentroComputo centroComputo) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(centroComputo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return centroComputo;
    }

    /**
     * Obtiene una lista de todos los centros de cómputo en la base de datos.
     * 
     * @return Lista de todos los centros de cómputo.
     * @throws PersistenciaException Si ocurre un error al obtener los centros de cómputo.
     */
    @Override
    public List<CentroComputo> obtenerTodos() throws PersistenciaException {
        try {
            return entityManager.createQuery("SELECT c FROM CentroComputo c", CentroComputo.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los centros de cómputo", e);
        }
    }

    /**
     * Obtiene una lista de todos los centros de cómputo activos en la base de datos.
     * 
     * @return Lista de centros de cómputo activos.
     * @throws PersistenciaException Si ocurre un error al obtener los centros de cómputo.
     */
    @Override
    public List<CentroComputo> obtenerTodosLosQueEstanActivos() throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                SELECT c FROM CentroComputo c
                WHERE c.eliminado = :eliminado
                """;
            TypedQuery<CentroComputo> query = em.createQuery(consultaJPQL, CentroComputo.class);
            query.setParameter("eliminado", false);
            List<CentroComputo> centroComputos = query.getResultList();
            em.close();
            return centroComputos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al obtener los centros de cómputo activos", e);
        }
    }

    /**
     * Obtiene un centro de cómputo de la base de datos según su nombre.
     * 
     * @param nombre El nombre del centro de cómputo a buscar.
     * @return El centro de cómputo encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar el centro de cómputo.
     */
    @Override
    public CentroComputo obtenerPorCentroNombre(String nombre) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                SELECT c FROM CentroComputo c
                WHERE c.nombre = :nombre
                """;
            TypedQuery<CentroComputo> query = em.createQuery(consultaJPQL, CentroComputo.class);
            query.setParameter("nombre", nombre);
            CentroComputo centroComputo = query.getSingleResult();
            em.close();
            return centroComputo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar el centro de cómputo por nombre", e);
        }
    }
}
