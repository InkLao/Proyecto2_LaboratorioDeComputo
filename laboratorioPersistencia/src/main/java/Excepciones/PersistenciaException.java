package Excepciones;

/**
 * Excepción personalizada para errores en la capa de persistencia. 
 * Esta clase se utiliza para representar excepciones específicas relacionadas 
 * con la persistencia de datos en la base de datos.
 * 
 * @autor Arturo ITSON
 */
public class PersistenciaException extends Exception {
    
    /**
     * Constructor de la excepción que acepta solo un mensaje de error.
     * 
     * @param message El mensaje de error asociado con la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción que acepta un mensaje de error y una causa.
     * 
     * @param message El mensaje de error asociado con la excepción.
     * @param cause La causa subyacente de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}
