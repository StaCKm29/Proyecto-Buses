package vistas;

import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.swing.*;

public class Ventana extends JFrame {
    private PanelUno panelUno = new PanelUno();

    public Ventana() throws MismaLocalidadException, LocalidadNullException {
        add(panelUno);

        this.setTitle("Ventana");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
