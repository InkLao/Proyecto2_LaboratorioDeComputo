/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import persistencia.ICentroComputoDAO;
import persistencia.IComputadoraDAO;

/**
 *
 * @author Arturo ITSON
 */
public class ComputadoraNegocio implements IComputadoraNegocio{
    
    
    private IComputadoraDAO computadoraDAO;
    private ICentroComputoNegocio centroComputoNegocio;

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO, ICentroComputoNegocio centroComputoNegocio) {
        this.computadoraDAO = computadoraDAO;
        this.centroComputoNegocio = centroComputoNegocio;

        
    }
    
    
    
    @Override
    public List<ComputadoraDTO> buscarComputadorasTabla() throws NegocioException {
        
        try {
            List<Computadora> computadoras = this.computadoraDAO.obtenerTodos();
            return this.convertirComputadoraDTO(computadoras);
        } 
        
        catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }    
    }

    
    @Override
    public ComputadoraDTO guardarComputadora(ComputadoraDTO computadora) throws NegocioException {

        try{
            
           ComputadoraDTO compuNuevo;
           
           Computadora compu = new Computadora();
            System.out.println("centro es: " + computadora.getCentroLaboratorio());
            
           CentroComputoDTO centro = centroComputoNegocio.buscarCentroComputo(computadora.getCentroLaboratorio());
            


           
           
           System.out.println(centro.toString());
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
           
          // System.out.println("centro de computo es:" + compu.getCentroComputo().getNombre());

           
           compuNuevo = this.convertirComputadoraDTO(computadoraDAO.agregarComputadora(compu));
           
           
           return compuNuevo;
        }
        
        catch(NegocioException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public ComputadoraDTO obtenerPorId(Long id) throws NegocioException {
        
        try {
            
            Computadora entidad = computadoraDAO.buscarComputadora(id);
            if (entidad == null) {
                throw new NegocioException("compu no encontrada");
            }
            
            System.out.println("encontro este id " + entidad.getId());
            
            return new ComputadoraDTO(entidad.getId(), entidad.getDireccionIP(), entidad.getEstatus(), entidad.getNumeroMaquina(), entidad.isUsoAlumno(), entidad.getCentroComputo().getId(), entidad.isEliminado());
        } 
        
        catch (Exception e) {
            throw new NegocioException("Error al obtener las computadoras por id");
        }    
    }
    
    
    @Override
    public List<ComputadoraDTO> buscarBloqueosTabla(String ip) throws NegocioException {
        
        try {
            List<Computadora> computadoras = this.computadoraDAO.buscarComputadoras(ip);
            return this.convertirComputadoraDTO(computadoras);
        } 
        
        catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }    
    }   

    
    @Override
    public List<ComputadoraDTO> obtenerTodos() throws NegocioException {
        
        try {
            return computadoraDAO.obtenerTodos().stream()
                    .map(entidad -> new ComputadoraDTO(entidad.getId(), entidad.getDireccionIP(), entidad.getEstatus(), entidad.getNumeroMaquina(), entidad.isUsoAlumno(), entidad.getCentroComputo().getId(), entidad.isEliminado()))
                    .collect(Collectors.toList());
        } 
        
        catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public ComputadoraDTO actualizarComputadora(ComputadoraDTO computadora) throws NegocioException {
        
        try{
            
            Computadora entidad = computadoraDAO.buscarComputadora(computadora.getId());
            if (entidad == null) {
                throw new NegocioException("bloqueo no encontrado");
            }
            
//            CentroComputoDTO centroComputo = new CentroComputoDTO();
//            centroComputo = centroComputoNegocio.buscarCentroComputo(computadora.getCentroLaboratorio());
//            
//            System.out.println(centroComputo.toString());
//            
//            entidad.setCentroComputo(centroComputoNegocio.convertirAEntidad(centroComputo));
            entidad.setDireccionIP(computadora.getIp());
            entidad.setEstatus(computadora.getEstatus());
            entidad.setId(computadora.getId());
            entidad.setNumeroMaquina(computadora.getNumeroMaquina());
            entidad.setUsoAlumno(entidad.isUsoAlumno());
            
            
            System.out.println(entidad.getId() + " id negocio");
            
            computadoraDAO.editarComputadora(entidad);
            
            System.out.println("listo");
 
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return computadora;
    }    

    @Override
    public void eliminarComputadora(ComputadoraDTO computadora) throws NegocioException {
        try{
            
            Computadora compu = new Computadora();
            compu = computadoraDAO.buscarComputadora(computadora.getId());
            
            System.out.println(computadora.getId());
            compu.setEliminado(true);
            
            computadoraDAO.eliminarComputadora(compu);
            
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }    
    
    
    
    private List<ComputadoraDTO> convertirComputadoraDTO(List<Computadora> computadoras) throws NegocioException {
        if (computadoras == null) {
            throw new NegocioException("No se pudieron obtener las compus. No hay registros.");
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
    
    
    private ComputadoraDTO convertirComputadoraDTO(Computadora computadora) throws NegocioException {
        if (computadora == null) {
            throw new NegocioException("No se pudo obtener el bloqueo.");
        }

        return new ComputadoraDTO(computadora.getId(), computadora.getDireccionIP(), computadora.getEstatus(), computadora.getNumeroMaquina(), computadora.isUsoAlumno(), computadora.getCentroComputo().getId(), computadora.isEliminado());
    }
    
    
}
