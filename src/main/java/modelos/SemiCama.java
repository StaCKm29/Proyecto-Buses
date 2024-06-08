package modelos;

public class SemiCama extends Asiento{

        public SemiCama(int numero, String ubicacion) {
            super(numero, ubicacion);
        }

        public String getTipo(){
            return "SemiCama";
        }
}
