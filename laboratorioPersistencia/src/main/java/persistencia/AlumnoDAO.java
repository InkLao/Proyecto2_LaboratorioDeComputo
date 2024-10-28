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
 * Clase de acceso a datos (DAO) para la entidad Alumno. Proporciona métodos 
 * para realizar operaciones CRUD sobre los datos de alumnos en la base de datos.
 * 
 * Implementa la interfaz {@link IAlumnoDAO}.
 * 
 * @autor Oley
 */
public class AlumnoDAO implements IAlumnoDAO {
    
    /**
     * Factoría de administradores de entidades de JPA.
     */
    private EntityManagerFactory emf;
    
    /**
     * Administrador de entidades utilizado para interactuar con la base de datos.
     */
    private EntityManager entityManager;

    /**
     * Constructor de la clase AlumnoDAO que recibe un EntityManagerFactory y un EntityManager.
     * 
     * @param emf El EntityManagerFactory para crear instancias de EntityManager.
     * @param entityManager El EntityManager que gestiona la persistencia de datos.
     */
    public AlumnoDAO(EntityManagerFactory emf, EntityManager entityManager) {
        this.emf = emf;
        this.entityManager = entityManager;
    }

    /**
     * Agrega un nuevo alumno a la base de datos.
     * Asocia el alumno a una carrera existente según el nombre de la carrera.
     * 
     * @param alumno El alumno a agregar.
     * @return El alumno agregado con los datos persistidos.
     * @throws RuntimeException si la carrera del alumno no se encuentra.
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
     * Edita un alumno existente en la base de datos.
     * 
     * @param alumno El alumno con los datos actualizados.
     * @return El alumno editado.
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
     * Busca un alumno por su ID en la base de datos.
     * 
     * @param id El ID del alumno a buscar.
     * @return El alumno encontrado o {@code null} si no existe.
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
     * Marca un alumno como eliminado en la base de datos.
     * 
     * @param alumno El alumno a eliminar.
     * @return El alumno eliminado.
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
     * Obtiene una lista de todos los alumnos en la base de datos.
     * 
     * @return Lista de todos los alumnos.
     */
    @Override
    public List<Alumno> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<Alumno> alumnos = em.createQuery("SELECT b FROM Alumno b", Alumno.class).getResultList();
        em.close();
        return alumnos;
    }

    /**
     * Busca alumnos por su nombre en la base de datos.
     * 
     * @param nombre El nombre del alumno a buscar.
     * @return Lista de alumnos con el nombre especificado, o {@code null} si ocurre un error.
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
            em.close();
            return alumnos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
          
        return null;
    }
}
