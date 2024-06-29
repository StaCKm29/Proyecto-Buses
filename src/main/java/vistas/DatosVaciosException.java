package vistas;

/**
 * Excepcion para cuando el cliente quiere comprar y aún no ha rellenado con sus datos personales.
 */
public class DatosVaciosException extends Exception{
    public DatosVaciosException(String message) {
        super(message);
    }
}
