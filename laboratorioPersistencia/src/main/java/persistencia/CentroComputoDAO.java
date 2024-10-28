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
 * Implementación de la interfaz `ICentroComputoDAO` que gestiona las operaciones CRUD de la entidad `CentroComputo`
 * en la base de datos. Proporciona métodos para agregar, editar, eliminar y buscar centros de cómputo,
 * además de consultar centros activos y obtener un centro por nombre.
 * 
 * @author Oley
 */
public class CentroComputoDAO implements ICentroComputoDAO {

    /**
     * `EntityManager` utilizado para manejar las entidades dentro de las transacciones.
     */
    private EntityManager entityManager;
    
    /**
     * Fábrica de `EntityManager` para la gestión de transacciones en la base de datos.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor que inicializa `CentroComputoDAO` con un objeto `EntityManager`.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     */
    public CentroComputoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Agrega un nuevo centro de cómputo a la base de datos.
     *
     * @param centroComputo Centro de cómputo a agregar
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
     * Edita un centro de cómputo en la base de datos.
     *
     * @param centroComputo Centro de cómputo a editar
     */
    public void editarCentroComputo(CentroComputo centroComputo) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(centroComputo);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Busca un centro de cómputo por su identificador en la base de datos.
     *
     * @param id Identificador del centro de cómputo
     * @return Centro de cómputo encontrado o null si no existe
     */
    @Override
    public CentroComputo buscarCentroComputo(Long id) {
        return entityManager.find(CentroComputo.class, id);
    }

    /**
     * Marca un centro de cómputo como eliminado en la base de datos.
     *
     * @param centroComputo Centro de cómputo a eliminar
     * @return Centro de cómputo eliminado
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
     * Obtiene todos los centros de cómputo almacenados en la base de datos.
     *
     * @return Lista de todos los centros de cómputo
     * @throws PersistenciaException si ocurre un error durante la operación
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
     * Obtiene todos los centros de cómputo que están activos (no eliminados).
     *
     * @return Lista de centros de cómputo activos
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    @Override
    public List<CentroComputo> obtenerTodosLosQueEstanActivos() throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                                    SELECT c from CentroComputo c
                                    WHERE c.eliminado = :eliminado
                                  """;
            TypedQuery<CentroComputo> query = em.createQuery(consultaJPQL, CentroComputo.class);
            query.setParameter("eliminado", false);
            List<CentroComputo> centroComputos = query.getResultList();
            return centroComputos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * Obtiene un centro de cómputo por su nombre.
     *
     * @param nombre Nombre del centro de cómputo
     * @return Centro de cómputo encontrado o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    @Override
    public CentroComputo obtenerPorCentroNombre(String nombre) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                                    SELECT c from CentroComputo c
                                    WHERE c.nombre = :nombre
                                  """;
            TypedQuery<CentroComputo> query = em.createQuery(consultaJPQL, CentroComputo.class);
            query.setParameter("nombre", nombre);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}