package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeleccionDeBus extends JPanel {

    public SeleccionDeBus(ArrayList<Bus> buses) {
        setLayout(new FlowLayout());

        JList<Bus> busesDisponibles = new JList<>(buses.toArray(new Bus[0]));
        //JComboBox<Bus> busesDisponibles = new JComboBox<>();
        //buses.forEach(busesDisponibles::addItem);

        JButton seleccionar = new JButton("Seleccionar");
        seleccionar.addActionListener(e -> {
            Bus bus = (Bus) busesDisponibles.getSelectedValue();
            JOptionPane.showMessageDialog(this, "Bus seleccionado: " + bus);
        });

        //add(busesDisponibles);
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
