/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.BloqueoDTO;
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
public class BloqueoNegocio implements IBloqueoNegocio{

    
    private IBloqueoDAO bloqueoDAO;

    public BloqueoNegocio(IBloqueoDAO bloqueoDAO) {
        this.bloqueoDAO = bloqueoDAO;
    }
    
    
    
    @Override
    public List<BloqueoDTO> buscarBloqueosTabla() throws NegocioException {
        
        try {
            List<Bloqueo> beneficiarios = this.bloqueoDAO.obtenerTodos();
            return this.convertirBloqueoDTO(beneficiarios);
        } 
        
        catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }    
    }

    
    @Override
    public BloqueoDTO guardarBloqueo(BloqueoDTO bloqueo) throws NegocioException {

        try{
            
            Bloqueo blo = new Bloqueo(bloqueo.getMotivo(), bloqueo.getFechaBloqueo(), bloqueo.getFechaLiberacion(), bloqueo.isEliminado(), bloqueo.getAlumno());

            BloqueoDTO bloqueoNuevo;
            
            bloqueoNuevo = this.convertirBloqueoDTO(bloqueoDAO.agregarBloqueo(blo));
            
            return bloqueoNuevo;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public BloqueoDTO obtenerPorId(Long id) throws NegocioException {
        
        try {
            Bloqueo entidad = bloqueoDAO.buscarBloqueo(id);
            if (entidad == null) {
                throw new NegocioException("Bloqueo no encontrado");
            }
            return new BloqueoDTO(entidad.getId(), entidad.getFechaBloqueo(), entidad.getFechaLiberacion(), entidad.getMotivo(), entidad.isEliminado(), entidad.getAlumno());
        } 
        
        catch (Exception e) {
            throw new NegocioException("Error al obtener los bloqueos por id");
        }    
    }

    
    @Override
    public List<BloqueoDTO> obtenerTodos() throws NegocioException {
        
        try {
            return bloqueoDAO.obtenerTodos().stream()
                    .map(entidad -> new BloqueoDTO(entidad.getId(), entidad.getFechaBloqueo(), entidad.getFechaLiberacion(), entidad.getMotivo(), entidad.isEliminado(), entidad.getAlumno()))
                    .collect(Collectors.toList());
        } 
        
        catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public BloqueoDTO actualizarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        
        try{
            
            Bloqueo blo = new Bloqueo();
            blo.setAlumno(bloqueo.getAlumno());
            blo.setEliminado(blo.isEliminado());
            blo.setFechaBloqueo(bloqueo.getFechaBloqueo());
            blo.setFechaLiberacion(bloqueo.getFechaLiberacion());
            blo.setId(bloqueo.getId());
            blo.setMotivo(bloqueo.getMotivo());
            
            
            BloqueoDTO bloqueoNuevo;
            
            bloqueoNuevo = this.convertirBloqueoDTO(bloqueoDAO.editarBloqueo(blo));
            
            return bloqueoNuevo;
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }    

    @Override
    public void eliminarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        try{
            
            Bloqueo blo = new Bloqueo();
            blo = bloqueoDAO.buscarBloqueo(bloqueo.getId());
            
            System.out.println(blo.getId());
            blo.setEliminado(true);

            BloqueoDTO bloqueoNuevo;
            
            bloqueoNuevo = this.convertirBloqueoDTO(bloqueoDAO.eliminarBloqueo(blo));
            
        }
        
        catch(Exception e){
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
            dto.setAlumno(bloqueo.getAlumno());
            dto.setMotivo(bloqueo.getMotivo());
            

            bloqueoDTO.add(dto);
        }
        return bloqueoDTO;
    }  
    
    
    private BloqueoDTO convertirBloqueoDTO(Bloqueo bloqueo) throws NegocioException {
        if (bloqueo == null) {
            throw new NegocioException("No se pudo obtener el bloqueo.");
        }

        return new BloqueoDTO(bloqueo.getId(), bloqueo.getFechaBloqueo(), bloqueo.getFechaLiberacion(), bloqueo.getMotivo(), bloqueo.isEliminado(), bloqueo.getAlumno());
    } 
}
