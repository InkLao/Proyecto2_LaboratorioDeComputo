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
 *
 * @author Arturo ITSON
 */
public class PrestamoComputadoraDAO implements IPrestamoComputadoraDAO{
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");


    
    public PrestamoComputadoraDAO(EntityManager entityManager, EntityManagerFactory emf) {
        //this.entityManager = entityManager;
    }
    
    
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
