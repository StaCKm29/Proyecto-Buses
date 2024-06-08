package modelos;

import java.util.ArrayList;

public class Nivel<T> {
    private ArrayList<T> asientos;

    public Nivel(){
        asientos = new ArrayList<T>();
    }

    public void addAsiento(T asiento){
        asientos.add(asiento);
    }

    public T getAsiento(int numAsiento){
        if(asientos.isEmpty()){
            return null;
        }else{
            return asientos.get(numAsiento-1);
        }
    }
    public int asientosDisponibles(){
        return asientos.size();
    }
}
