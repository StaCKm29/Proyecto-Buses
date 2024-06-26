package vistas;

import modelos.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * Clase SeleccionDeAsiento que se utilizará para seleccionar los asientos de un bus
 */
public class SeleccionDeAsiento extends JPanel {
    private ArrayList<Asiento> asientosDelBus;
    private ArrayList<Integer> asientosSeleccionados = new ArrayList<>();
    private AsientosEnUnPiso pisoUno;
    private AsientosEnUnPiso pisoDos;
    private DatosPersonales datosPersonales;
    private JButton botonCompra;
    private Cliente cliente;
    private Bus bus;
    private CambioPanelListener listener;
    /**
     * Constructor de la clase SeleccionDeAsiento
     * @param bus Bus a seleccionar asientos
     * @param listener Listener que se encargará de cambiar de panel
     */
    public SeleccionDeAsiento(Bus bus, CambioPanelListener listener) {
        this.listener = listener;
        this.bus = bus;

        this.botonCompra = new JButton("COMPRAR");
        botonCompra.addActionListener(e -> {
            
            comprarPasajes();
            listener.volverABuscador();
            JOptionPane.showMessageDialog(this, "Compra realizada con exito", "Compra", JOptionPane.INFORMATION_MESSAGE);
        });

        datosPersonales = new DatosPersonales();

        add(botonCompra);
        add(datosPersonales);

        if (bus.getClass() == UnPiso.class) {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus, "Piso 1");
            add(pisoUno);
        } else {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus, "Piso 1");
            asientosDelBus = bus.getAsientos(2);
            pisoDos = new AsientosEnUnPiso(asientosDelBus, "Piso 2");
            add(pisoUno);
            add(pisoDos);
        }
        botonCompra.addActionListener(e -> comprarPasajes());

    }

    /**
     * Método que se encarga de comprar los pasajes
     */
    private void comprarPasajes() {
        if (bus.getClass() == UnPiso.class) {
            asientosSeleccionados.addAll(pisoUno.getAsientosSeleccionados());
        } else {
            asientosSeleccionados.addAll(pisoUno.getAsientosSeleccionados());
            asientosSeleccionados.addAll(pisoDos.getAsientosSeleccionados());
        }
        cliente = new Cliente(datosPersonales.getNombre(), datosPersonales.getApellido(), datosPersonales.getRut(), bus, asientosSeleccionados);
        if (bus.getClass() == UnPiso.class) {
            pisoUno.actualizarAsientos();
        } else {
            pisoUno.actualizarAsientos();
            pisoDos.actualizarAsientos();
        }
        revalidate();
        repaint();
    }

}


