package modelos;

public class SalonCama extends Asiento{

    public SalonCama(int numero) {
        super(numero);
    }

    public String getTipo(){
        return "SalonCama";
    }

    public int getPrecio(){
        return 12000;
    }

}
