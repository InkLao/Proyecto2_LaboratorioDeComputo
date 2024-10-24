/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Bloqueo;
import entidades.Carrera;
import entidades.CentroLaboratorio;
import entidades.Computadora;
import entidades.Software;
import entidades.UnidadAcademica;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
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
                CarreraDAO carreraDAO=new CarreraDAO(em);
Carrera carrera=new Carrera("isw", 6);
carreraDAO.agregarCarrera(carrera);
//        CarreraDAO carreraDAO =new CarreraDAO(em);
//        Carrera carrera=new Carrera( "ISW", 5);
//        carreraDAO.agregarCarrera(carrera);
//        
//        UnidadAcademicaDAO unidadAcademicaDAO=new UnidadAcademicaDAO(em);
//        UnidadAcademica unidadAcademica=new UnidadAcademica("Obregon");
//        unidadAcademicaDAO.agregarUnidadAcademica(unidadAcademica);
//        
//        CentroLaboratorioDAO centroLaboratorioDAO=new CentroLaboratorioDAO(em);
//CentroLaboratorio centroLaboratorio = new CentroLaboratorio("Cisco", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31), "admin");
// centroLaboratorioDAO.agregarLaboratorio(centroLaboratorio);
// 
// 
// ComputadoraDAO computadoraDAO=new ComputadoraDAO(em);
//         List<String> software = Arrays.asList("Windows", "Office", "Antivirus");
//SoftwareDAO softwareDAO=new SoftwareDAO(em);
//Software software1=new Software("Windows");
//
// Computadora computadora=new Computadora( "ocupado", "122.22", 1, software);
//        computadoraDAO.agregarComputadora(computadora);
//        softwareDAO.agregarSoftware(software1);
//    
//    BloqueoDAO bloqueoDAO=new BloqueoDAO(em);
//    Bloqueo bloqueo=new Bloqueo("Se acabo el tiempo", LocalDate.of(2023, 6, 10));
//    bloqueoDAO.agregarBloqueo(bloqueo);
    }
}
