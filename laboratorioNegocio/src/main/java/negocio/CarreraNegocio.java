package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.CarreraDTO;
import entidades.Carrera;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.ICarreraDAO;

/**
 * Clase que maneja la lógica de negocio para las carreras.
 * Proporciona métodos para realizar operaciones sobre las carreras, 
 * incluyendo agregar nuevas carreras y obtener carreras existentes.
 * 
 * @autor Oley
 */
public class CarreraNegocio implements ICarreraNegocio {

    /**
     * DAO para realizar operaciones de persistencia sobre Carrera.
     */
    private ICarreraDAO carreraDAO;

    /**
     * Constructor que inicializa el negocio con un DAO de Carrera.
     * 
     * @param carreraDAO DAO para la persistencia de carrera.
     */
    public CarreraNegocio(ICarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }

    /**
     * Agrega una nueva carrera en la base de datos a partir de su DTO.
     * 
     * @param carreraDTO DTO con la información de la carrera a agregar.
     */
    public void agregarCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = new Carrera(carreraDTO.getNombre(), carreraDTO.getTiempoMaxUsoDiario());
        carreraDAO.agregarCarrera(carrera);
    }

    /**
     * Obtiene una carrera por su nombre.
     * 
     * @param nombre Nombre de la carrera a buscar.
     * @return CarreraDTO con la información de la carrera, o null si no se encuentra.
     */
    @Override
    public CarreraDTO obtenerCarreraPorNombre(String nombre) {
        Carrera carrera = carreraDAO.obtenerCarreraPorNombre(nombre);
        return carrera != null ? convertirACarreraDTO(carrera) : null;
    }

    /**
     * Obtiene todas las carreras en la base de datos.
     * 
     * @return Lista de CarreraDTO con la información de todas las carreras.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<CarreraDTO> obtenerTodos() throws NegocioException {
        try {
            return carreraDAO.obtenerTodos().stream()
                    .map(entidad -> new CarreraDTO(entidad.getId(), entidad.getNombre(), entidad.getTiempoMaxUsoDiario()))
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException("Error al obtener todas las carreras: " + e.getMessage());
        }
    }

    /**
     * Convierte una entidad Carrera en un DTO CarreraDTO.
     * 
     * @param carrera Objeto Carrera a convertir.
     * @return CarreraDTO con la información de la carrera.
     */
    private CarreraDTO convertirACarreraDTO(Carrera carrera) {
        CarreraDTO carreraDTO = new CarreraDTO();
        carreraDTO.setId(carrera.getId());
        carreraDTO.setNombre(carrera.getNombre());
        return carreraDTO;
    }
     public Integer obtenerTiempoMaxUsoDiarioTotal() {
 return carreraDAO.obtenerTiempoMaxUsoDiarioTotal();
    }
}
