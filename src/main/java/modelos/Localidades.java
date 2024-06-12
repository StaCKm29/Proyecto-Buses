package modelos;

public enum Localidades {
    FRUTILLAR{
        @Override
        public String toString() {
            return "Frutillar";
        }
    },
    CHILLAN{
        @Override
        public String toString() {
            return "Chillán";
        }
    },
    CONCEPCION{
        @Override
        public String toString() {
            return "Concepción";
        }
    },
    SANTIAGO{
        @Override
        public String toString() {
            return "Santiago";
        }
    };
    public abstract String toString();
}
