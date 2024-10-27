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
import negocio.ComputadoraNegocio;
import negocio.IAlumnoNegocio;
import negocio.IBloqueoNegocio;
import negocio.ICarreraNegocio;
import negocio.ICentroComputoNegocio;
import negocio.IComputadoraNegocio;
import negocio.IPrestamoComputadoraNegocio;
import negocio.IUnidadNegocio;
import negocio.PrestamoComputadoraNegocio;
import negocio.UnidadNegocio;
import pantallas.Inicio;
import pantallas.InicioSesion;
import persistencia.AlumnoDAO;
import persistencia.BloqueoDAO;
import persistencia.CarreraDAO;
import persistencia.CentroComputoDAO;
import persistencia.ComputadoraDAO;
import persistencia.IAlumnoDAO;
import persistencia.IBloqueoDAO;
import persistencia.ICarreraDAO;
import persistencia.ICentroComputoDAO;
import persistencia.IComputadoraDAO;
import persistencia.IPrestamoComputadoraDAO;
import persistencia.IUnidadAcademicaDAO;
import persistencia.PrestamoComputadoraDAO;
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
        ICarreraDAO carreraDAO = new CarreraDAO(entityManager, entityManagerFactory);
        IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManagerFactory, entityManager);
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(entityManager, entityManagerFactory);
        ICentroComputoDAO centroComputoDAO = new CentroComputoDAO(entityManager);
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(entityManager, entityManagerFactory);
        IPrestamoComputadoraDAO prestamoComputadoraDAO = new PrestamoComputadoraDAO(entityManager, entityManagerFactory);
        
        IUnidadNegocio unidadNegocio = new UnidadNegocio(unidadAcademicaDAO);
        ICarreraNegocio carreraNegocio = new CarreraNegocio(carreraDAO);
        IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
        IBloqueoNegocio bloqueoNegocio = new BloqueoNegocio(bloqueoDAO, alumnoNegocio);
        ICentroComputoNegocio centroComputoNegocio = new CentroComputoNegocio(centroComputoDAO);
        IComputadoraNegocio computadoraNegocio = new ComputadoraNegocio(computadoraDAO, centroComputoNegocio);
        IPrestamoComputadoraNegocio prestamoComputadoraNegocio = new PrestamoComputadoraNegocio(prestamoComputadoraDAO, alumnoNegocio, computadoraNegocio, centroComputoNegocio);
        
        Inicio inicio = new Inicio(carreraNegocio, unidadNegocio, alumnoNegocio, bloqueoNegocio, centroComputoNegocio, computadoraNegocio, prestamoComputadoraNegocio);
        inicio.setVisible(true);
    }
}
