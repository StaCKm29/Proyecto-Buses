package vistas;

/**
 * Excepcion cuando el usuario quiere buscar un stock de buses y aun no ha instaciado localidad de origen y destino.
 */
public class LocalidadesNullException extends Exception{
    public LocalidadesNullException(String message) {
        super(message);
    }
}
