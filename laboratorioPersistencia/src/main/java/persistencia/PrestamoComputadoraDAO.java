/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Alumno;
import entidades.Computadora;
import entidades.PrestamoComputadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Arturo ITSON
 */
public class PrestamoComputadoraDAO implements IPrestamoComputadoraDAO{
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");


    
    public PrestamoComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        //this.entityManager = entityManager;
    }
    
    
    @Override
    public PrestamoComputadora buscarPrestamoComputadora(Long id) throws PersistenciaException {
        EntityManager entityManager = emf.createEntityManager();
        PrestamoComputadora prestamoComputadora = null;
        try {
            prestamoComputadora = entityManager.find(PrestamoComputadora.class, id);
            entityManager.refresh(prestamoComputadora);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return prestamoComputadora;
    }
    
    
    @Override
    public PrestamoComputadora agregarPrestamoComputadora(PrestamoComputadora prestamoComputadora) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(prestamoComputadora);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return prestamoComputadora;
    }
    
    
    @Override
    public PrestamoComputadora editarPrestamoComputadora(PrestamoComputadora prestamoComputadora) {

        EntityManager entityManager = emf.createEntityManager();

        
        System.out.println("prestamoEditar " + prestamoComputadora.toString());
        entityManager.getTransaction().begin();
        entityManager.merge(prestamoComputadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return prestamoComputadora;
        
    }
    
    
    @Override
    public List<PrestamoComputadora> buscarUltimoPrestamoAlumno(Alumno alumno) throws PersistenciaException{
       
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT p from PrestamoComputadora p
                                    WHERE p.alumno = :alumno
                                
                                """;
            TypedQuery<PrestamoComputadora> query = em.createQuery(consultaJPQL, PrestamoComputadora.class);
            query.setParameter("alumno", alumno);
            
            List<PrestamoComputadora> prestamo = query.getResultList();
            
            return prestamo;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }
    
    
    @Override
    public List<PrestamoComputadora> buscarUltimoPrestamoPorComputadora(Computadora Computadora) throws PersistenciaException{
       
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT p from PrestamoComputadora p
                                    WHERE p.computadora = :computadora
                                
                                """;
            TypedQuery<PrestamoComputadora> query = em.createQuery(consultaJPQL, PrestamoComputadora.class);
            query.setParameter("computadora", Computadora);
            
            List<PrestamoComputadora> prestamo = query.getResultList();
            
            return prestamo;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }
    
}
