package modelos;

import java.util.ArrayList;

public class Cliente {
    private ArrayList<Integer> numAsientos;
    private ArrayList<Pasaje> pasajes = new ArrayList<Pasaje>();


    public Cliente(String nombre, String apellido, String rut, Bus bus, ArrayList<Integer> numAsientos) {
        this.numAsientos = numAsientos;
        for(int i = 0; i< numAsientos.size(); i++){
            Pasaje pasaje = bus.comprarPasaje(numAsientos.get(i));
            pasaje.setDatos(nombre, apellido, rut);
            pasajes.add(pasaje);
        }
    }

}
