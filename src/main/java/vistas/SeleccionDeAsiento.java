package vistas;

import modelos.Asiento;
import modelos.Bus;
import modelos.TipoAsiento;
import modelos.UnPiso;

import javax.swing.*;
import java.util.ArrayList;

public class SeleccionDeAsiento extends JPanel {
    private ArrayList<Asiento> asientosDelBus;
    private AsientosEnUnPiso pisoUno;
    private AsientosEnUnPiso pisoDos;

    public SeleccionDeAsiento(Bus bus) {
        if(bus.getClass() == UnPiso.class) {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus);
            add(pisoUno);
            pisoDos = null;
        } else {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus);
            asientosDelBus = bus.getAsientos(2);
            pisoDos = new AsientosEnUnPiso(asientosDelBus);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccion de Asiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        Bus bus = new UnPiso(2000, TipoAsiento.SEMICAMA);
        SeleccionDeAsiento seleccionDeAsiento = new SeleccionDeAsiento(bus);

        frame.add(seleccionDeAsiento);

        frame.setVisible(true);
    }
}
