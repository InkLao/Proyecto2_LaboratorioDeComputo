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
 *
 * @author Oley
 */
public class ComputadoraDAO implements IComputadoraDAO{

    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");


    
    public ComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        //this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Computadora> obtenerTodos() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        List<Computadora> bloqueos = em.createQuery("SELECT c FROM Computadora c", Computadora.class).getResultList();
        em.close();
        return bloqueos;
    }
    
    @Override
    public Computadora agregarComputadora(Computadora computadora) {
        
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computadora);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return computadora;
    }  
    

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

    @Override
    public Computadora buscarComputadora(Long id) throws PersistenciaException{
        
        try{
        EntityManager entityManager = emf.createEntityManager();
  
        Computadora computadora = entityManager.find(Computadora.class, id);
        
        entityManager.close();
        
        return computadora;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("error en buscarComputadora id persistencia");
        }
        
        return null;
    }

    @Override
    public Computadora buscarComputadorasPorNumMaquina(Integer numMaquina) throws PersistenciaException{
       
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.numeroMaquina = :numeroMaquina
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("numeroMaquina", numMaquina);
            
            Computadora computadora = query.getSingleResult();
            
            return computadora;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }
    
    @Override
    public List<Computadora> buscarComputadoras(String ip) throws PersistenciaException{
       
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.direccionIP = :direccionIP
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("direccionIP", ip);
            
            List<Computadora> computadora = query.getResultList();
            
            return computadora;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }
    
    
    @Override
    public List<Computadora> buscarComputadorasPorEstatus(String estatus) throws PersistenciaException{
       
        try{
        EntityManager em = emf.createEntityManager();

        String consultaJPQL = """
                                    SELECT c from Computadora c
                                    WHERE c.estatus = :estatus
                                
                                """;
            TypedQuery<Computadora> query = em.createQuery(consultaJPQL, Computadora.class);
            query.setParameter("estatus", estatus);
            
            List<Computadora> computadora = query.getResultList();
            
            return computadora;
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
          
        return null;
    }    
    
    
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
