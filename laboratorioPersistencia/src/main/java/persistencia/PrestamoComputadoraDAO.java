package persistencia;

import Excepciones.PersistenciaException;
import entidades.Alumno;
import entidades.Computadora;
import entidades.PrestamoComputadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Clase de acceso a datos (DAO) para la entidad PrestamoComputadora. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de préstamos de computadoras en la base de datos.
 * 
 * Implementa la interfaz IPrestamoComputadoraDAO.
 * 
 * @autor Arturo ITSON
 */
public class PrestamoComputadoraDAO implements IPrestamoComputadoraDAO {
    
    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor de la clase PrestamoComputadoraDAO que recibe un EntityManager y un EntityManagerFactory.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     * @param emf El EntityManagerFactory para crear instancias de EntityManager.
     */
    public PrestamoComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        // Implementación de inicialización si es necesario
    }

    /**
     * Busca un préstamo de computadora por su ID en la base de datos.
     * 
     * @param id El ID del préstamo de computadora a buscar.
     * @return El préstamo de computadora encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar el préstamo de computadora.
     */
    @Override
    public PrestamoComputadora buscarPrestamoComputadora(Long id) throws PersistenciaException {
        EntityManager entityManager = emf.createEntityManager();
        PrestamoComputadora prestamoComputadora = null;
        try {
            prestamoComputadora = entityManager.find(PrestamoComputadora.class, id);
            entityManager.refresh(prestamoComputadora);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return prestamoComputadora;
    }

    /**
     * Agrega un nuevo préstamo de computadora a la base de datos.
     * 
     * @param prestamoComputadora El préstamo de computadora a agregar.
     * @return El préstamo de computadora agregado con los datos persistidos.
     */
    @Override
    public PrestamoComputadora agregarPrestamoComputadora(PrestamoComputadora prestamoComputadora) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(prestamoComputadora);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return prestamoComputadora;
    }

    /**
     * Edita un préstamo de computadora existente en la base de datos.
     * 
     * @param prestamoComputadora El préstamo de computadora con los datos actualizados.
     * @return El préstamo de computadora editado.
     */
    @Override
    public PrestamoComputadora editarPrestamoComputadora(PrestamoComputadora prestamoComputadora) {
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("prestamoEditar " + prestamoComputadora.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(prestamoComputadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        return prestamoComputadora;
    }

    /**
     * Busca el último préstamo realizado por un alumno específico.
     * 
     * @param alumno El alumno cuyo último préstamo se desea buscar.
     * @return Lista de préstamos de computadora realizados por el alumno.
     * @throws PersistenciaException Si ocurre un error al buscar el último préstamo del alumno.
     */
    @Override
    public List<PrestamoComputadora> buscarUltimoPrestamoAlumno(Alumno alumno) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                SELECT p FROM PrestamoComputadora p
                WHERE p.alumno = :alumno
                """;
            TypedQuery<PrestamoComputadora> query = em.createQuery(consultaJPQL, PrestamoComputadora.class);
            query.setParameter("alumno", alumno);
            List<PrestamoComputadora> prestamo = query.getResultList();
            em.close();
            return prestamo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar el último préstamo por alumno", e);
        }
    }

    /**
     * Busca el último préstamo realizado de una computadora específica.
     * 
     * @param computadora La computadora cuyo último préstamo se desea buscar.
     * @return Lista de préstamos de computadora relacionados con la computadora especificada.
     * @throws PersistenciaException Si ocurre un error al buscar el último préstamo de la computadora.
     */
    @Override
    public List<PrestamoComputadora> buscarUltimoPrestamoPorComputadora(Computadora computadora) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                SELECT p FROM PrestamoComputadora p
                WHERE p.computadora = :computadora
                """;
            TypedQuery<PrestamoComputadora> query = em.createQuery(consultaJPQL, PrestamoComputadora.class);
            query.setParameter("computadora", computadora);
            List<PrestamoComputadora> prestamo = query.getResultList();
            em.close();
            return prestamo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar el último préstamo por computadora", e);
        }
    }
}
