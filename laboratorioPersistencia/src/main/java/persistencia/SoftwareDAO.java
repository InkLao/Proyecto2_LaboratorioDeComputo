package persistencia;

import entidades.Computadora;
import entidades.Software;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Clase de acceso a datos (DAO) para la entidad Software. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de software en la base de datos.
 * 
 * @autor Oley
 */
public class SoftwareDAO {

    /**
     * Administrador de entidades para gestionar la persistencia de datos.
     */
    private EntityManager entityManager;

    /**
     * Constructor de la clase SoftwareDAO que recibe un EntityManager.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     */
    public SoftwareDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Agrega un nuevo software a la base de datos.
     * 
     * @param software El software a agregar.
     */
    public void agregarSoftware(Software software) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(software);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
