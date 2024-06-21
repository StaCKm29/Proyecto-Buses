package vistas;

import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel implements CambioPanelListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PanelUno panelUno;
    private SeleccionDeAsiento seleccionDeAsiento;

    public PanelPrincipal() throws MismaLocalidadException, LocalidadNullException {
        setLayout(new BorderLayout());
        panelUno = new PanelUno(this);

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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Sistema de Reserva de Buses");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);

                PanelPrincipal panelPrincipal = new PanelPrincipal();
                frame.getContentPane().add(panelPrincipal);

                frame.setVisible(true);
            } catch (MismaLocalidadException | LocalidadNullException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @Override
    public void cambiarASeleccionAsiento() {
        seleccionDeAsiento = new SeleccionDeAsiento(panelUno.getBusSeleccionado(), this);
        cardPanel.add(seleccionDeAsiento, "Seleccion De Asientos");
        cardLayout.show(cardPanel, "Seleccion De Asientos");
    }

    @Override
    public void volverABuscador() {
        cardLayout.show(cardPanel, "Buscador");
    }
}
