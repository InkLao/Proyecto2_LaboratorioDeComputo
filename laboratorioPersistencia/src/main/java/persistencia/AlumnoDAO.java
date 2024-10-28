/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Alumno;
import entidades.Bloqueo;
import entidades.Carrera;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Implementación de la interfaz `IAlumnoDAO` que gestiona las operaciones CRUD de la entidad `Alumno` 
 * en la base de datos.
 * 
 * @author Oley
 */
public class AlumnoDAO implements  IAlumnoDAO{
    
    
    /**
     * Fábrica de `EntityManager` para gestionar las transacciones.
     */
    private EntityManagerFactory emf;
    
    /**
     * `EntityManager` utilizado para manejar las entidades dentro de las transacciones.
     */
    private EntityManager entityManager;

    /**
     * Constructor que inicializa `AlumnoDAO` con los objetos `EntityManagerFactory` y `EntityManager`.
     *
     * @param emf Fábrica de `EntityManager` para la gestión de transacciones
     * @param entityManager Manejador de entidades para la sesión actual
     */
    public AlumnoDAO(EntityManagerFactory emf, EntityManager entityManager) {
        this.emf = emf;
        this.entityManager = entityManager;
    }

    /**
     * Agrega un nuevo alumno a la base de datos. Primero verifica la existencia de la carrera 
     * del alumno antes de persistirlo.
     *
     * @param alumno Alumno a agregar
     * @return Alumno agregado
     * @throws RuntimeException si la carrera del alumno no existe
     */
    @Override
    public Alumno agregarAlumno(Alumno alumno) {
        EntityManager em = emf.createEntityManager();
        CarreraDAO carreraDAO = new CarreraDAO(entityManager, emf);
        em.getTransaction().begin();

        Carrera carrera = carreraDAO.obtenerCarreraPorNombre(alumno.getCarrera().getNombre());

        if (carrera == null) {
            throw new RuntimeException("Carrera not found");
        }

        alumno.setCarrera(carrera);
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();

        return alumno;
    }

    /**
     * Edita la información de un alumno en la base de datos.
     *
     * @param alumno Alumno a editar
     * @return Alumno editado
     */
    @Override
    public Alumno editarAlumno(Alumno alumno) {
        EntityManager entityManager = emf.createEntityManager();

        System.out.println("alumno a editar " + alumno.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(alumno);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return alumno;
    }

    /**
     * Busca un alumno en la base de datos mediante su identificador.
     *
     * @param id Identificador del alumno
     * @return Alumno encontrado o null si no existe
     */
    @Override
    public Alumno buscarAlumno(Long id) {
        try {
            EntityManager entityManager = emf.createEntityManager();
            Alumno alumno = entityManager.find(Alumno.class, id);
            entityManager.close();
            return alumno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error en buscar alumno id persistencia");
        }
        
        return null;
    }

    /**
     * Elimina un alumno de la base de datos (marcado como eliminado).
     *
     * @param alumno Alumno a eliminar
     * @return Alumno eliminado
     */
    @Override
    public Alumno eliminarAlumno(Alumno alumno) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(alumno);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return alumno;
    }

    /**
     * Obtiene todos los alumnos almacenados en la base de datos.
     *
     * @return Lista de todos los alumnos
     */
    @Override
    public List<Alumno> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<Alumno> alumnos = em.createQuery("SELECT b FROM Alumno b", Alumno.class).getResultList();
        em.close();
        return alumnos;
    }

    /**
     * Busca alumnos por nombre en la base de datos.
     *
     * @param nombre Nombre del alumno
     * @return Lista de alumnos que coinciden con el nombre
     */
    @Override
    public List<Alumno> buscarAlumno(String nombre) {
        try {
            EntityManager em = emf.createEntityManager();
            String consultaJPQL = """
                                  SELECT b FROM Alumno b
                                  WHERE b.nombres = :nombres
                                  """;
            TypedQuery<Alumno> query = em.createQuery(consultaJPQL, Alumno.class);
            query.setParameter("nombres", nombre);
            List<Alumno> alumnos = query.getResultList();
            return alumnos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
}