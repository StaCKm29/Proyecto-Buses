package modelos;

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

    TipoAsiento(int precio){
        this.precio = precio;
    }

    public abstract Asiento crearAsiento(int numAsiento);
    //public abstract Asiento getAsiento(int numAsiento);

    public int getPrecio() {
        return precio;
    }
}
