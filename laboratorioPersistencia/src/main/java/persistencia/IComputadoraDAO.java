package persistencia;

import Excepciones.PersistenciaException;
import entidades.Computadora;
import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Computadora en la capa de persistencia.
 * Define los métodos necesarios para gestionar los datos de las computadoras en la base de datos.
 * 
 * @autor Arturo ITSON
 */
public interface IComputadoraDAO {

    /**
     * Obtiene una lista de todas las computadoras en la base de datos.
     * 
     * @return Lista de todas las computadoras.
     * @throws PersistenciaException Si ocurre un error al obtener las computadoras.
     */
    public List<Computadora> obtenerTodos() throws PersistenciaException;

    /**
     * Agrega una nueva computadora a la base de datos.
     * 
     * @param computadora La computadora a agregar.
     * @return La computadora agregada con los datos persistidos.
     */
    public Computadora agregarComputadora(Computadora computadora);

    /**
     * Edita una computadora existente en la base de datos.
     * 
     * @param computadora La computadora con los datos actualizados.
     * @return La computadora editada.
     */
    public Computadora editarComputadora(Computadora computadora);

    /**
     * Busca una computadora por su ID en la base de datos.
     * 
     * @param id El ID de la computadora a buscar.
     * @return La computadora encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la computadora.
     */
    public Computadora buscarComputadora(Long id) throws PersistenciaException;

    /**
     * Busca una computadora por su número de máquina en la base de datos.
     * 
     * @param numMaquina El número de máquina de la computadora a buscar.
     * @return La computadora encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la computadora.
     */
    public Computadora buscarComputadorasPorNumMaquina(Integer numMaquina) throws PersistenciaException;

    /**
     * Busca computadoras de uso exclusivo para alumnos en la base de datos.
     * 
     * @return Lista de computadoras para uso de alumnos.
     * @throws PersistenciaException Si ocurre un error al buscar las computadoras.
     */
    public List<Computadora> buscarComputadorasUsoAlumno() throws PersistenciaException;

    /**
     * Busca una computadora por su dirección IP en la base de datos.
     * 
     * @param ip La dirección IP de la computadora a buscar.
     * @return La computadora encontrada o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error al buscar la computadora.
     */
    public Computadora buscarComputadoras(String ip) throws PersistenciaException;

    /**
     * Busca computadoras por su dirección IP en la base de datos.
     * 
     * @param direccionIP La dirección IP de las computadoras a buscar.
     * @return Lista de computadoras con la dirección IP especificada.
     * @throws PersistenciaException Si ocurre un error al buscar las computadoras.
     */
    public List<Computadora> buscarComputadorasPorIP(String direccionIP) throws PersistenciaException;

    /**
     * Marca una computadora como eliminada en la base de datos.
     * 
     * @param computadora La computadora a eliminar.
     * @return La computadora eliminada.
     */
    public Computadora eliminarComputadora(Computadora computadora);

    /**
     * Busca computadoras por su estatus en la base de datos.
     * 
     * @param estatus El estatus de las computadoras a buscar.
     * @return Lista de computadoras con el estatus especificado.
     * @throws PersistenciaException Si ocurre un error al buscar las computadoras.
     */
    public List<Computadora> buscarComputadorasPorEstatus(String estatus) throws PersistenciaException;
}
