package modelos;

public class SalonCama extends Asiento{

    public SalonCama(int numero, String ubicacion) {
        super(numero, ubicacion);
    }

    public String getTipo(){
        return "SalonCama";
    }

}
