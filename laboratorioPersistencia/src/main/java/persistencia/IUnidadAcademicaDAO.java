/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.UnidadAcademica;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad `UnidadAcademica`.
 * Proporciona métodos para agregar una nueva unidad académica y obtener todas las unidades académicas almacenadas.
 * 
 * @author Oley
 */
public interface IUnidadAcademicaDAO {
    
    /**
     * Agrega una nueva unidad académica a la base de datos.
     *
     * @param unidadAcademica Unidad académica a agregar
     */
    void agregarUnidadAcademica(UnidadAcademica unidadAcademica);

    /**
     * Obtiene todas las unidades académicas almacenadas en la base de datos.
     *
     * @return Lista de todas las unidades académicas
     */
    List<UnidadAcademica> obtenerTodas();
}