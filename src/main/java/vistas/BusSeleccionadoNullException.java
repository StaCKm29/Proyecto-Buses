package vistas;

/**
 * Excepción para cuando el usuario presion "Seleccionar" sin haber seleccionado un bus.
 */
public class BusSeleccionadoNullException extends Exception{
    public BusSeleccionadoNullException(String message) {
        super(message);
    }
}
