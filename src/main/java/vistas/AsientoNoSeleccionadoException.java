package vistas;

/**
 * Excepcion que se lanza cuando no se ha seleccionado ningun asiento y presionan "COMPRAR".
 */
public class AsientoNoSeleccionadoException extends Exception{
    public AsientoNoSeleccionadoException(String message) {
        super(message);
    }
}
