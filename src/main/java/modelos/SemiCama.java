package modelos;

public class SemiCama extends Asiento{

        public SemiCama(int numero) {
            super(numero);
        }

        public String getTipo(){
            return "SemiCama";
        }

        public int getPrecio(){
            return 6000;
        }
}
