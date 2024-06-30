package vistas;

import modelos.Asiento;
import modelos.Bus;
import modelos.UnPiso;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Clase MenuInformacion que se utilizará para mostrar informacion relevante sobre la cantidad de asientos y el monto a pagar.
 */
public class MenuInformacion extends JPanel{
    private JLabel asientosTotales;
    private JLabel asientosDisponibles;
    private JLabel asientosSeleccionadosContador;
    private JLabel montoTotal;
    private ArrayList<Asiento> asientos = new ArrayList<>();
    private Bus bus;
    private ArrayList<AsientosEnUnPiso> arregloPisos;
    /**
     * Constructor de la clase MenuInformacion.
     * @param bus Bus a mostrar información.
     * @param arregloPisos ArrayList de AsientosEnUnPiso.
     */
    public MenuInformacion(Bus bus, ArrayList<AsientosEnUnPiso> arregloPisos){
        this.bus = bus;
        if(bus.getClass()== UnPiso.class){
            asientos.addAll(bus.getAsientos(1));
        }
        else{
            asientos.addAll(bus.getAsientos(1));
            asientos.addAll(bus.getAsientos(2));
        }
        this.arregloPisos = arregloPisos;
        asientosTotales = new JLabel("Asientos Totales: ");
        asientosDisponibles = new JLabel("Asientos Disponibles: ");
        asientosSeleccionadosContador = new JLabel("Asientos Seleccionados: ");
        montoTotal = new JLabel("Monto Total: ");
        setLayout(new GridLayout(4, 1));
        add(asientosTotales);
        add(asientosDisponibles);
        add(asientosSeleccionadosContador);
        add(montoTotal);
        actualizarInformacion();
    }
    /**
     * Método que actualiza la información de los asientos.
     */
    public void actualizarInformacion(){

        // Actualizar la información de los asientos Totales
        asientosTotales.setText("Asientos Totales: " + asientos.size());
        int aux = 0;
        for(Asiento asiento: asientos){
            if(asiento.getEstado()!=true){
                aux++;
            }
        }
        // Actualizar la información de los asientos Disponibles
        asientosDisponibles.setText("Asientos Disponibles: " + aux);

        // Actualizar la información de los asientos Seleccionados
        ArrayList<Integer> asientosSeleccionados = new ArrayList<>();
        for(AsientosEnUnPiso piso: arregloPisos){
            asientosSeleccionados.addAll(piso.getAsientosSeleccionados());
        }
        asientosSeleccionadosContador.setText("Asientos Seleccionados: " + asientosSeleccionados.size());
        aux= 0;
        for(Integer i: asientosSeleccionados){
            aux = aux + bus.getPrecioTotal(i);
        }
        montoTotal.setText("Monto Total: " + aux);
    }

    /**
     * Método que retorna el bus.
     * @return Bus.
     */
    public Bus getBus(){
        return bus;
    }
}
