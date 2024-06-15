package modelos;
/**
 * Enumeración que representa las localidades a las que se pueden viajar.
 */
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
    /**
     * Método que retorna el nombre de la localidad.
     * @return Nombre de la localidad.
     */
    public abstract String toString();
}
