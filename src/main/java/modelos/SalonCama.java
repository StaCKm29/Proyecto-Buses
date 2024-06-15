package modelos;
/**
 * Clase que representa un asiento de tipo salón cama.
 */
public class SalonCama extends Asiento{
    /**
     * Constructor de la clase SalonCama.
     * @param numero Número del asiento.
     */
    public SalonCama(int numero) {
        super(numero);
    }
    /**
     * Método que retorna el tipo de asiento.
     * @return Tipo de asiento.
     */
    public String getTipo(){
        return "SalonCama";
    }
}
