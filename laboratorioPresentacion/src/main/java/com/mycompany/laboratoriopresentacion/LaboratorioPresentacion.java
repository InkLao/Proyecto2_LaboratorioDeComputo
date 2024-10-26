/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratoriopresentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.AlumnoNegocio;
import negocio.BloqueoNegocio;
import negocio.CarreraNegocio;
import negocio.CentroComputoNegocio;
import negocio.IAlumnoNegocio;
import negocio.IBloqueoNegocio;
import negocio.ICarreraNegocio;
import negocio.ICentroComputoNegocio;
import negocio.IUnidadNegocio;
import negocio.UnidadNegocio;
import pantallas.InicioSesion;
import persistencia.AlumnoDAO;
import persistencia.BloqueoDAO;
import persistencia.CarreraDAO;
import persistencia.CentroComputoDAO;
import persistencia.IAlumnoDAO;
import persistencia.IBloqueoDAO;
import persistencia.ICarreraDAO;
import persistencia.ICentroComputoDAO;
import persistencia.IUnidadAcademicaDAO;
import persistencia.UnidadAcademicaDAO;

/**
 *
 * @author eduar
 */
public class LaboratorioPresentacion {
    
    public static void main(String[] args) {
        
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        IUnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO(entityManager);
        ICarreraDAO carreraDAO = new CarreraDAO(entityManager);
        IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManagerFactory);
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(entityManager, entityManagerFactory);
        ICentroComputoDAO centroComputoDAO = new CentroComputoDAO(entityManager);
        
        IUnidadNegocio unidadNegocio = new UnidadNegocio(unidadAcademicaDAO);
        ICarreraNegocio carreraNegocio = new CarreraNegocio(carreraDAO);
        IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
        IBloqueoNegocio bloqueoNegocio = new BloqueoNegocio(bloqueoDAO, alumnoNegocio);
        ICentroComputoNegocio centroComputoNegocio = new CentroComputoNegocio(centroComputoDAO);
        
        InicioSesion inicio = new InicioSesion(carreraNegocio, unidadNegocio, alumnoNegocio, bloqueoNegocio, centroComputoNegocio);
        inicio.setVisible(true);
    }
}
