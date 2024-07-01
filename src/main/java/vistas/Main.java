/**
 * Proyecto que simula la compra/venta de pasajes de buses
 * @author: Gabriel Castillo Castillo
 * @author: Marcos Martínez Rojas
 * @version: 1.0
 */
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
