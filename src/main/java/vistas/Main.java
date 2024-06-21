package vistas;

import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws MismaLocalidadException, LocalidadNullException {
        SwingUtilities.invokeLater(() -> {
            try {
                new Ventana();
            } catch (MismaLocalidadException | LocalidadNullException e) {
                e.printStackTrace();
            }
        });
    }
}
