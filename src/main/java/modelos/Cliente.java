package modelos;

import java.util.ArrayList;
/**
 * Clase que representa un cliente.
 */
public class Cliente {
    private ArrayList<Integer> numAsientos;
    private ArrayList<Pasaje> pasajes = new ArrayList<>();
    /**
     * Constructor de la clase Cliente.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param rut Rut del cliente.
     * @param bus Bus en el que se compran los pasajes.
     * @param numAsientos Números de los asientos que se desean comprar.
     */
    public Cliente(String nombre, String apellido, String rut, Bus bus, ArrayList<Integer> numAsientos) {
        this.numAsientos = numAsientos;
        for(int i = 0; i< numAsientos.size(); i++){
            int precioTotal = bus.getPrecioTotal(numAsientos.get(i));
            Pasaje pasaje = bus.comprarPasaje(numAsientos.get(i), precioTotal);
            pasaje.setDatos(nombre, apellido, rut);
            pasajes.add(pasaje);
            pasaje.generarPasajeTxt();
        }
    }

}
