package vistas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase Ventana que se utilizará para mostrar la interfaz gráfica
 */
public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;
    /**
     * Constructor de la clase Ventana
     * @throws MismasLocalidadesException
     */
    public Ventana() throws MismasLocalidadesException {
        setLayout(new BorderLayout());
        panelPrincipal = new PanelPrincipal();
        add(panelPrincipal, BorderLayout.CENTER);
        setContentPane(panelPrincipal);
        this.setTitle("Ventana");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
