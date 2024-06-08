package modelos;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String rut;
    private Bus bus;
    private ArrayList<Integer> numAsientos;
    private ArrayList<Pasaje> pasajes = new ArrayList<Pasaje>();

    public Cliente(String nombre, String apellido, String rut, Bus bus, ArrayList<Integer> numAsientos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.bus = bus;
        this.numAsientos = numAsientos;
    }

    public void comprarPasaje(){
        for (int i = 0; i < numAsientos.size(); i++) {
        }
    }
}
