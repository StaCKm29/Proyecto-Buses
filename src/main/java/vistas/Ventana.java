package vistas;

import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.swing.*;
import java.awt.*;
/**
 * Clase Ventana que se utilizará para mostrar la interfaz gráfica
 */
public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;
    /**
     * Constructor de la clase Ventana
     * @throws MismaLocalidadException
     * @throws LocalidadNullException
     */
    public Ventana() throws MismaLocalidadException, LocalidadNullException {
        setLayout(new BorderLayout());
        panelPrincipal = new PanelPrincipal();
        add(panelPrincipal, BorderLayout.CENTER);
        this.setTitle("Ventana");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
