/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.Computadora;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad `Computadora`.
 * Proporciona métodos para agregar, editar, eliminar y buscar computadoras,
 * además de obtener todas las computadoras almacenadas y realizar búsquedas
 * específicas por número de máquina, dirección IP, estatus y uso por alumnos.
 *
 * @author Arturo ITSON
 */
public interface IComputadoraDAO {

    /**
     * Obtiene todas las computadoras almacenadas en la base de datos.
     *
     * @return Lista de todas las computadoras
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Computadora> obtenerTodos() throws PersistenciaException;

    /**
     * Agrega una nueva computadora a la base de datos.
     *
     * @param computadora Computadora a agregar
     * @return Computadora agregada
     */
    public Computadora agregarComputadora(Computadora computadora);

    /**
     * Edita la información de una computadora existente en la base de datos.
     *
     * @param computadora Computadora a editar
     * @return Computadora editada
     */
    public Computadora editarComputadora(Computadora computadora);

    /**
     * Busca una computadora por su identificador.
     *
     * @param id Identificador de la computadora
     * @return Computadora encontrada o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public Computadora buscarComputadora(Long id) throws PersistenciaException;

    /**
     * Busca una computadora por su número de máquina.
     *
     * @param numMaquina Número de máquina de la computadora
     * @return Computadora encontrada o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public Computadora buscarComputadorasPorNumMaquina(Integer numMaquina) throws PersistenciaException;

    /**
     * Busca computadoras que están destinadas al uso de alumnos.
     *
     * @return Lista de computadoras para uso de alumnos
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Computadora> buscarComputadorasUsoAlumno() throws PersistenciaException;

    /**
     * Busca computadoras por su dirección IP.
     *
     * @param ip Dirección IP de la computadora
     * @return Lista de computadoras que coinciden con la IP
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Computadora> buscarComputadoras(String ip) throws PersistenciaException;

    /**
     * Marca una computadora como eliminada en la base de datos.
     *
     * @param computadora Computadora a eliminar
     * @return Computadora eliminada
     */
    public Computadora eliminarComputadora(Computadora computadora);

    /**
     * Busca computadoras por su estatus.
     *
     * @param estatus Estatus de la computadora (e.g., en uso, disponible)
     * @return Lista de computadoras que coinciden con el estatus
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<Computadora> buscarComputadorasPorEstatus(String estatus) throws PersistenciaException;
}
