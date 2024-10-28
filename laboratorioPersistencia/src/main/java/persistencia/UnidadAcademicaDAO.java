/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Carrera;
import entidades.UnidadAcademica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Clase de acceso a datos (DAO) para gestionar la persistencia de la entidad `UnidadAcademica` en la base de datos.
 * Implementa la interfaz `IUnidadAcademicaDAO` y proporciona métodos para agregar una unidad académica
 * y obtener todas las unidades académicas almacenadas.
 * 
 * @author Oley
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{
    /**
     * `EntityManager` utilizado para manejar las entidades dentro de las transacciones.
     */
    private EntityManager entityManager;

    /**
     * Constructor que inicializa `UnidadAcademicaDAO` con un objeto `EntityManager`.
     *
     * @param entityManager Manejador de entidades para la sesión actual
     */
    public UnidadAcademicaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Agrega una nueva unidad académica a la base de datos.
     *
     * @param unidadAcademica Unidad académica a agregar
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
     * Obtiene todas las unidades académicas almacenadas en la base de datos.
     *
     * @return Lista de todas las unidades académicas
     */
    @Override
    public List<UnidadAcademica> obtenerTodas() {
        return entityManager.createQuery("SELECT u FROM UnidadAcademica u", UnidadAcademica.class).getResultList();
    }
}