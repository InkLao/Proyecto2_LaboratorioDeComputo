/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Carrera;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oley
 */
public class Main {
    /*
    Prueba de metodos
    */
    public static void main(String[] args) {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager em = emf.createEntityManager();
        CarreraDAO carreraDAO =new CarreraDAO(em);
        Carrera carrera=new Carrera( "ISW", 5);
        carreraDAO.agregarCarrera(carrera);
        
        
        
        
    }
}
