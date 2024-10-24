/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratoriopresentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.CarreraNegocio;
import negocio.ICarreraNegocio;
import negocio.IUnidadNegocio;
import negocio.UnidadNegocio;
import pantallas.InicioSesion;
import persistencia.CarreraDAO;
import persistencia.ICarreraDAO;
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
        
        
        IUnidadAcademicaDAO unidadAcademicaDAO=new UnidadAcademicaDAO(entityManager);
        ICarreraDAO carreraDAO=new CarreraDAO(entityManager);
        
        
        IUnidadNegocio unidadNegocio=new UnidadNegocio(unidadAcademicaDAO);
        ICarreraNegocio carreraNegocio=new CarreraNegocio(carreraDAO);
        
        
        
        InicioSesion inicio = new InicioSesion(carreraNegocio,unidadNegocio);
        inicio.setVisible(true);
    }
}
