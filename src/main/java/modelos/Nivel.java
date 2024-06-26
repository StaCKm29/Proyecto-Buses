package modelos;

import java.util.ArrayList;
/**
 * Clase que representa un nivel de un bus.
 * @param <T> Tipo de asiento que contiene el nivel.
 */
public class Nivel<T extends Asiento> {
    private ArrayList<T> asientos;
    /**
     * Constructor de la clase Nivel.
     */
    public Nivel(){
        asientos = new ArrayList<T>();
    }
    /**
     * Método que agrega un asiento al nivel.
     * @param asiento Asiento a agregar.
     */
    public void addAsiento(T asiento){
        asientos.add(asiento);
    }

    /**
     * Método que retorna un pasaje y que a su vez lo compra (lo ocupa).
     * @param numAsiento Número del asiento.
     * @return asiento comprado.
     */
    public T adquirirAsiento(int numAsiento){
        if(asientos.isEmpty()){
            return null;
        }else{
            asientos.get(numAsiento-1).Ocupar();
            return asientos.get(numAsiento-1);
        }
    }
    /**
     * Método que retorna un asiento sin comprarlo.
     * @param numAsiento Número del asiento.
     * @return Asiento.
     */
    public T getAsiento(int numAsiento){
        if(asientos.isEmpty()){
            return null;
        }else{
            return asientos.get(numAsiento-1);
        }
    }
    /**
     * Método que retorna la cantidad de asientos disponibles en el nivel.
     * @return Cantidad de asientos disponibles.
     */
    public int asientosDisponibles(){
        int asientosDisponibles = 0;
        for(int i = 0; i < asientos.size(); i++){
            if(asientos.get(i).getEstado() == false){
                asientosDisponibles++;
            }
        }
        return asientosDisponibles;
    }
    /**
     * Método que retorna los asientos del nivel.
     * @return ArrayList de asientos.
     */
    public ArrayList<T> getArrayAsientos(){
        return asientos;
    }
}
