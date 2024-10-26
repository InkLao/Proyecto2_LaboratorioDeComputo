/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.PersistenciaException;
import NegocioException.NegocioException;
import dto.AlumnoDTO;
import dto.BloqueoDTO;
import dto.CarreraDTO;
import entidades.Alumno;
import entidades.Bloqueo;
import entidades.Carrera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.AlumnoDAO;
import persistencia.IAlumnoDAO;

/**
 *
 * @author Oley
 */
public class AlumnoNegocio implements IAlumnoNegocio {

    private IAlumnoDAO alumnoDAO;

    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    @Override
    public AlumnoDTO buscarAlumno(Long id) {
        Alumno alumno = alumnoDAO.buscarAlumno(id);
        return convertirADto(alumno);
    }

    @Override
    public List<AlumnoDTO> buscarAlumnosTabla() {
        try {
            List<Alumno> alumnos = alumnoDAO.obtenerTodos();
            return alumnos.stream().map(this::convertirADto).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error al buscar alumnos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public AlumnoDTO guardarAlumnos(AlumnoDTO alumnoDTO) {
        try {
            Alumno alumno = convertirAEntidad(alumnoDTO);
            Alumno alumnoGuardado = alumnoDAO.agregarAlumno(alumno);
            return convertirADto(alumnoGuardado);
        } catch (Exception e) {
            System.out.println("Error al guardar el alumno: " + e.getMessage());
            return null;
        }
    }

    @Override
    public AlumnoDTO obtenerPorId(Long id) {
        Alumno entidad = alumnoDAO.buscarAlumno(id);
        return convertirADto(entidad);
    }

    @Override
    public List<AlumnoDTO> obtenerTodos() {
        return buscarAlumnosTabla();
    }

    @Override
    public AlumnoDTO actualizarAlumnos(AlumnoDTO alumnoDTO) {
        try {
            Alumno entidad = alumnoDAO.buscarAlumno(alumnoDTO.getId());
            if (entidad == null) {
                throw new NegocioException("Alumno no encontrado");
            }
            entidad.setNombres(alumnoDTO.getNombres());
            entidad.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
            entidad.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
            entidad.setContraseña(alumnoDTO.getContraseña());
            entidad.setEstaEliminado(alumnoDTO.isEstaEliminado());
            alumnoDAO.editarAlumno(entidad);
            return convertirADto(entidad);
        } catch (Exception e) {
            System.out.println("Error al actualizar el alumno: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void eliminarAlumnos(AlumnoDTO alumnoDTO) {
        try {
            Alumno alumno = alumnoDAO.buscarAlumno(alumnoDTO.getId());
            if (alumno != null) {
                alumno.setEstaEliminado(true);
                alumnoDAO.eliminarAlumno(alumno);
            } else {
                throw new NegocioException("Alumno no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }

    @Override
    public List<AlumnoDTO> buscarAlumnosTabla(String nombre) {
        try {
            List<Alumno> alumnos = alumnoDAO.buscarAlumno(nombre);
            return alumnos.stream().map(this::convertirADto).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error al buscar alumnos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Carrera convertirAEntidad(CarreraDTO carreraDTO) {
        if (carreraDTO == null) {
            return null;
        }
        return new Carrera(carreraDTO.getId(), carreraDTO.getNombre(), carreraDTO.getTiempoMaxUsoDiario());
    }

    @Override
    public Alumno convertirAEntidad(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return null;
        }
        Carrera carrera = convertirAEntidad(alumnoDTO.getCarrera());
        return new Alumno(
                alumnoDTO.getId(),
                alumnoDTO.getNombres(),
                alumnoDTO.getApellidoPaterno(),
                alumnoDTO.getApellidoMaterno(),
                alumnoDTO.getContraseña(),
                alumnoDTO.isEstaEliminado(),
                carrera
        );
    }

    private AlumnoDTO convertirADto(Alumno alumno) {
      if (alumno == null) {
        return null;
    }
    CarreraDTO carreraDTO = convertirADTO(alumno.getCarrera());
    return new AlumnoDTO(
        alumno.getId(),
        alumno.getNombres(), // Asegúrate de que aquí estás obteniendo el nombre correcto
        alumno.getApellidoPaterno(),
        alumno.getApellidoMaterno(),
        alumno.getContraseña(),
        carreraDTO, // Esto debe ser un objeto CarreraDTO correctamente mapeado
        alumno.isEstaEliminado()
    );
    }

    private CarreraDTO convertirADTO(Carrera carrera) {
        if (carrera == null) {
            return null;
        }
        return new CarreraDTO(carrera.getId(), carrera.getNombre(), carrera.getTiempoMaxUsoDiario());
    }

//   private IAlumnoDAO alumnoDAO;
//
//    public AlumnoNegocio(IAlumnoDAO alumnoDAO) {
//        this.alumnoDAO = alumnoDAO;
//    }
//
//
//  
//
//    public AlumnoDTO buscarAlumno(Long id) {
//        Alumno alumno = alumnoDAO.buscarAlumno(id);
//        return convertirADto(alumno);
//    }
//
//
//    public Alumno convertirADto(AlumnoDTO alumnoDTO) {
//        if (alumnoDTO == null) {
//            return null;
//        }
//        Carrera carrera = null;
//        if (alumnoDTO.getCarrera() != null) {
//            carrera = new Carrera();
//            carrera.setId(alumnoDTO.getCarrera().getId());
//            carrera.setNombre(alumnoDTO.getCarrera().getNombre());
//        }
//        return new Alumno(
//            alumnoDTO.getId(),
//            alumnoDTO.getNombres(),
//            alumnoDTO.getApellidoPaterno(),
//            alumnoDTO.getApellidoMaterno(),
//            alumnoDTO.getContraseña(),
//            carrera
//        );
//    }
//
//    public AlumnoDTO convertirADto(Alumno alumno) {
//        if (alumno == null) {
//            return null;
//        }
//        CarreraDTO carreraDTO = null;
//        if (alumno.getCarrera() != null) {
//            carreraDTO = new CarreraDTO();
//            carreraDTO.setId(alumno.getCarrera().getId());
//            carreraDTO.setNombre(alumno.getCarrera().getNombre());
//        }
//        return new AlumnoDTO(
//            alumno.getNombres(),
//            alumno.getApellidoPaterno(),
//            alumno.getApellidoMaterno(),
//            alumno.getContraseña(),
//            carreraDTO
//        );
//    }
//    
//    
//    @Override
//    public Alumno convertirAEntidad(AlumnoDTO alumno) {
//        if (alumno == null) {
//            return null;
//        }
//        CarreraDTO carreraDTO = null;
//        if (alumno.getCarrera() != null) {
//            carreraDTO = new CarreraDTO();
//            carreraDTO.setId(alumno.getCarrera().getId());
//            carreraDTO.setNombre(alumno.getCarrera().getNombre());
//        }
//        return new Alumno(
//            alumno.getNombres(),
//            alumno.getApellidoPaterno(),
//            alumno.getApellidoMaterno(),
//            alumno.getContraseña(),
//            this.convertirAEntidad(alumno.getCarrera())
//        );
//    }    
//    
//    @Override
//    public Carrera convertirAEntidad(CarreraDTO carrera) {
//        if (carrera == null) {
//            return null;
//        }
//        return new Carrera(              
//                carrera.getNombre(),
//                carrera.getTiempoMaxUsoDiario() 
//        );
//    }    
//    
//    public CarreraDTO convertirADTO(Carrera carrera) {
//        if (carrera == null) {
//            return null;
//        }
//        return new CarreraDTO(
//                carrera.getNombre(),
//                carrera.getTiempoMaxUsoDiario()         
//        );
//    } 
//private List<AlumnoDTO> convertirAlumnoDtO(List<Alumno> alumnos ) throws NegocioException {
//     if (alumnos == null || alumnos.isEmpty()) {
//        throw new NegocioException("No se pudieron obtener los bloqueos. No hay registros.");
//    }
//
//    List<AlumnoDTO> alumnoDTOs = new ArrayList<>();
//    for (Alumno alumno : alumnos) {
//        AlumnoDTO alumnoDTO = new AlumnoDTO();
//        alumnoDTO.setNombres(alumno.getNombres());
//        alumnoDTO.setApellidoPaterno(alumno.getApellidoPaterno());
//        alumnoDTO.setApellidoMaterno(alumno.getApellidoMaterno());
//        
//        CarreraDTO carreraDTO = null;
//        if (alumno.getCarrera() != null) {
//            carreraDTO = new CarreraDTO();
//            carreraDTO.setId(alumno.getCarrera().getId());
//            carreraDTO.setNombre(alumno.getCarrera().getNombre());
//        }
//        alumnoDTO.setCarrera(carreraDTO); 
//
//        alumnoDTO.setContraseña(alumno.getContraseña());
//        alumnoDTO.setEstaEliminado(alumno.isEstaEliminado());
//        alumnoDTOs.add(alumnoDTO);
//    }
//    return alumnoDTOs;
//}
//    @Override
//    public List<AlumnoDTO> buscarAlumnosTabla() {
//          try {
//        List<Alumno> beneficiarios = this.alumnoDAO.obtenerTodos();
//        return this.convertirAlumnoDtO(beneficiarios);
//    } catch (Exception e) {
//        System.out.println("Error al buscar alumnos: " + e.getMessage());
//        return Collections.emptyList(); 
//    
//         
//        
//          
//
//
//    }
//    }
//    @Override
//    public AlumnoDTO guardarAlumnos(AlumnoDTO alumnoDTO) {
//  try {
//        Alumno alumno = convertirAEntidad(alumnoDTO);
//        
//        Alumno alumnoGuardado = alumnoDAO.agregarAlumno(alumno);
//        
//        return convertirADto(alumnoGuardado);
//    } catch (Exception e) {
//        System.out.println("Error al guardar el alumno: " + e.getMessage());
//        return null;
//    }
//
//    }
//
//    @Override
//    public AlumnoDTO obtenerPorId(Long id) {
//         System.out.println("id busca " + id);
//    Alumno entidad = alumnoDAO.buscarAlumno(id);
//    
//   
//
//    System.out.println("encontró este id " + entidad.getId());
//
//    CarreraDTO carreraDTO = null;
//    if (entidad.getCarrera() != null) {
//        carreraDTO = new CarreraDTO();
//        carreraDTO.setId(entidad.getCarrera().getId());
//        carreraDTO.setNombre(entidad.getCarrera().getNombre());
//    }
//
//    return new AlumnoDTO(
//        entidad.getId(),
//        entidad.getNombres(),
//        entidad.getApellidoPaterno(),
//        entidad.getApellidoMaterno(),
//        entidad.getContraseña(),
//        carreraDTO, 
//        entidad.isEstaEliminado()
//    );
//    }
//        
//       
//               
//
//    @Override
//    public List<AlumnoDTO> obtenerTodos() {
// 
//        return alumnoDAO.obtenerTodos().stream()
//                .map(entidad -> {
//                    CarreraDTO carreraDTO = null;
//                    if (entidad.getCarrera() != null) {
//                        carreraDTO = new CarreraDTO();
//                        carreraDTO.setId(entidad.getCarrera().getId());
//                        carreraDTO.setNombre(entidad.getCarrera().getNombre());
//                    }
//                    return new AlumnoDTO(
//                        entidad.getNombres(),
//                        entidad.getApellidoPaterno(),
//                        entidad.getApellidoMaterno(),
//                        entidad.getContraseña(),
//                        carreraDTO 
//                    );
//                })
//                .collect(Collectors.toList());
//        
//    }
//
//    @Override
//    public AlumnoDTO actualizarAlumnos(AlumnoDTO alumnoDTO) {
//try{
//            
//            Alumno entidad = alumnoDAO.buscarAlumno(alumnoDTO.getId());
//            if (entidad == null) {
//                throw new NegocioException("alumno no encontrado");
//            }
//            
//          //  entidad.setAlumno(alumnoNegocio.convertirAEntidad(alumnoNegocio.buscarAlumno(bloqueo.getAlumno())));
//            entidad.setNombres(alumnoDTO.getNombres());
//            entidad.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
//            entidad.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
//             entidad.setEstaEliminado(alumnoDTO.isEstaEliminado());
//            
//            System.out.println(entidad.getId() + " id negocio");
//            
//            alumnoDAO.editarAlumno(entidad);
//            
//            System.out.println("listo");
//
//    }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//        return alumnoDTO;
//    }
//
//    @Override
//    public void eliminarAlumnos(AlumnoDTO alumnoDTO) {
//  try{
//            
//            Alumno alumno = new Alumno();
//            alumno = alumnoDAO.buscarAlumno(alumnoDTO.getId());
//            
//            System.out.println(alumno.getId());
//            alumno.setEstaEliminado(true);
//            
//            alumnoDAO.eliminarAlumno(alumno);
//            
//            
//        }
//        
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }    }
//
//    @Override
//    public List<AlumnoDTO> buscarAlumnosTabla(String nombre) {
//      try {
//        List<Alumno> alumnos = this.alumnoDAO.buscarAlumno(nombre);
//        return this.convertirAlumnoDtO(alumnos);
//    } catch (NegocioException e) {
//        System.out.println("Error al buscar alumnos: " + e.getMessage());
//        return Collections.emptyList();
//    }
//        
//          
//}
}
