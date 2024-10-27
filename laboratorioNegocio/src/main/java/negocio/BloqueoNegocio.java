/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author Arturo ITSON
 */
public class BloqueoNegocio implements IBloqueoNegocio {

    private IBloqueoDAO bloqueoDAO;
    private IAlumnoNegocio alumnoNegocio;

    public BloqueoNegocio(IBloqueoDAO bloqueoDAO, IAlumnoNegocio alumnoNegocio) {
        this.bloqueoDAO = bloqueoDAO;
        this.alumnoNegocio = alumnoNegocio;
    }

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

    @Override
    public BloqueoDTO guardarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        System.out.println("dd");
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
        }

        return null;
    }

    @Override
    public BloqueoDTO obtenerPorId(Long id) throws NegocioException {

        try {
            System.out.println("id busca " + id);
            Bloqueo entidad = bloqueoDAO.buscarBloqueo(id);
            if (entidad == null) {
                throw new NegocioException("Bloqueo no encontrado");
            }

            System.out.println("encontro este id " + entidad.getId());

            return new BloqueoDTO(entidad.getId(), entidad.getFechaBloqueo(), entidad.getFechaLiberacion(), entidad.getMotivo(), entidad.isEliminado(), entidad.getAlumno().getId());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener los bloqueos por id");
        }
    }

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

    @Override
    public List<BloqueoDTO> obtenerTodos() throws NegocioException {

        try {
            return bloqueoDAO.obtenerTodos().stream()
                    .map(entidad -> new BloqueoDTO(entidad.getId(), entidad.getFechaBloqueo(), entidad.getFechaLiberacion(), entidad.getMotivo(), entidad.isEliminado(), entidad.getAlumno().getId()))
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public BloqueoDTO actualizarBloqueo(BloqueoDTO bloqueo) throws NegocioException {

        try {

            Bloqueo entidad = bloqueoDAO.buscarBloqueo(bloqueo.getId());
            if (entidad == null) {
                throw new NegocioException("bloqueo no encontrado");
            }

            //  entidad.setAlumno(alumnoNegocio.convertirAEntidad(alumnoNegocio.buscarAlumno(bloqueo.getAlumno())));
            entidad.setEliminado(bloqueo.isEliminado());
            entidad.setFechaBloqueo(bloqueo.getFechaBloqueo());
            entidad.setFechaLiberacion(bloqueo.getFechaLiberacion());
            entidad.setMotivo(bloqueo.getMotivo());

            System.out.println(entidad.getId() + " id negocio");

            bloqueoDAO.editarBloqueo(entidad);

            System.out.println("listo");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return bloqueo;
    }

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

    private BloqueoDTO convertirBloqueoDTO(Bloqueo bloqueo) throws NegocioException {
        if (bloqueo == null) {
            throw new NegocioException("No se pudo obtener el bloqueo.");
        }

        return new BloqueoDTO(bloqueo.getId(), bloqueo.getFechaBloqueo(), bloqueo.getFechaLiberacion(), bloqueo.getMotivo(), bloqueo.isEliminado(), bloqueo.getAlumno().getId());
    }

    @Override
    public List<BloqueoDTO> buscarBloqueosPorFecha(Calendar fechaInicio, Calendar fechaFinal) throws NegocioException {
        try {
            // Llama al método del DAO para obtener los bloqueos en el rango de fechas
            List<Bloqueo> bloqueos = bloqueoDAO.buscarBloqueoPorFecha(fechaInicio, fechaFinal);

            // Convierte la lista de entidades a DTO
            return convertirBloqueoDTO(bloqueos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener los bloqueos por fecha: " + ex.getMessage());
        }
    }

}
