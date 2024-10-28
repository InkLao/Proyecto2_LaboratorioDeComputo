/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * Implementación de la interfaz `ICarreraDAO` para gestionar las operaciones CRUD de la entidad `Carrera` 
 * en la base de datos.
 * 
 * @author Oley
 */
public class CarreraDAO implements ICarreraDAO{
       
    /**
     * `EntityManager` utilizado para manejar las entidades dentro de las transacciones.
     */
    private EntityManager entityManager;
    
    /**
     * Fábrica de `EntityManager` para la gestión de transacciones en la base de datos.
     */
    private EntityManagerFactory entityManagerFactory;   

    /**
     * Constructor que inicializa `CarreraDAO` con los objetos `EntityManager` y `EntityManagerFactory`.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     * @param entityManagerFactory Fábrica de `EntityManager` para la gestión de transacciones
     */
    public CarreraDAO(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }
    
    /**
     * Agrega una nueva carrera a la base de datos.
     *
     * @param carrera Carrera a agregar
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
     * Busca una carrera en la base de datos por su nombre.
     *
     * @param nombre Nombre de la carrera
     * @return Carrera encontrada o null si no existe
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
     * Obtiene todas las carreras almacenadas en la base de datos.
     *
     * @return Lista de todas las carreras
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    @Override
    public List<Carrera> obtenerTodos() throws PersistenciaException {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
        em.close();
        return carreras;
    }
}