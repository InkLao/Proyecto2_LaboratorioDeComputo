/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 * Excepción personalizada que representa errores específicos en la capa de persistencia.
 * Puede ser utilizada para manejar excepciones relacionadas con operaciones de almacenamiento de datos.
 * 
 * @author Arturo ITSON
 */
public class PersistenciaException extends Exception {
    
    /**
     * Crea una nueva excepción de persistencia con un mensaje descriptivo.
     *
     * @param message Mensaje que describe el error
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Crea una nueva excepción de persistencia con un mensaje descriptivo y una causa.
     *
     * @param message Mensaje que describe el error
     * @param cause Causa original de la excepción
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}