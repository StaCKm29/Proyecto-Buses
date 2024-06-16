package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeleccionDeBus extends JPanel {
    private JPanel panelActual;

    public SeleccionDeBus(ArrayList<Bus> buses) {
        setLayout(new FlowLayout());

        this.panelActual = new JPanel();
        JList<Bus> busesDisponibles = new JList<>(buses.toArray(new Bus[0]));

        JButton seleccionar = new JButton("Seleccionar");
        seleccionar.addActionListener(e -> {
            Bus bus = busesDisponibles.getSelectedValue();
            JOptionPane.showMessageDialog(this, "Bus seleccionado: " + bus);
            /*
            // Crea un nuevo panel
            SeleccionDeAsiento nuevaVentana = new SeleccionDeAsiento();

            // Remueve el panel actual y agrega el nuevo
            this.panelActual.removeAll();
            this.panelActual.add(nuevaVentana);
            this.panelActual.revalidate();
            this.panelActual.repaint();*/
        });

        //add(busesDisponibles);
        add(panelActual);
        add(new JScrollPane(busesDisponibles));
        add(seleccionar);
    }

    public static void main(String args[]) throws MismaLocalidadException, LocalidadNullException {
        JFrame frame = new JFrame("Seleccion de Bus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        CrearRecorrido recorrido = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.SANTIAGO, LocalDate.now());

        SeleccionDeBus seleccionDeBus = new SeleccionDeBus(recorrido.getBuses());
        frame.add(seleccionDeBus);

        frame.setVisible(true);
    }
}
