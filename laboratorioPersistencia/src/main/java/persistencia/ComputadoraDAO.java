package persistencia;

import Excepciones.PersistenciaException;
import entidades.Computadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Clase de acceso a datos (DAO) para la entidad Computadora. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de las computadoras en la base de datos.
 * 
 * Implementa la interfaz {@link IComputadoraDAO}.
 * 
 * @autor Oley
 */
public class ComputadoraDAO implements IComputadoraDAO {

    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor de la clase ComputadoraDAO que recibe un EntityManager y un EntityManagerFactory.
     * 
     * @param entityManager El EntityManager para gestionar la persistencia de datos.
     * @param emf El EntityManagerFactory para crear instancias de EntityManager.
     */
    public ComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        // Implementación de inicialización si es necesario
    }
    
    /**
     * Obtiene una lista de todas las computadoras en la base de datos.
     * 
     * @return Lista de todas las computadoras.
     * @throws PersistenciaException Si ocurre un error al obtener las computadoras.
     */
    @Override
    public List<Computadora> obtenerTodos() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        List<Computadora> computadoras = em.createQuery("SELECT c FROM Computadora c", Computadora.class).getResultList();
        em.close();
        return computadoras;
    }

    /**
     * Agrega una nueva computadora a la base de datos.
     * 
     * @param computadora La computadora a agregar.
     * @return La computadora agregada con los datos persistidos.
     */
    @Override
    public Computadora agregarComputadora(Computadora computadora) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(computadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        return computadora;
    }

    /**
     * Edita una computadora existente en la base de datos.
     * 
     * @param computadora La computadora con los datos actualizados.
     * @return La computadora editada.
     */
    @Override
    public Computadora editarComputadora(Computadora computadora) {
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("editar " + computadora.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(computadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        return computadora;
    }

    /**
     * Busca una computadora por su ID en la base de datos.
     * 
     * @param id El ID de la computadora a buscar.
     * @return La computadora encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la computadora.
     */
    @Override
    public Computadora buscarComputadora(Long id) throws PersistenciaException {
        try {
            EntityManager entityManager = emf.createEntityManager();
            Computadora computadora = entityManager.find(Computadora.class, id);
            entityManager.close();
            return computadora;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar computadora por ID", e);
        }
    }

    /**
     * Busca una computadora por su número de máquina en la base de datos.
     * 
     * @param numMaquina El número de máquina de la computadora a buscar.
     * @return La computadora encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la computadora.
     */
    @Override
    public Computadora buscarComputadorasPorNumMaquina(Integer numMaquina) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.numeroMaquina = :numeroMaquina
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("numeroMaquina", numMaquina);
            Computadora computadora = query.getSingleResult();
            em.close();
            return computadora;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar computadora por número de máquina", e);
        }
    }

    /**
     * Busca una computadora por su dirección IP en la base de datos.
     * 
     * @param ip La dirección IP de la computadora a buscar.
     * @return La computadora encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la computadora.
     */
    @Override
    public Computadora buscarComputadoras(String ip) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.direccionIP = :direccionIP
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("direccionIP", ip);
            Computadora computadora = query.getSingleResult();
            em.close();
            return computadora;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar computadora por dirección IP", e);
        }
    }

    /**
     * Busca computadoras por su dirección IP en la base de datos.
     * 
     * @param direccionIP La dirección IP de las computadoras a buscar.
     * @return Lista de computadoras con la dirección IP especificada.
     * @throws PersistenciaException Si ocurre un error al buscar las computadoras.
     */
    @Override
    public List<Computadora> buscarComputadorasPorIP(String direccionIP) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.direccionIP = :direccionIP
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("direccionIP", direccionIP);
            List<Computadora> computadoras = query.getResultList();
            em.close();
            return computadoras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar computadoras por dirección IP", e);
        }
    }

    /**
     * Busca computadoras de uso exclusivo para alumnos en la base de datos.
     * 
     * @return Lista de computadoras para uso de alumnos.
     * @throws PersistenciaException Si ocurre un error al buscar las computadoras.
     */
    @Override
    public List<Computadora> buscarComputadorasUsoAlumno() throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.usoAlumno = :usoAlumno
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("usoAlumno", true);
            List<Computadora> computadoras = query.getResultList();
            em.close();
            return computadoras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar computadoras de uso para alumnos", e);
        }
    }

    /**
     * Busca computadoras por su estatus en la base de datos.
     * 
     * @param estatus El estatus de las computadoras a buscar.
     * @return Lista de computadoras con el estatus especificado.
     * @throws PersistenciaException Si ocurre un error al buscar las computadoras.
     */
    @Override
    public List<Computadora> buscarComputadorasPorEstatus(String estatus) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.estatus = :estatus
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("estatus", estatus);
            List<Computadora> computadoras = query.getResultList();
            em.close();
            return computadoras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new PersistenciaException("Error al buscar computadoras por estatus", e);
        }
    }

    /**
     * Marca una computadora como eliminada en la base de datos.
     * 
     * @param computadora La computadora a eliminar.
     * @return La computadora eliminada.
     */
    @Override
    public Computadora eliminarComputadora(Computadora computadora) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(computadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        return computadora;
    }
}
