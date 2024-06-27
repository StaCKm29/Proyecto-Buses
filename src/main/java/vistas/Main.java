package vistas;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Ventana();
            } catch (MismasLocalidadesException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
