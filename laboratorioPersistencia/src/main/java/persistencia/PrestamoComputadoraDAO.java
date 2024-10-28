/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.PrestamoComputadora;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Implementación de la interfaz `IPrestamoComputadoraDAO` que gestiona la persistencia de la entidad `PrestamoComputadora`
 * en la base de datos.
 * 
 * @author Arturo ITSON
 */
public class PrestamoComputadoraDAO implements IPrestamoComputadoraDAO{
    
    /**
     * Fábrica de `EntityManager` para la gestión de transacciones en la base de datos.
     */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");

    /**
     * Constructor que inicializa `PrestamoComputadoraDAO` con objetos `EntityManager` y `EntityManagerFactory`.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     * @param emf Fábrica de `EntityManager` para la gestión de transacciones
     */
    public PrestamoComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        // No se utiliza entityManager en este momento, pero podría ser necesario para futuras modificaciones.
    }
    
    /**
     * Agrega un nuevo préstamo de computadora a la base de datos.
     *
     * @param prestamoComputadora Préstamo de computadora a agregar
     * @return Préstamo de computadora agregado
     */
    @Override
    public PrestamoComputadora agregarPrestamoComputadora(PrestamoComputadora prestamoComputadora) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(prestamoComputadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        return prestamoComputadora;
    }
}