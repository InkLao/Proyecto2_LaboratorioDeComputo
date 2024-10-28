/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Bloqueo;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad `Bloqueo`.
 * Proporciona métodos para agregar, editar, eliminar y buscar bloqueos,
 * así como obtener todos los bloqueos y buscar bloqueos por motivo o rango de fechas.
 * 
 * @author Arturo ITSON
 */
public interface IBloqueoDAO {
    
       /**
     * Agrega un nuevo bloqueo a la base de datos.
     *
     * @param bloqueo Bloqueo a agregar
     * @return Bloqueo agregado
     */
    public Bloqueo agregarBloqueo(Bloqueo bloqueo);
        
    /**
     * Edita la información de un bloqueo existente en la base de datos.
     *
     * @param bloqueo Bloqueo a editar
     * @return Bloqueo editado
     */
    public Bloqueo editarBloqueo(Bloqueo bloqueo);

    /**
     * Busca un bloqueo por su identificador.
     *
     * @param id Identificador del bloqueo
     * @return Bloqueo encontrado o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public Bloqueo buscarBloqueo(Long id) throws PersistenciaException;

    /**
     * Marca un bloqueo como eliminado en la base de datos.
     *
     * @param bloqueo Bloqueo a eliminar
     * @return Bloqueo eliminado
     */
    public Bloqueo eliminarBloqueo(Bloqueo bloqueo);

    /**
     * Obtiene todos los bloqueos almacenados en la base de datos.
     *
     * @return Lista de todos los bloqueos
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Bloqueo> obtenerTodos() throws PersistenciaException;

    /**
     * Busca bloqueos por motivo en la base de datos.
     *
     * @param motivo Motivo del bloqueo
     * @return Lista de bloqueos que coinciden con el motivo
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Bloqueo> buscarBloqueo(String motivo) throws PersistenciaException;

    /**
     * Busca bloqueos en un rango de fechas de aplicación.
     *
     * @param fechaInicio Fecha de inicio del rango
     * @param fechaFinal Fecha final del rango
     * @return Lista de bloqueos que están en el rango de fechas
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    List<Bloqueo> buscarBloqueoPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws PersistenciaException;
}