/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Carrera;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad `Carrera`.
 * Proporciona métodos para agregar una carrera, obtener una carrera por nombre
 * y obtener todas las carreras almacenadas en la base de datos.
 *
 * @author Oley
 */
public interface ICarreraDAO {

    /**
     * Agrega una nueva carrera a la base de datos.
     *
     * @param carrera Carrera a agregar
     */
    void agregarCarrera(Carrera carrera);

    /**
     * Busca una carrera en la base de datos por su nombre.
     *
     * @param nombre Nombre de la carrera
     * @return Carrera encontrada o null si no existe
     */
    Carrera obtenerCarreraPorNombre(String nombre);

    /**
     * Obtiene todas las carreras almacenadas en la base de datos.
     *
     * @return Lista de todas las carreras
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Carrera> obtenerTodos() throws PersistenciaException;
}
