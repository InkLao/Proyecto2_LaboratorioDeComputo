/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.CentroComputo;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface ICentroComputoDAO {

    void agregarCentroComputo(CentroComputo centroComputo);

    void editarCentroComputo(CentroComputo centroComputo);

    CentroComputo buscarCentroComputo(Long id);

    CentroComputo eliminarCentroComputo(CentroComputo centroComputo);
    
    public List<CentroComputo> obtenerTodos() throws PersistenciaException;
}
