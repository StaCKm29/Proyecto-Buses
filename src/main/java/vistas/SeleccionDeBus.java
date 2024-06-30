package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Clase SeleccionDeBus que se utilizará para seleccionar un bus
 */
public class SeleccionDeBus extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JList<Bus> busesDisponibles;

    /**
     * Constructor de la clase SeleccionDeBus
     * @param buses Lista de buses acorde a un recorrido especifico.
     */
    public SeleccionDeBus(ArrayList<Bus> buses) {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Panel de Selección de Bus
        JPanel panelSeleccionDeBus = new JPanel(new BorderLayout());

        busesDisponibles = new JList<>(buses.toArray(new Bus[0]));
        panelSeleccionDeBus.add(new JScrollPane(busesDisponibles), BorderLayout.CENTER);

        // Añadir panel de selección de bus al cardPanel
        cardPanel.add(panelSeleccionDeBus, "SeleccionDeBus");

        // Añadir el cardPanel al SeleccionDeBus
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    /**
     * Método que retorna el bus seleccionado.
     * @return Bus seleccionado.
     * @throws BusSeleccionadoNullException Excepción que se lanza si no se ha seleccionado un bus.
     */
    public Bus getBusSeleccionado() throws BusSeleccionadoNullException {
        if (busesDisponibles.getSelectedValue() == null) {
            throw new BusSeleccionadoNullException("No se ha seleccionado un bus.");
        }
        return busesDisponibles.getSelectedValue();
    }
}
