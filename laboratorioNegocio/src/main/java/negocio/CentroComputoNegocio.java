package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.CentroComputoDTO;
import dto.UnidadAcademicaDTO;
import entidades.CentroComputo;
import entidades.UnidadAcademica;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.ICentroComputoDAO;

/**
 * Clase que representa la lógica de negocio para la gestión de centros de
 * cómputo. Proporciona métodos para realizar operaciones CRUD sobre los centros
 * de cómputo.
 *
 * @autor eduar
 */
public class CentroComputoNegocio implements ICentroComputoNegocio {

    /**
     * DAO para realizar operaciones de persistencia sobre CentroComputo.
     */
    private ICentroComputoDAO centroComputoDAO;

    /**
     * Constructor de la clase CentroComputoNegocio que recibe un
     * ICentroComputoDAO.
     *
     * @param centroComputoDAO DAO para realizar operaciones de persistencia
     * sobre CentroComputo.
     */
    public CentroComputoNegocio(ICentroComputoDAO centroComputoDAO) {
        this.centroComputoDAO = centroComputoDAO;
    }

    /**
     * Agrega un nuevo centro de cómputo en la base de datos.
     *
     * @param centroComputoDTO DTO con la información del centro de cómputo a
     * agregar.
     */
    @Override
    public void agregarCentroComputo(CentroComputoDTO centroComputoDTO) {
        CentroComputo centroComputo = convertirAEntidad(centroComputoDTO);
        centroComputoDAO.agregarCentroComputo(centroComputo);
    }

    /**
     * Edita un centro de cómputo existente en la base de datos.
     *
     * @param centroComputoDTO DTO con la información actualizada del centro de
     * cómputo.
     */
    @Override
    public void editarCentroComputo(CentroComputoDTO centroComputoDTO) {
        CentroComputo centroComputo = convertirAEntidad(centroComputoDTO);
        centroComputoDAO.editarCentroComputo(centroComputo);
    }

    /**
     * Busca un centro de cómputo por su ID.
     *
     * @param id Identificador del centro de cómputo.
     * @return CentroComputoDTO con la información del centro de cómputo.
     * @throws NegocioException Si el centro de cómputo no se encuentra o ocurre
     * un error.
     */
    @Override
    public CentroComputoDTO buscarCentroComputo(Long id) throws NegocioException {
        CentroComputo centroComputo = centroComputoDAO.buscarCentroComputo(id);
        return convertirADto(centroComputo);
    }

    /**
     * Marca un centro de cómputo como eliminado en la base de datos.
     *
     * @param centroComputo DTO con la información del centro de cómputo a
     * eliminar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public void eliminarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException {
        try {

            CentroComputo cc = new CentroComputo();
            cc = centroComputoDAO.buscarCentroComputo(centroComputo.getId());

            System.out.println(cc.getId());
            cc.setEliminado(true);
            centroComputoDAO.eliminarCentroComputo(cc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Actualiza un centro de cómputo en la base de datos.
     *
     * @param centroComputo DTO con la información actualizada del centro de
     * cómputo.
     * @return CentroComputoDTO con la información del centro de cómputo
     * actualizado.
     * @throws NegocioException Si el centro de cómputo no se encuentra o ocurre
     * un error.
     */
    @Override
    public CentroComputoDTO actualizarCentroComputo(CentroComputoDTO centroComputo) throws NegocioException {
        try {
            CentroComputo entidad = centroComputoDAO.buscarCentroComputo(centroComputo.getId());
            if (entidad == null) {
                throw new NegocioException("Centro de cómputo no encontrado");
            }
            entidad.setNombre(centroComputo.getNombre());
            entidad.setEliminado(centroComputo.isEliminado());
            entidad.setHoraInicio(centroComputo.getHoraInicio());
            entidad.setHoraFinal(centroComputo.getHoraFinal());
            entidad.setContraseñaMaestra(centroComputo.getContraseñaMaestra());
            centroComputoDAO.editarCentroComputo(entidad);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return centroComputo;
    }

    /**
     * Convierte un DTO CentroComputoDTO en una entidad CentroComputo.
     *
     * @param centroComputoDTO DTO del centro de cómputo.
     * @return Objeto CentroComputo.
     */
    @Override
    public CentroComputo convertirAEntidad(CentroComputoDTO centroComputoDTO) {
        if (centroComputoDTO == null) {
            return null;
        }
        UnidadAcademica unidadAcademica = new UnidadAcademica();
        unidadAcademica.setId(centroComputoDTO.getUnidadAcademica().getId());
        unidadAcademica.setNombre(centroComputoDTO.getUnidadAcademica().getNombre());

        return new CentroComputo(
                centroComputoDTO.getNombre(),
                centroComputoDTO.getHoraInicio(),
                centroComputoDTO.getHoraFinal(),
                centroComputoDTO.getContraseñaMaestra(),
                centroComputoDTO.isEliminado(),
                unidadAcademica
        );
    }

    /**
     * Obtiene una lista de todos los centros de cómputo.
     *
     * @return Lista de CentroComputoDTO con la información de todos los centros
     * de cómputo.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<CentroComputoDTO> obtenerTodosLosCentros() throws NegocioException {
        try {
            List<CentroComputo> centros = centroComputoDAO.obtenerTodos();  // Método DAO para obtener todos los registros
            return centros.stream()
                    .map(this::convertirADto) // Usa el método existente de conversión
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException("Error al obtener todos los centros de cómputo.");
        }
    }

    /**
     * Obtiene una lista de todos los centros de cómputo activos.
     *
     * @return Lista de CentroComputoDTO con la información de los centros de
     * cómputo activos.
     * @throws NegocioException Si ocurre un error en la lógica de negocio.
     */
    @Override
    public List<CentroComputoDTO> obtenerTodosLosCentrosActivos() throws NegocioException {
        try {
            List<CentroComputo> centros = centroComputoDAO.obtenerTodosLosQueEstanActivos();  // Método DAO para obtener todos los registros
            return centros.stream()
                    .map(this::convertirADto) // Usa el método existente de conversión
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException("Error al obtener todos los centros de cómputo activos.");
        }
    }

    /**
     * Obtiene un centro de cómputo por su nombre.
     *
     * @param nombre Nombre del centro de cómputo.
     * @return CentroComputoDTO con la información del centro de cómputo.
     * @throws NegocioException Si el centro de cómputo no se encuentra o ocurre
     * un error.
     */
    @Override
    public CentroComputoDTO obtenerPorCentroNombre(String nombre) throws NegocioException {
        try {
            CentroComputo entidad = centroComputoDAO.obtenerPorCentroNombre(nombre);
            if (entidad == null) {
                throw new NegocioException("Centro de cómputo no encontrado");
            }
            return new CentroComputoDTO(entidad.getId(), entidad.getNombre(), entidad.getHoraInicio(), entidad.getHoraFinal(), entidad.getContraseñaMaestra(), entidad.isEliminado(), this.convertirADTO(entidad.getUnidadAcademica()));
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el centro de cómputo por nombre");
        }
    }

    /**
     * Convierte una entidad CentroComputo en un DTO CentroComputoDTO.
     *
     * @param centroComputo Objeto CentroComputo.
     * @return CentroComputoDTO con la información del centro de cómputo.
     */
    @Override
    public CentroComputoDTO convertirADto(CentroComputo centroComputo) {
        if (centroComputo == null) {
            return null;
        }
        UnidadAcademicaDTO unidadAcademicaDTO = new UnidadAcademicaDTO();
        unidadAcademicaDTO.setId(centroComputo.getUnidadAcademica().getId());
        unidadAcademicaDTO.setNombre(centroComputo.getUnidadAcademica().getNombre());

        return new CentroComputoDTO(
                centroComputo.getId(),
                centroComputo.getNombre(),
                centroComputo.getHoraInicio(),
                centroComputo.getHoraFinal(),
                centroComputo.getContraseñaMaestra(),
                centroComputo.isEliminado(),
                unidadAcademicaDTO
        );
    }

    /**
     * Convierte una entidad UnidadAcademica en un DTO UnidadAcademicaDTO.
     *
     * @param unidad Objeto UnidadAcademica.
     * @return UnidadAcademicaDTO con la información de la unidad académica.
     */
    private UnidadAcademicaDTO convertirADTO(UnidadAcademica unidad) {
        if (unidad == null) {
            return null;
        }
        return new UnidadAcademicaDTO(unidad.getId(), unidad.getNombre());
    }
}
