/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.UnidadAcademica;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IUnidadAcademicaDAO {
    void agregarUnidadAcademica(UnidadAcademica  unidadAcademica);
    List<UnidadAcademica> obtenerTodas();
    
    public UnidadAcademica buscarUnidadAcademica(Long id) throws PersistenciaException;
            
}
