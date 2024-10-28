package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import dto.ComputadoraDTO;
import entidades.CentroComputo;
import entidades.Computadora;
import entidades.UnidadAcademica;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.IComputadoraDAO;

/**
 * Clase que representa la lógica de negocio para la gestión de computadoras.
 * Proporciona métodos para realizar operaciones CRUD sobre computadoras,
 * incluyendo la conversión entre entidades y DTOs.
 *
 * @autor Arturo ITSON
 */
public class ComputadoraNegocio implements IComputadoraNegocio {

    /**
     * DAO para realizar operaciones de persistencia sobre Computadora.
     */
    private IComputadoraDAO computadoraDAO;

    /**
     * Negocio para gestionar operaciones de CentroComputo.
     */
    private ICentroComputoNegocio centroComputoNegocio;

    /**
     * Constructor de la clase ComputadoraNegocio que recibe un IComputadoraDAO
     * y un ICentroComputoNegocio.
     *
     * @param computadoraDAO DAO para operaciones de persistencia sobre
     * Computadora.
     * @param centroComputoNegocio Negocio para operaciones sobre CentroComputo.
     */
    public ComputadoraNegocio(IComputadoraDAO computadoraDAO, ICentroComputoNegocio centroComputoNegocio) {
        this.computadoraDAO = computadoraDAO;
        this.centroComputoNegocio = centroComputoNegocio;
    }

    /**
     * Busca y obtiene una lista de todas las computadoras en la base de datos.
     *
     * @return Lista de ComputadoraDTO con la información de todas las
     * computadoras.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<ComputadoraDTO> buscarComputadorasTabla() throws NegocioException {
        try {
            List<Computadora> computadoras = this.computadoraDAO.obtenerTodos();
            return this.convertirComputadoraDTO(computadoras);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Guarda una nueva computadora en la base de datos.
     *
     * @param computadora DTO con la información de la computadora a guardar.
     * @return ComputadoraDTO con la información de la computadora guardada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public ComputadoraDTO guardarComputadora(ComputadoraDTO computadora) throws NegocioException {
        try {
            Computadora compu = new Computadora();
            CentroComputoDTO centro = centroComputoNegocio.buscarCentroComputo(computadora.getCentroLaboratorio());
            compu.setDireccionIP(computadora.getIp());
            compu.setEliminado(false);
            compu.setEstatus("Disponible");
            compu.setNumeroMaquina(computadora.getNumeroMaquina());
            compu.setUsoAlumno(computadora.isUsoAlumno());

            CentroComputo entidad = new CentroComputo();
            entidad.setContraseñaMaestra(centro.getContraseñaMaestra());
            entidad.setEliminado(centro.isEliminado());
            entidad.setHoraFinal(centro.getHoraFinal());
            entidad.setHoraInicio(centro.getHoraInicio());
            entidad.setId(centro.getId());
            entidad.setNombre(centro.getNombre());

            UnidadAcademica uni = new UnidadAcademica();
            uni.setId(centro.getUnidadAcademica().getId());
            uni.setNombre(centro.getUnidadAcademica().getNombre());

            entidad.setUnidadAcademica(uni);
            compu.setCentroComputo(entidad);

            return this.convertirComputadoraDTO(computadoraDAO.agregarComputadora(compu));
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene una computadora por su ID.
     *
     * @param id Identificador de la computadora.
     * @return ComputadoraDTO con la información de la computadora encontrada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public ComputadoraDTO obtenerPorId(Long id) throws NegocioException {
        try {
            Computadora entidad = computadoraDAO.buscarComputadora(id);
            if (entidad == null) {
                throw new NegocioException("Computadora no encontrada");
            }
            return new ComputadoraDTO(entidad.getId(), entidad.getDireccionIP(), entidad.getEstatus(), entidad.getNumeroMaquina(), entidad.isUsoAlumno(), entidad.getCentroComputo().getId(), entidad.isEliminado());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener la computadora por ID");
        }
    }

    /**
     * Obtiene una computadora por su dirección IP.
     *
     * @param ip Dirección IP de la computadora.
     * @return ComputadoraDTO con la información de la computadora encontrada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public ComputadoraDTO obtenerPorIP(String ip) throws NegocioException {
        try {
            Computadora computadora = this.computadoraDAO.buscarComputadoras(ip);
            return this.convertirComputadoraDTO(computadora);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Actualiza la información de una computadora.
     *
     * @param computadora DTO con la información actualizada de la computadora.
     * @return ComputadoraDTO con la información de la computadora actualizada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public ComputadoraDTO actualizarComputadora(ComputadoraDTO computadora) throws NegocioException {
        try {
            Computadora entidad = computadoraDAO.buscarComputadora(computadora.getId());
            if (entidad == null) {
                throw new NegocioException("Computadora no encontrada");
            }
            entidad.setDireccionIP(computadora.getIp());
            entidad.setEstatus(computadora.getEstatus());
            entidad.setId(computadora.getId());
            entidad.setNumeroMaquina(computadora.getNumeroMaquina());
            entidad.setUsoAlumno(entidad.isUsoAlumno());

            computadoraDAO.editarComputadora(entidad);
            return computadora;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return computadora;
    }

    /**
     * Marca una computadora como eliminada.
     *
     * @param computadora DTO con la información de la computadora a eliminar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public void eliminarComputadora(ComputadoraDTO computadora) throws NegocioException {
        try {
            Computadora compu = computadoraDAO.buscarComputadora(computadora.getId());
            compu.setEliminado(true);
            computadoraDAO.eliminarComputadora(compu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convierte una lista de entidades Computadora en una lista de DTOs
     * ComputadoraDTO.
     *
     * @param computadoras Lista de entidades Computadora.
     * @return Lista de DTOs ComputadoraDTO.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    private List<ComputadoraDTO> convertirComputadoraDTO(List<Computadora> computadoras) throws NegocioException {
        if (computadoras == null) {
            throw new NegocioException("No se encontraron registros de computadoras.");
        }

        List<ComputadoraDTO> computadoraDTO = new ArrayList<>();
        for (Computadora computadora : computadoras) {
            ComputadoraDTO dto = new ComputadoraDTO();
            dto.setCentroLaboratorio(computadora.getCentroComputo().getId());
            dto.setEliminado(computadora.isEliminado());
            dto.setEstatus(computadora.getEstatus());
            dto.setId(computadora.getId());
            dto.setIp(computadora.getDireccionIP());
            dto.setNumeroMaquina(computadora.getNumeroMaquina());
            dto.setUsoAlumno(computadora.isUsoAlumno());

            computadoraDTO.add(dto);
        }
        return computadoraDTO;
    }

    /**
     * Convierte una entidad Computadora en un DTO ComputadoraDTO.
     *
     * @param computadora Entidad Computadora a convertir.
     * @return DTO ComputadoraDTO con la información de la computadora.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    public ComputadoraDTO convertirComputadoraDTO(Computadora computadora) throws NegocioException {
        if (computadora == null) {
            throw new NegocioException("No se pudo obtener la computadora.");
        }
        return new ComputadoraDTO(computadora.getId(), computadora.getDireccionIP(), computadora.getEstatus(), computadora.getNumeroMaquina(), computadora.isUsoAlumno(), computadora.getCentroComputo().getId(), computadora.isEliminado());
    }

    /**
     * Obtiene todas las computadoras en la base de datos.
     *
     * @return Lista de ComputadoraDTO con información de todas las
     * computadoras.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<ComputadoraDTO> obtenerTodos() throws NegocioException {
        try {
            return computadoraDAO.obtenerTodos().stream()
                    .map(entidad -> new ComputadoraDTO(entidad.getId(), entidad.getDireccionIP(), entidad.getEstatus(), entidad.getNumeroMaquina(), entidad.isUsoAlumno(), entidad.getCentroComputo().getId(), entidad.isEliminado()))
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ComputadoraDTO> buscarBloqueosTabla(String ip) throws NegocioException {

        try {
            List<Computadora> computadoras = this.computadoraDAO.buscarComputadorasPorIP(ip);
            return this.convertirComputadoraDTO(computadoras);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<ComputadoraDTO> buscarBloqueosPorEstatusTabla(String estatus) throws NegocioException {

        try {
            List<Computadora> computadoras = this.computadoraDAO.buscarComputadorasPorEstatus(estatus);
            return this.convertirComputadoraDTO(computadoras);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public ComputadoraDTO buscarComputadorasPorNumMaquina(Integer numMaquina) throws NegocioException {

        try {

            Computadora entidad = computadoraDAO.buscarComputadorasPorNumMaquina(numMaquina);
            if (entidad == null) {
                throw new NegocioException("compu no encontrada");
            }

            System.out.println("encontro este id " + entidad.getId());

            return new ComputadoraDTO(entidad.getId(), entidad.getDireccionIP(), entidad.getEstatus(), entidad.getNumeroMaquina(), entidad.isUsoAlumno(), entidad.getCentroComputo().getId(), entidad.isEliminado());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener las computadoras por id");
        }
    }

    @Override
    public List<ComputadoraDTO> buscarComputadorasUsoAlumnoTabla() throws NegocioException {

        try {
            List<Computadora> computadoras = this.computadoraDAO.buscarComputadorasUsoAlumno();
            return this.convertirComputadoraDTO(computadoras);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }
}
