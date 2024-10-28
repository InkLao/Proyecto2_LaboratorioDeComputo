package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Clase de acceso a datos (DAO) para la entidad Carrera. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de carreras en la base de datos.
 * 
 * Implementa la interfaz {@link ICarreraDAO}.
 * 
 * @autor Oley
 */
public class CarreraDAO implements ICarreraDAO {
    
    /**
     * Administrador de entidades para gestionar la persistencia de datos.
     */
    private EntityManager entityManager;

    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory entityManagerFactory;   

    /**
     * Constructor de la clase CarreraDAO que recibe un EntityManager y un EntityManagerFactory.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     * @param entityManagerFactory El EntityManagerFactory para crear instancias de EntityManager.
     */
    public CarreraDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }
    
    /**
     * Agrega una nueva carrera a la base de datos.
     * 
     * @param carrera La carrera a agregar.
     */
    public void agregarCarrera(Carrera carrera) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(carrera);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }  

    /**
     * Obtiene una carrera de la base de datos según su nombre.
     * 
     * @param nombre El nombre de la carrera a buscar.
     * @return La carrera encontrada o {@code null} si no existe.
     */
    @Override
    public Carrera obtenerCarreraPorNombre(String nombre) {
        try {
            return entityManager.createQuery("SELECT c FROM Carrera c WHERE c.nombre = :nombre", Carrera.class)
                                .setParameter("nombre", nombre)
                                .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
    }
    
    /**
     * Obtiene una lista de todas las carreras en la base de datos.
     * 
     * @return Lista de todas las carreras.
     * @throws PersistenciaException Si ocurre un error al obtener las carreras.
     */
    @Override
    public List<Carrera> obtenerTodos() throws PersistenciaException {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
        em.close();
        return carreras;
    }
}
