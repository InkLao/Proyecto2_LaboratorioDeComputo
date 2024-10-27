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
 *
 * @author Oley
 */
public class AlumnoDAO implements  IAlumnoDAO{
    
    
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public AlumnoDAO(EntityManagerFactory emf, EntityManager entityManager) {
        this.emf = emf;
        this.entityManager = entityManager;
    }

    
    @Override
    public Alumno agregarAlumno(Alumno alumno) {
      EntityManager em = emf.createEntityManager();
   CarreraDAO carreraDAO=  new CarreraDAO(entityManager ,emf);
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

    @Override
    public Alumno buscarAlumno(Long id) {
 try{
        EntityManager entityManager = emf.createEntityManager();
  
        Alumno alumno = entityManager.find(Alumno.class, id);
        
        entityManager.close();
        
        return alumno;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("error en buscar alumno id persistencia");
        }
        
        return null;
    }

    @Override
    public Alumno eliminarAlumno(Alumno alumno) {

        EntityManager entityManager = emf.createEntityManager();

        
        entityManager.getTransaction().begin();
        entityManager.merge(alumno);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        
        return alumno;
        


    }

    @Override
    public List<Alumno> obtenerTodos() {
EntityManager em = emf.createEntityManager();
List<Alumno> alumnos = em.createQuery("SELECT b FROM Alumno b", Alumno.class).getResultList();
        em.close();
        return alumnos;

    }

    @Override
    public List<Alumno> buscarAlumno(String nombre) {
 
        try{
        EntityManager em = emf.createEntityManager();

       String consultaJPQL = """
                        SELECT b FROM Alumno b
                        WHERE b.nombres = :nombres
                        """;

            TypedQuery<Alumno> query = em.createQuery(consultaJPQL, Alumno.class);
            query.setParameter("nombres", nombre);
            
            List<Alumno> alumnos = query.getResultList();
            
            return alumnos;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }


    
    
    
    

}
