/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.CentroComputo;

/**
 *
 * @author eduar
 */
public interface ICentroComputoDAO {

    void agregarCentroComputo(CentroComputo centroComputo);

    void editarCentroComputo(CentroComputo centroComputo);

    CentroComputo buscarCentroComputo(Long id);

    void eliminarCentroComputo(Long id);
}
