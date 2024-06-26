package modelos;
/**
 * Excepción que se lanza cuando la localidad es nula.
 */
public class LocalidadNullException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje de la excepción.
     */
    public LocalidadNullException(String message){
        super(message);
    }
}
