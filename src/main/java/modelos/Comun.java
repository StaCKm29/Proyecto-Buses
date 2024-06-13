package modelos;

/**
 * Clase que representa un asiento común.
 */
public class Comun extends Asiento{
    /**
     * Constructor de la clase Comun.
     * @param numero Número del asiento.
     */
    public Comun(int numero) {
        super(numero);
    }
    /**
     * Método que retorna el tipo de asiento.
     * @return Tipo de asiento.
     */
    public String getTipo(){
        return "Comun";
    }
}
