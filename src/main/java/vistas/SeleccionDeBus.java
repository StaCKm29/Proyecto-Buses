package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Clase SeleccionDeBus que se utilizará para seleccionar un bus
 */
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

        // Añadir el cardPanel al SeleccionDeBus
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }
    /**
     * Método que retorna el bus seleccionado
     * @return Bus seleccionado
     */
    public Bus getBusSeleccionado() throws BusSeleccionadoNull{
        if (busesDisponibles.getSelectedValue() == null) {
            throw new BusSeleccionadoNull("No se ha seleccionado un bus.");
        }
        return busesDisponibles.getSelectedValue();
    }
}
