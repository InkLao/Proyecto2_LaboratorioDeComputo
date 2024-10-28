package negocio;

import NegocioException.NegocioException;
import dto.CarreraDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para gestionar carreras.
 * Proporciona métodos para agregar, buscar por nombre y obtener todas las carreras.
 * 
 * @author Oley
 */
public interface ICarreraNegocio {

    /**
     * Agrega una nueva carrera en el sistema.
     * 
     * @param carreraDTO Objeto CarreraDTO que contiene la información de la carrera a agregar.
     */
    void agregarCarrera(CarreraDTO carreraDTO);

    /**
     * Obtiene una carrera por su nombre.
     * 
     * @param nombre Nombre de la carrera a buscar.
     * @return CarreraDTO con la información de la carrera encontrada o null si no existe.
     */
    CarreraDTO obtenerCarreraPorNombre(String nombre);

    /**
     * Obtiene todas las carreras disponibles en el sistema.
     * 
     * @return Lista de objetos CarreraDTO con la información de todas las carreras.
     * @throws NegocioException en caso de error durante la operación.
     */
    public List<CarreraDTO> obtenerTodos() throws NegocioException;

     public Integer obtenerTiempoMaxUsoDiarioTotal();
}
