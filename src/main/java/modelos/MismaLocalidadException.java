package modelos;
/**
 * Excepción que se lanza cuando se intenta viajar a la misma localidad.
 */
public class MismaLocalidadException extends Exception{
    public MismaLocalidadException(String message){
        super(message);
    }
}
