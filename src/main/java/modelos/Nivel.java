package modelos;

import java.util.ArrayList;

public class Nivel<T extends Asiento> {
    private ArrayList<T> asientos;

    public Nivel(){
        asientos = new ArrayList<T>();
    }

    public void addAsiento(T asiento){
        asientos.add(asiento);
    }

    //Este método se usara para adquirir/comprar un asiento
    public T adquirirAsiento(int numAsiento){
        if(asientos.isEmpty()){
            return null;
        }else{
            asientos.get(numAsiento-1).Ocupar();
            return asientos.get(numAsiento-1);
        }
    }
    //Este método se usara para obtener acceso a un asiento sin ocuparlo
    public T getAsiento(int numAsiento){
        if(asientos.isEmpty()){
            return null;
        }else{
            return asientos.get(numAsiento-1);
        }
    }

    public int asientosDisponibles(){
        int asientosDisponibles = 0;
        for(int i = 0; i < asientos.size(); i++){
            if(asientos.get(i).getEstado() == false){
                asientosDisponibles++;
            }
        }
        return asientosDisponibles;
    }
}
