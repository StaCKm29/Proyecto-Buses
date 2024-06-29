package vistas;

import javax.swing.*;
import java.awt.*;
/**
 * Clase PanelPrincipal que se utilizará para manejar los paneles de la aplicación.
 * Cambia desde Panel Buscador a SeleccionDeAsiento y viciversa.
 */
public class PanelPrincipal extends JPanel implements CambioPanelListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Buscador panelUno;
    private SeleccionDeAsiento seleccionDeAsiento;

    /**
     * Constructor de la clase PanelPrincipal
     */
    public PanelPrincipal() {
        setLayout(new BorderLayout());
        panelUno = new Buscador(this);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        //"Las pestañas" en las que se va a manejar el software
        //1) buscar viajes(buses) dependiendo del origen y destino.
        //2) seleccionar asientos del bus seleccionado y a la vez comprar los pasajes.
        cardPanel.add(panelUno, "Buscador");

        add(cardPanel, BorderLayout.CENTER);

        //El primero en mostrarse al correr el programa
        cardLayout.show(cardPanel, "Buscador");
    }

    /**
     * Método que cambia el panel a la selección de asientos.
     */
    @Override
    public void cambiarASeleccionAsiento() {
        seleccionDeAsiento = new SeleccionDeAsiento(panelUno.getBusSeleccionado(), this);
        cardPanel.add(seleccionDeAsiento, "Seleccion De Asientos");
        cardLayout.show(cardPanel, "Seleccion De Asientos");
    }

    /**
     * Método que cambia el panel al buscador.
     */
    @Override
    public void volverABuscador() {
        cardLayout.show(cardPanel, "Buscador");
    }
}
