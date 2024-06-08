package modelos;

public class Comun extends Asiento{

    public Comun(int numero) {
        super(numero);
    }

    public String getTipo(){
        return "Comun";
    }

    public int getPrecio(){
        return 2000;
    }



}
