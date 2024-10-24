/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import entidades.Alumno;
import entidades.Bloqueo;
import entidades.Carrera;
import entidades.CentroLaboratorio;
import entidades.Computadora;
import entidades.UnidadAcademica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Arturo ITSON
 */
public class PruebaDAO {
    
       public void guardarAlumnoConCarrera() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        System.out.println("hola");
        Carrera carrera = new Carrera("ISW", 2);
        
        Alumno alu = new Alumno("ss", "ape", "ape2", "1234", carrera);
        entityManager.persist(alu);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
       
       
    public void guardarBloqueoConAlumno() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        System.out.println("hola");

        Carrera carrera = new Carrera("ISW", 2);
        
        Alumno alu = new Alumno("ss", "ape", "ape2", "1234", carrera);
        
        Bloqueo blo = new Bloqueo("porq si", Calendar.getInstance(), Calendar.getInstance(), alu);
        
        entityManager.persist(blo);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
    
    
    public void guardarUnidadAcademica() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        System.out.println("hola");

        UnidadAcademica unidad = new UnidadAcademica("Nainari");
        
        entityManager.persist(unidad);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
    
    
    public void guardarCentroComputo() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        System.out.println("holacomputo");

        UnidadAcademica unidad = new UnidadAcademica("Nainari");
        
        CentroLaboratorio centro = new CentroLaboratorio("Cisco", Calendar.getInstance(), Calendar.getInstance(), "1234", unidad);
        
        entityManager.persist(centro);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
    
        public void guardarComputadora() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        System.out.println("hola");

        UnidadAcademica unidad = new UnidadAcademica("Nainari");
        
        CentroLaboratorio centro = new CentroLaboratorio("Cisco", Calendar.getInstance(), Calendar.getInstance(), "1234", unidad);
        
        
        Computadora compu = new Computadora("Disponible", "12.12", 2, true, centro);
        entityManager.persist(compu);
        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
        
        
}
