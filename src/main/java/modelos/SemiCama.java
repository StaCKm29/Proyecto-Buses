package modelos;
/**
 * Clase que representa un asiento de tipo semi cama.
 */
public class SemiCama extends Asiento{
    /**
     * Constructor de la clase SemiCama.
     * @param numero Número del asiento.
     */
    public SemiCama(int numero) {
        super(numero);
    }
    /**
     * Método que retorna el tipo de asiento.
     * @return Tipo de asiento.
     */
    public String getTipo(){
        return "SemiCama";
    }
}
