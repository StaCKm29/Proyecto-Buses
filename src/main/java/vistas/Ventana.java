package vistas;

import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;


    public Ventana() throws MismaLocalidadException, LocalidadNullException, MismasLocalidadesException {
        setLayout(new BorderLayout());
        panelPrincipal = new PanelPrincipal();
        add(panelPrincipal, BorderLayout.CENTER);
        setContentPane(panelPrincipal);
        this.setTitle("Ventana");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
