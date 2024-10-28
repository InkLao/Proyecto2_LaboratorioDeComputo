package NegocioException;

/**
 * Excepción personalizada para errores en la capa de negocio. 
 * Esta clase se utiliza para representar excepciones específicas relacionadas 
 * con la lógica de negocio de la aplicación.
 * 
 * @autor Arturo ITSON
 */
public class NegocioException extends Exception {

    /**
     * Constructor de la excepción que acepta un mensaje de error.
     * 
     * @param mensaje El mensaje de error asociado con la excepción.
     */
    public NegocioException(String mensaje) {
        super(mensaje);
    }
}
