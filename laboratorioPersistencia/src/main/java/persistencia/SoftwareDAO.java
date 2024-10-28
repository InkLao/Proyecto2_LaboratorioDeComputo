/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Computadora;
import entidades.Software;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Clase de acceso a datos (DAO) para gestionar la persistencia de la entidad `Software` en la base de datos.
 * Proporciona métodos para agregar un nuevo software a la base de datos.
 * 
 * @author Oley
 */
public class SoftwareDAO {
    /**
     * `EntityManager` utilizado para manejar las entidades dentro de las transacciones.
     */
    private EntityManager entityManager;

    /**
     * Constructor que inicializa `SoftwareDAO` con un objeto `EntityManager`.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     */
    public SoftwareDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Agrega un nuevo software a la base de datos.
     *
     * @param software Software a agregar
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