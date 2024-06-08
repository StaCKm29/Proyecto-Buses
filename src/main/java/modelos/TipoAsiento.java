package modelos;

public enum TipoAsiento {
    COMUN{
        @Override
        public Asiento crearAsiento(int numAsiento) {
            return new Comun(numAsiento);
        }
    },
    SEMICAMA{
        @Override
        public Asiento crearAsiento(int numAsiento) {
            return new SemiCama(numAsiento);
        }
    },
    SALONCAMA{
        @Override
        public Asiento crearAsiento(int numAsiento){
            return new SalonCama(numAsiento);
        }
    };

    public abstract Asiento crearAsiento(int numAsiento);
}
