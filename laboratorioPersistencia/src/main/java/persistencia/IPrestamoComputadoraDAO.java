/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.PrestamoComputadora;

/**
 * Interfaz que define las operaciones para la entidad `PrestamoComputadora`.
 * Proporciona un método para agregar un nuevo préstamo de computadora a la base de datos.
 * 
 * @author Arturo ITSON
 */
public interface IPrestamoComputadoraDAO {
    
    /**
     * Agrega un nuevo préstamo de computadora a la base de datos.
     *
     * @param prestamoComputadora Préstamo de computadora a agregar
     * @return Préstamo de computadora agregado
     */
    public PrestamoComputadora agregarPrestamoComputadora(PrestamoComputadora prestamoComputadora);
}