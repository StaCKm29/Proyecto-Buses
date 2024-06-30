package vistas;

/**
 * Excepcion para cuando el cliente quiere comprar y aún no ha rellenado con sus datos personales.
 */
public class DatosVaciosException extends Exception{
    /**
     * Constructor de la excepcion.
     * @param message Mensaje de la excepcion.
     */
    public DatosVaciosException(String message) {
        super(message);
    }
}
