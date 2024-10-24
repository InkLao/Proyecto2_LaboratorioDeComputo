/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratoriopresentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.CarreraNegocio;
import negocio.ICarreraNegocio;
import pantallas.InicioSesion;
import persistencia.CarreraDAO;
import persistencia.ICarreraDAO;

/**
 *
 * @author eduar
 */
public class LaboratorioPresentacion {
    
    public static void main(String[] args) {
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laboratorioComputo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ICarreraDAO carreraDAO=new CarreraDAO(entityManager);
        ICarreraNegocio carreraNegocio=new CarreraNegocio(carreraDAO);
        InicioSesion inicio = new InicioSesion(carreraNegocio);
        inicio.setVisible(true);
    }
}
