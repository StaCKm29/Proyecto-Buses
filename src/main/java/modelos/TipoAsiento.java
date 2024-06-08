package modelos;

public enum TipoAsiento {
    COMUN{
        @Override
        public Asiento crearAsiento() {
            return new Comun();
        }
    },
    SEMICAMA{
        @Override
        public Asiento crearAsiento() {
            return new SemiCama();
        }
    },
    SALONCAMA{
        @Override
        public Asiento crearAsiento() {
            return new SalonCama();
        }
    };

    public abstract Asiento crearAsiento();
}
