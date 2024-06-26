package modelos;
/**
 * Excepción que se lanza cuando se intenta viajar a la misma localidad.
 */
public class MismaLocalidadException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje de la excepción.
     */
    public MismaLocalidadException(String message){
        super(message);
    }
}
