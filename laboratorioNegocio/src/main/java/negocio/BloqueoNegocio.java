package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.BloqueoDTO;
import entidades.Alumno;
import entidades.Bloqueo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.IBloqueoDAO;

/**
 * Clase que maneja la lógica de negocio para los bloqueos de alumnos en el
 * sistema. Proporciona métodos para realizar operaciones CRUD sobre los
 * bloqueos.
 *
 * @autor Arturo ITSON
 */
public class BloqueoNegocio implements IBloqueoNegocio {

    /**
     * DAO para realizar operaciones de persistencia sobre Bloqueo.
     */
    private IBloqueoDAO bloqueoDAO;

    /**
     * Interfaz de negocio para la gestión de alumnos.
     */
    private IAlumnoNegocio alumnoNegocio;

    /**
     * Constructor de la clase BloqueoNegocio que recibe un IBloqueoDAO e
     * IAlumnoNegocio.
     *
     * @param bloqueoDAO DAO para realizar operaciones de persistencia sobre
     * Bloqueo.
     * @param alumnoNegocio Interfaz de negocio para la gestión de alumnos.
     */
    public BloqueoNegocio(IBloqueoDAO bloqueoDAO, IAlumnoNegocio alumnoNegocio) {
        this.bloqueoDAO = bloqueoDAO;
        this.alumnoNegocio = alumnoNegocio;
    }

    /**
     * Obtiene una lista de todos los bloqueos para la tabla de visualización.
     *
     * @return Lista de BloqueoDTO con la información de todos los bloqueos.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<BloqueoDTO> buscarBloqueosTabla() throws NegocioException {
        try {
            List<Bloqueo> beneficiarios = this.bloqueoDAO.obtenerTodos();
            return this.convertirBloqueoDTO(beneficiarios);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Guarda un nuevo bloqueo en la base de datos.
     *
     * @param bloqueo DTO con la información del bloqueo a guardar.
     * @return BloqueoDTO con la información del bloqueo guardado.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public BloqueoDTO guardarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        try {

            AlumnoDTO alumnoDTO = new AlumnoDTO();

            alumnoDTO = alumnoNegocio.buscarAlumno(bloqueo.getAlumno());
            System.out.println(alumnoDTO.toString());

            Alumno alu = alumnoNegocio.convertirAEntidad(alumnoDTO);
            Bloqueo blo = new Bloqueo(bloqueo.getMotivo(), bloqueo.getFechaBloqueo(), bloqueo.getFechaLiberacion(), bloqueo.isEliminado(), alu);

            System.out.println(blo.toString());

            BloqueoDTO bloqueoNuevo;

            System.out.println(blo.getMotivo());
            bloqueoNuevo = this.convertirBloqueoDTO(bloqueoDAO.agregarBloqueo(blo));
            System.out.println(bloqueoNuevo.getId());
            return bloqueoNuevo;
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene un bloqueo por su ID.
     *
     * @param id Identificador del bloqueo.
     * @return BloqueoDTO con la información del bloqueo.
     * @throws NegocioException Si el bloqueo no se encuentra o ocurre un error.
     */
    @Override
    public BloqueoDTO obtenerPorId(Long id) throws NegocioException {
        try {
            Bloqueo entidad = bloqueoDAO.buscarBloqueo(id);
            if (entidad == null) {
                throw new NegocioException("Bloqueo no encontrado");
            }
            return new BloqueoDTO(entidad.getId(), entidad.getFechaBloqueo(), entidad.getFechaLiberacion(), entidad.getMotivo(), entidad.isEliminado(), entidad.getAlumno().getId());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el bloqueo por ID");
        }
    }

    /**
     * Busca bloqueos por su motivo.
     *
     * @param motivo Motivo del bloqueo a buscar.
     * @return Lista de BloqueoDTO con la información de los bloqueos
     * encontrados.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<BloqueoDTO> buscarBloqueosTabla(String motivo) throws NegocioException {
        try {
            List<Bloqueo> bloqueos = this.bloqueoDAO.buscarBloqueo(motivo);
            return this.convertirBloqueoDTO(bloqueos);
        } catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Obtiene una lista de todos los bloqueos.
     *
     * @return Lista de BloqueoDTO con la información de todos los bloqueos.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<BloqueoDTO> obtenerTodos() throws NegocioException {
        try {
            return bloqueoDAO.obtenerTodos().stream()
                    .map(entidad -> new BloqueoDTO(entidad.getId(), entidad.getFechaBloqueo(), entidad.getFechaLiberacion(), entidad.getMotivo(), entidad.isEliminado(), entidad.getAlumno().getId()))
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza un bloqueo en la base de datos.
     *
     * @param bloqueo DTO con la información actualizada del bloqueo.
     * @return BloqueoDTO con la información del bloqueo actualizado.
     * @throws NegocioException Si el bloqueo no se encuentra o ocurre un error.
     */
    @Override
    public BloqueoDTO actualizarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        try {
            Bloqueo entidad = bloqueoDAO.buscarBloqueo(bloqueo.getId());
            if (entidad == null) {
                throw new NegocioException("Bloqueo no encontrado");
            }
            entidad.setEliminado(bloqueo.isEliminado());
            entidad.setFechaBloqueo(bloqueo.getFechaBloqueo());
            entidad.setFechaLiberacion(bloqueo.getFechaLiberacion());
            entidad.setMotivo(bloqueo.getMotivo());
            bloqueoDAO.editarBloqueo(entidad);
            return bloqueo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Marca un bloqueo como eliminado en la base de datos.
     *
     * @param bloqueo DTO con la información del bloqueo a eliminar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public void eliminarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        try {

            Bloqueo blo = new Bloqueo();
            blo = bloqueoDAO.buscarBloqueo(bloqueo.getId());

            System.out.println(blo.getId());
            blo.setEliminado(true);
            bloqueoDAO.eliminarBloqueo(blo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convierte una lista de objetos Bloqueo a una lista de BloqueoDTO.
     *
     * @param bloqueos Lista de objetos Bloqueo.
     * @return Lista de BloqueoDTO con la información de los bloqueos.
     * @throws NegocioException Si la lista de bloqueos es nula.
     */
    private List<BloqueoDTO> convertirBloqueoDTO(List<Bloqueo> bloqueos) throws NegocioException {
        if (bloqueos == null) {
            throw new NegocioException("No se pudieron obtener los bloqueos. No hay registros.");
        }
        List<BloqueoDTO> bloqueoDTO = new ArrayList<>();
        for (Bloqueo bloqueo : bloqueos) {
            BloqueoDTO dto = new BloqueoDTO();
            dto.setEliminado(bloqueo.isEliminado());
            dto.setFechaBloqueo(bloqueo.getFechaBloqueo());
            dto.setFechaLiberacion(bloqueo.getFechaLiberacion());
            dto.setId(bloqueo.getId());
            dto.setAlumno(bloqueo.getAlumno().getId());
            dto.setMotivo(bloqueo.getMotivo());
            bloqueoDTO.add(dto);
        }
        return bloqueoDTO;
    }

    /**
     * Convierte un objeto Bloqueo a BloqueoDTO.
     *
     * @param bloqueo Objeto Bloqueo.
     * @return BloqueoDTO con la información del bloqueo.
     * @throws NegocioException Si el bloqueo es nulo.
     */
    private BloqueoDTO convertirBloqueoDTO(Bloqueo bloqueo) throws NegocioException {
        if (bloqueo == null) {
            throw new NegocioException("No se pudo obtener el bloqueo.");
        }
        return new BloqueoDTO(bloqueo.getId(), bloqueo.getFechaBloqueo(), bloqueo.getFechaLiberacion(), bloqueo.getMotivo(), bloqueo.isEliminado(), bloqueo.getAlumno().getId());
    }

    /**
     * Busca bloqueos dentro de un rango de fechas.
     *
     * @param fechaInicio Fecha de inicio del rango.
     * @param fechaFinal Fecha final del rango.
     * @return Lista de BloqueoDTO con los bloqueos encontrados en el rango de
     * fechas.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<BloqueoDTO> buscarBloqueosPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws NegocioException {
        try {
            List<Bloqueo> bloqueos = bloqueoDAO.buscarBloqueoPorFecha(fechaInicio, fechaFinal);
            return convertirBloqueoDTO(bloqueos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener los bloqueos por fecha: " + ex.getMessage());
        }
    }
}
