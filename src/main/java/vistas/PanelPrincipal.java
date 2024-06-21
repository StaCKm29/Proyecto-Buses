package vistas;

import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PanelUno panelUno;
    private SeleccionDeAsiento seleccionDeAsiento;
    public PanelPrincipal() throws MismaLocalidadException, LocalidadNullException {
        panelUno = new PanelUno();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        //"Las pestañas" en las que se va a manejar el software
        //1) buscar viajes(buses) dependiendo del origen y destino.
        //2) seleccionar asientos del bus seleccionado y a la vez comprar los pasajes.
        cardPanel.add(panelUno, "Buscador");
        cardPanel.add(seleccionDeAsiento, "Seleccion De Asientos");

        //El primero en mostrarse al correr el programa
        cardLayout.show(cardPanel, "Buscador");
        panelUno.getBuscar().addActionListener(e -> {
            cardLayout.show(cardPanel, "seleccionDeAsiento");
        });

        seleccionDeAsiento.getBotonCompra().addActionListener(e -> {
            cardLayout.show(cardPanel,"Buscador");
        });
    }

    /**
     * metodo para boton de seleccionar
     * al momento en que se presiona el boton buscar, se cambia de panel
     * aqui se deberia hacer new de seleccion deasiento
     * por lo tanto, dentro debe estar cardLayout.show(cardPanel, "Seleccion De Asientos");
     */
    private void seleccionarBus(){
        cardLayout.show(cardPanel, "Seleccion De Asientos");
    }

    /**
     * un metodo para el boton comprar, ya que al ser presionado, se debe cambiar de panel
     * por lo tanto, dentro debe estar cardLayout.show(cardPanel, "Buscador");
     */

}
