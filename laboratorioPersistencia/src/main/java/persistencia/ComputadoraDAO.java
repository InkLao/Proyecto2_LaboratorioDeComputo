/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Computadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Implementación de la interfaz `IComputadoraDAO` que gestiona las operaciones CRUD de la entidad `Computadora`
 * en la base de datos. Proporciona métodos para agregar, editar, eliminar y buscar computadoras por diferentes criterios.
 * 
 * @author Oley
 */
public class ComputadoraDAO implements IComputadoraDAO{

    
    /**
     * Fábrica de `EntityManager` para la gestión de transacciones en la base de datos.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor que inicializa `ComputadoraDAO` con objetos `EntityManager` y `EntityManagerFactory`.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     * @param emf Fábrica de `EntityManager` para la gestión de transacciones
     */
    public ComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        // No se utiliza entityManager en este momento, pero podría ser necesario para futuras modificaciones.
    }
    
    /**
     * Obtiene todas las computadoras almacenadas en la base de datos.
     *
     * @return Lista de todas las computadoras
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    @Override
    public List<Computadora> obtenerTodos() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        List<Computadora> bloqueos = em.createQuery("SELECT c FROM Computadora c", Computadora.class).getResultList();
        em.close();
        return bloqueos;
    }
    
    /**
     * Agrega una nueva computadora a la base de datos.
     *
     * @param computadora Computadora a agregar
     * @return Computadora agregada
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
     * Edita una computadora en la base de datos.
     *
     * @param computadora Computadora a editar
     * @return Computadora editada
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
     * Busca una computadora por su identificador en la base de datos.
     *
     * @param id Identificador de la computadora
     * @return Computadora encontrada o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
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
            System.out.println("error en buscarComputadora id persistencia");
        }
        return null;
    }

    /**
     * Busca una computadora por su número de máquina.
     *
     * @param numMaquina Número de máquina de la computadora
     * @return Computadora encontrada o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
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
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Busca computadoras por su dirección IP.
     *
     * @param ip Dirección IP de la computadora
     * @return Lista de computadoras que coinciden con la IP
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    @Override
    public List<Computadora> buscarComputadoras(String ip) throws PersistenciaException {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.direccionIP = :direccionIP
                                  """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("direccionIP", ip);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Busca computadoras que están destinadas al uso de alumnos.
     *
     * @return Lista de computadoras para uso de alumnos
     * @throws PersistenciaException si ocurre un error durante la operación
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
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Busca computadoras por su estatus.
     *
     * @param estatus Estatus de la computadora (e.g., en uso, disponible)
     * @return Lista de computadoras que coinciden con el estatus
     * @throws PersistenciaException si ocurre un error durante la operación
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
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Marca una computadora como eliminada en la base de datos.
     *
     * @param computadora Computadora a eliminar
     * @return Computadora eliminada
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