package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import entidades.UnidadAcademica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Clase de acceso a datos (DAO) para la entidad UnidadAcademica. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de las unidades académicas en la base de datos.
 * 
 * Implementa la interfaz {@link IUnidadAcademicaDAO}.
 * 
 * @autor Oley
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO {
    
    /**
     * Administrador de entidades para gestionar la persistencia de datos.
     */
    private EntityManager entityManager;

    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor de la clase UnidadAcademicaDAO que recibe un EntityManager y un EntityManagerFactory.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     * @param emf El EntityManagerFactory para crear instancias de EntityManager.
     */
    public UnidadAcademicaDAO(EntityManager entityManager, EntityManagerFactory emf) {
        this.entityManager = entityManager;
    }

    /**
     * Agrega una nueva unidad académica a la base de datos.
     * 
     * @param unidadAcademica La unidad académica a agregar.
     */
    public void agregarUnidadAcademica(UnidadAcademica unidadAcademica) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(unidadAcademica);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una lista de todas las unidades académicas en la base de datos.
     * 
     * @return Lista de todas las unidades académicas.
     */
    @Override
    public List<UnidadAcademica> obtenerTodas() {
        return entityManager.createQuery("SELECT u FROM UnidadAcademica u", UnidadAcademica.class).getResultList();
    }

    /**
     * Busca una unidad académica por su ID en la base de datos.
     * 
     * @param id El ID de la unidad académica a buscar.
     * @return La unidad académica encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la unidad académica.
     */
    @Override
    public UnidadAcademica buscarUnidadAcademica(Long id) throws PersistenciaException {
        try {
            EntityManager entityManager = emf.createEntityManager();
            UnidadAcademica unidadAcademica = entityManager.find(UnidadAcademica.class, id);
            entityManager.close();
            return unidadAcademica;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error en buscarUnidadAcademica por ID en persistencia");
            throw new PersistenciaException("Error al buscar la unidad académica por ID", e);
        }
    }
}
