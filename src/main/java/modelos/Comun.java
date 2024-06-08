package modelos;

public class Comun extends Asiento{

    public Comun(int numero, String ubicacion) {
        super(numero, ubicacion);
    }

    public String getTipo(){
        return "Comun";
    }

    public int getPrecio(){
        return 2000;
    }



}
