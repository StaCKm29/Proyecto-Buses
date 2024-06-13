package modelos;
/**
 * Clase que representa una excepción cuando un asiento ya está ocupado.
 */
public class AsientoOcupadoException extends Exception{
    public AsientoOcupadoException(String message) {
        super(message);
    }
}
