/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.CentroComputoDTO;
import dto.ComputadoraDTO;
import dto.PrestamoComputadoraDTO;
import dto.UnidadAcademicaDTO;
import entidades.Alumno;
import entidades.Carrera;
import entidades.CentroComputo;
import entidades.Computadora;
import entidades.PrestamoComputadora;
import entidades.UnidadAcademica;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.IPrestamoComputadoraDAO;

/**
 *
 * @author Arturo ITSON
 */
public class PrestamoComputadoraNegocio implements IPrestamoComputadoraNegocio{
    
    
    private IPrestamoComputadoraDAO prestamoComputadoraDAO;
    private IAlumnoNegocio alumnoNegocio;
    private IComputadoraNegocio computadoraNegocio;
    private ICentroComputoNegocio centroComputoNegocio;
    private IUnidadNegocio unidadNegocio;
    
    public PrestamoComputadoraNegocio(IPrestamoComputadoraDAO prestamoComputadoraDAO, IAlumnoNegocio alumnoNegocio, IComputadoraNegocio computadoraNegocio, ICentroComputoNegocio centroComputoNegocio, IUnidadNegocio unidadNegocio){
        this.prestamoComputadoraDAO = prestamoComputadoraDAO;
        this.alumnoNegocio = alumnoNegocio;
        this.computadoraNegocio = computadoraNegocio;
        this.centroComputoNegocio = centroComputoNegocio;
        this.unidadNegocio = unidadNegocio;
        
    }
    
    
    @Override
    public PrestamoComputadoraDTO obtenerPorId(Long id) throws NegocioException {
        
        try {
            System.out.println("id busca " + id);
            PrestamoComputadora entidad = prestamoComputadoraDAO.buscarPrestamoComputadora(id);
            if (entidad == null) {
                throw new NegocioException("prestamo no encontrado");
            }
            
            System.out.println("encontro este id " + entidad.getId());
            
            return new PrestamoComputadoraDTO(entidad.getId(), entidad.getAlumno().getId(), entidad.getComputadora().getId(), entidad.getMinutos(), entidad.getFechaPrestamo(), entidad.isSigueAparta());
        } 
        
        catch (Exception e) {
            throw new NegocioException("Error al obtener los bloqueos por id");
        }    
    }
    
    
    
    @Override
    public PrestamoComputadoraDTO guardarPrestamo(PrestamoComputadoraDTO prestamoComputadoraDTO) throws NegocioException {
        System.out.println("dd");
        try{
            
            ComputadoraDTO computadoraDTO = computadoraNegocio.obtenerPorId(prestamoComputadoraDTO.getIdComputadora());
            Computadora compu = this.convertirAEntidad(computadoraDTO);
            
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO = alumnoNegocio.buscarAlumno(prestamoComputadoraDTO.getIdAlumno());
            Alumno alu = alumnoNegocio.convertirAEntidad(alumnoDTO);
            
            PrestamoComputadora prestamoComputadora = new PrestamoComputadora(prestamoComputadoraDTO.getFechaPrestamo(), prestamoComputadoraDTO.getMinutos(), prestamoComputadoraDTO.isSigueApartada(), alu, compu);

            System.out.println(prestamoComputadora.toString());
            
            PrestamoComputadoraDTO prestamoComputadoraNuevo;
            
            System.out.println("negocio id compu" + prestamoComputadora.getComputadora().getId());
            System.out.println("negocio id alumno" + prestamoComputadora.getAlumno().getId());
            
            prestamoComputadora.setSigueAparta(true);
            
            prestamoComputadoraNuevo = this.convertirPrestamoComputadoraDTO(prestamoComputadoraDAO.agregarPrestamoComputadora(prestamoComputadora));

            computadoraDTO.setEstatus("Apartada");
            computadoraNegocio.actualizarComputadora(computadoraDTO);
            
            return prestamoComputadoraNuevo;
        }
        
        catch(NegocioException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    
    @Override
    public PrestamoComputadoraDTO actualizarPrestamoComputadoraDTO(PrestamoComputadoraDTO prestamoComputadora) throws NegocioException {
        
        try{
            
            PrestamoComputadora entidad = prestamoComputadoraDAO.buscarPrestamoComputadora(prestamoComputadora.getId());
            if (entidad == null) {
                throw new NegocioException("prestamo no encontrado");
            }
            
            entidad.setSigueAparta(false);
            
            
            System.out.println(entidad.getId() + " id negocio");
            
            PrestamoComputadoraDTO prestamoEditado = this.convertirPrestamoComputadoraDTO(prestamoComputadoraDAO.editarPrestamoComputadora(entidad));
            
            System.out.println("listo");
 
            return prestamoEditado;
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(PrestamoComputadoraNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    @Override
    public List<PrestamoComputadoraDTO> buscarPrestamoPorAlumno(long idAlumno) throws NegocioException {
        
        try {
            
            AlumnoDTO alu = alumnoNegocio.buscarAlumno(idAlumno);
            
            Carrera carrera = new Carrera(alu.getCarrera().getId(), alu.getCarrera().getNombre(), alu.getCarrera().getTiempoMaxUsoDiario());
            
            Alumno entidad = new Alumno(alu.getId(), alu.getNombres(), alu.getApellidoPaterno(), alu.getApellidoMaterno(), alu.getContraseña(), alu.isEstaEliminado(), carrera);
                        
            List<PrestamoComputadora> prestamo = this.prestamoComputadoraDAO.buscarUltimoPrestamoAlumno(entidad);
            return this.convertirPrestamoComputadoraDTO(prestamo);
        } 
        
        catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }    
    } 
    
    @Override
    public List<PrestamoComputadoraDTO> buscarPrestamoPorComputadora(long idComputadora) throws NegocioException {
        
        try {
            
            ComputadoraDTO computadoraDTO = computadoraNegocio.obtenerPorId(idComputadora);
            
            
            
            CentroComputoDTO centroComputoDTO = centroComputoNegocio.buscarCentroComputo(computadoraDTO.getCentroLaboratorio());
            
            UnidadAcademicaDTO unidadAcademicaDTO = unidadNegocio.obtenerPorId(centroComputoDTO.getId());
            UnidadAcademica unidadAcademica = new UnidadAcademica(unidadAcademicaDTO.getId(), unidadAcademicaDTO.getNombre());
                        
            
            CentroComputo centroComputo = new CentroComputo(centroComputoDTO.getId(), centroComputoDTO.getNombre(), centroComputoDTO.getHoraInicio(), centroComputoDTO.getHoraFinal(), centroComputoDTO.getContraseñaMaestra(), centroComputoDTO.isEliminado(), unidadAcademica);
            
            Computadora computadora = new Computadora(computadoraDTO.getId(), computadoraDTO.getEstatus(), computadoraDTO.getIp(), computadoraDTO.getNumeroMaquina(), computadoraDTO.isUsoAlumno(), computadoraDTO.isUsoAlumno(), centroComputo);
            
            
            List<PrestamoComputadora> prestamo = this.prestamoComputadoraDAO.buscarUltimoPrestamoPorComputadora(computadora);
            return this.convertirPrestamoComputadoraDTO(prestamo);
        } 
        
        catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            throw new NegocioException(ex.getMessage());
        }    
    }     
    
    public Computadora convertirAEntidad(ComputadoraDTO computadoraDTO) throws NegocioException {
        if (computadoraDTO == null) {
            return null;
            
            
            
        }
        return new Computadora(
                computadoraDTO.getId(),
                computadoraDTO.getEstatus(),
                computadoraDTO.getIp(),
                computadoraDTO.getNumeroMaquina(),
                computadoraDTO.isUsoAlumno(),
                computadoraDTO.isEliminado(),
                this.convertirAEntidad(centroComputoNegocio.buscarCentroComputo(computadoraDTO.getCentroLaboratorio()))
                
        );
    }
    
    private CentroComputo convertirAEntidad(CentroComputoDTO centroComputoDTO) {
        if (centroComputoDTO == null) {
            return null;
        }
        return new  CentroComputo(
                centroComputoDTO.getNombre(),
                centroComputoDTO.getHoraInicio(),
                centroComputoDTO.getHoraFinal(),
                centroComputoDTO.getContraseñaMaestra(),
                centroComputoDTO.isEliminado(),
                this.convertirAEntidad(centroComputoDTO.getUnidadAcademica())
        );
    }
    
    
    private UnidadAcademica convertirAEntidad(UnidadAcademicaDTO unidadAcademicaDTO) {
        if (unidadAcademicaDTO == null) {
            return null;
        }
        return new  UnidadAcademica(
                unidadAcademicaDTO.getNombre()
        );
    }
    
    private PrestamoComputadoraDTO convertirPrestamoComputadoraDTO(PrestamoComputadora prestamoComputadora){
            if (prestamoComputadora == null) {
            return null;
        }
        return new  PrestamoComputadoraDTO(
                prestamoComputadora.getId(),
                prestamoComputadora.getAlumno().getId(),
                prestamoComputadora.getComputadora().getId(),
                prestamoComputadora.getMinutos(),
                prestamoComputadora.getFechaPrestamo(),
                prestamoComputadora.isSigueAparta()
        );
    }
    
    
    private List<PrestamoComputadoraDTO> convertirPrestamoComputadoraDTO(List<PrestamoComputadora> prestamos) throws NegocioException {
        if (prestamos == null) {
            throw new NegocioException("No se pudieron obtener los prestamos. No hay registros.");
        }
        
            List<PrestamoComputadoraDTO> bloqueoDTO = new ArrayList<>();
        for (PrestamoComputadora prestamo : prestamos) {
            PrestamoComputadoraDTO dto = new PrestamoComputadoraDTO();
            dto.setId(prestamo.getId());
            dto.setMinutos(prestamo.getMinutos());
            dto.setIdAlumno(prestamo.getAlumno().getId());
            dto.setIdComputadora(prestamo.getComputadora().getId());
            prestamo.setFechaPrestamo(prestamo.getFechaPrestamo());          

            bloqueoDTO.add(dto);
        }
        return bloqueoDTO;
    }  
    
}
