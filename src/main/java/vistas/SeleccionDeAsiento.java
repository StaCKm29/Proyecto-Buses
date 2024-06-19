package vistas;

import modelos.Asiento;
import modelos.Bus;
import modelos.TipoAsiento;
import modelos.UnPiso;

import javax.swing.*;
import java.util.ArrayList;

public class SeleccionDeAsiento extends JPanel {
    private ArrayList<Asiento> AsientosDelBus;

        public SeleccionDeAsiento(Bus busSeleccionado) {
            /*
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

            AsientosDelBus = busSeleccionado.getAsientos(1);
            int half = (AsientosDelBus.size() + 1) / 2; // Si el número de asientos es impar, el primer arreglo tendrá un asiento más que el segundo

            for (int i = 0; i < half; i++) {
                ImageAsiento asiento = new ImageAsiento(AsientosDelBus.get(i));
                asiento.setBounds(0,0,20,20);
                panel1.add(asiento);
            }
            for (int i = half; i < AsientosDelBus.size(); i++) {
                ImageAsiento asiento = new ImageAsiento(AsientosDelBus.get(i));
                asiento.setBounds(0,0,20,20);
                panel2.add(asiento);
            }
            add(new JLabel("Piso 1"));

             */
        }

        // Resto del código...

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
