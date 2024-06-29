package vistas;

/**
 * Excepción que muestra un mensaje de error cuando se intenta buscar un recorrido donde el origen y destino son iguales.
 */
public class MismasLocalidadesException extends Exception{
    public MismasLocalidadesException(String message) {
        super(message);
    }
}
