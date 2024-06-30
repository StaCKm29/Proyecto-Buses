package vistas;

/**
 * Excepción que muestra un mensaje de error cuando se intenta buscar un recorrido donde el origen y destino son iguales.
 */
public class MismasLocalidadesException extends Exception{
    /**
     * Constructor de la excepción.
     * @param message Mensaje de la excepción.
     */
    public MismasLocalidadesException(String message) {
        super(message);
    }
}
