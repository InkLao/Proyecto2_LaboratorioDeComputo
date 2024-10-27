/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.CentroComputoDTO;
import dto.ComputadoraDTO;
import dto.PrestamoComputadoraDTO;
import dto.UnidadAcademicaDTO;
import entidades.Alumno;
import entidades.CentroComputo;
import entidades.Computadora;
import entidades.PrestamoComputadora;
import entidades.UnidadAcademica;
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
    
    public PrestamoComputadoraNegocio(IPrestamoComputadoraDAO prestamoComputadoraDAO, IAlumnoNegocio alumnoNegocio, IComputadoraNegocio computadoraNegocio, ICentroComputoNegocio centroComputoNegocio){
        this.prestamoComputadoraDAO = prestamoComputadoraDAO;
        this.alumnoNegocio = alumnoNegocio;
        this.computadoraNegocio = computadoraNegocio;
        this.centroComputoNegocio = centroComputoNegocio;
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
            
            PrestamoComputadora prestamoComputadora = new PrestamoComputadora(prestamoComputadoraDTO.getFechaPrestamo(), prestamoComputadoraDTO.getMinutos(), alu, compu);

            System.out.println(prestamoComputadora.toString());
            
            PrestamoComputadoraDTO prestamoComputadoraNuevo;
            
            System.out.println("negocio id compu" + prestamoComputadora.getComputadora().getId());
            System.out.println("negocio id alumno" + prestamoComputadora.getAlumno().getId());
            
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
                prestamoComputadora.getComputadora().getId(),
                prestamoComputadora.getMinutos(),
                prestamoComputadora.getFechaPrestamo()
        );
    }
    
}
