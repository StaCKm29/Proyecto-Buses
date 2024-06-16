package vistas;

import modelos.Asiento;
import modelos.Bus;

import javax.swing.*;
import java.util.ArrayList;

public class SeleccionDeAsiento extends JPanel {
    private ArrayList<Asiento> AsientosDelBus;
    public SeleccionDeAsiento(Bus busSeleccionado) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Hay que evaluar si el bus es de un piso o de dos pisos
        //Asi saber como llamar al metodo de bus.getAsientos(1 0 2)
        //Si es de un piso, se debe mostrar un solo panel con los asientos
        //Si es de dos pisos, se deben mostrar dos paneles con los asientos
        if(busSeleccionado.getClass() == modelos.UnPiso.class) {
            AsientosDelBus = busSeleccionado.getAsientos(1);
            for (Asiento asiento : AsientosDelBus) {
                add(new JButton("Asiento " + asiento.getNumero()));
            }
        } else {

        }


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccion de Asiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        frame.setVisible(true);
    }
}
