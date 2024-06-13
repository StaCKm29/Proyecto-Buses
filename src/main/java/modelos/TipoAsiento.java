package modelos;
/**
 * Enumeración que representa los tipos de asientos disponibles.
 */
public enum TipoAsiento {
    COMUN(2000){
        @Override
        public Asiento crearAsiento(int numAsiento) {
            return new Comun(numAsiento);
        }

        /*@Override
        public Asiento getAsiento(int numAsiento){
            return new Comun(numAsiento);
        }*/
    },
    SEMICAMA(6000){
        @Override
        public Asiento crearAsiento(int numAsiento) {
            return new SemiCama(numAsiento);
        }

        /*@Override
        public Asiento getAsiento(int numAsiento){
            return new SemiCama(numAsiento);
        }*/
    },
    SALONCAMA(12000){
        @Override
        public Asiento crearAsiento(int numAsiento){
            return new SalonCama(numAsiento);
        }

        /*@Override
        public Asiento getAsiento(int numAsiento){
            return new SalonCama(numAsiento);
        }*/
    };
    private final int precio;
    /**
     * Constructor de la enumeración TipoAsiento.
     * @param precio Precio del asiento.
     */
    TipoAsiento(int precio){
        this.precio = precio;
    }
    /**
     * Método que crea un asiento.
     * @param numAsiento Número del asiento.
     * @return Asiento creado.
     */
    public abstract Asiento crearAsiento(int numAsiento);
    /**
     * Método que retorna el precio del asiento.
     * @return Precio del asiento.
     */
    public int getPrecio() {
        return precio;
    }
}
