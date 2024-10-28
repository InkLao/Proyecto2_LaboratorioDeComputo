/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import Excepciones.PersistenciaException;
import entidades.CentroComputo;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la entidad `CentroComputo`.
 * Proporciona métodos para agregar, editar, eliminar y buscar centros de
 * cómputo, además de obtener todos los centros, centros activos, y un centro
 * específico por nombre.
 *
 * @author eduar
 */
public interface ICentroComputoDAO {

    /**
     * Agrega un nuevo centro de cómputo a la base de datos.
     *
     * @param centroComputo Centro de cómputo a agregar
     */
    void agregarCentroComputo(CentroComputo centroComputo);

    /**
     * Edita la información de un centro de cómputo existente en la base de
     * datos.
     *
     * @param centroComputo Centro de cómputo a editar
     */
    void editarCentroComputo(CentroComputo centroComputo);

    /**
     * Busca un centro de cómputo por su identificador.
     *
     * @param id Identificador del centro de cómputo
     * @return Centro de cómputo encontrado o null si no existe
     */
    CentroComputo buscarCentroComputo(Long id);

    /**
     * Marca un centro de cómputo como eliminado en la base de datos.
     *
     * @param centroComputo Centro de cómputo a eliminar
     * @return Centro de cómputo eliminado
     */
    CentroComputo eliminarCentroComputo(CentroComputo centroComputo);

    /**
     * Obtiene todos los centros de cómputo almacenados en la base de datos.
     *
     * @return Lista de todos los centros de cómputo
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<CentroComputo> obtenerTodos() throws PersistenciaException;

    /**
     * Obtiene un centro de cómputo por su nombre.
     *
     * @param nombre Nombre del centro de cómputo
     * @return Centro de cómputo encontrado o null si no existe
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public CentroComputo obtenerPorCentroNombre(String nombre) throws PersistenciaException;

    /**
     * Obtiene todos los centros de cómputo que están activos (no eliminados).
     *
     * @return Lista de centros de cómputo activos
     * @throws PersistenciaException si ocurre un error durante la operación
     */
    public List<CentroComputo> obtenerTodosLosQueEstanActivos() throws PersistenciaException;
}
