package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeleccionDeBus extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JList<Bus> busesDisponibles;

    public SeleccionDeBus(ArrayList<Bus> buses) {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Panel de Selección de Bus
        JPanel panelSeleccionDeBus = new JPanel(new BorderLayout());

        busesDisponibles = new JList<>(buses.toArray(new Bus[0]));
       // JButton seleccionar = new JButton("Seleccionar");

        panelSeleccionDeBus.add(new JScrollPane(busesDisponibles), BorderLayout.CENTER);
        //panelSeleccionDeBus.add(seleccionar, BorderLayout.SOUTH);

        // Añadir panel de selección de bus al cardPanel
        cardPanel.add(panelSeleccionDeBus, "SeleccionDeBus");

        // Añadir ActionListener al botón de selección
/*        seleccionar.addActionListener(e -> {
            Bus bus = busesDisponibles.getSelectedValue();
            if (bus != null) {
                SeleccionDeAsiento seleccionDeAsiento = new SeleccionDeAsiento(bus);
                cardPanel.add(seleccionDeAsiento, "SeleccionDeAsiento");
                cardLayout.show(cardPanel, "SeleccionDeAsiento");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un bus primero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });*/

        // Añadir el cardPanel al SeleccionDeBus
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    public Bus getBusSeleccionado() {
        return busesDisponibles.getSelectedValue();
    }

    public static void main(String[] args) throws MismaLocalidadException, LocalidadNullException {
        JFrame frame = new JFrame("Seleccion de Bus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        CrearRecorrido recorrido = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.SANTIAGO, LocalDate.now());

        SeleccionDeBus seleccionDeBus = new SeleccionDeBus(recorrido.getBuses());
        frame.add(seleccionDeBus);

        frame.setVisible(true);
    }
}
