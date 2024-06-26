package modelos;

/**
 * Clase abstracta Asiento que representa un asiento de un bus.
 */
public abstract class Asiento {
    private int numero;
    private boolean estado;
    /**
     * Constructor de la clase Asiento.
     * @param numero Número del asiento.
     */
    public Asiento(int numero) {
        this.numero = numero;
        this.estado = false;
    }

    /**
     * Método que retorna el número del asiento.
     * @return Número del asiento.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método que retorna el estado del asiento.
     * @return Estado del asiento.
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Método que ocupa el asiento.
     */
    public void Ocupar(){
        this.estado = true;
    }
    
    public abstract String getTipo();

}
