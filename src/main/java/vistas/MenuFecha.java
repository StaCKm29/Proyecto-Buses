package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

public class MenuFecha extends JPanel implements ItemListener {
    private Choice fechaViaje;
    private LocalDate fechaEscogida;

    public MenuFecha() {
        JLabel fecha = new JLabel("Fecha:");
        add(fecha);

        fechaViaje = new Choice();
        LocalDate fechaActual = LocalDate.now();
        int ultimoDia = fechaActual.lengthOfMonth();

        for (int dia = fechaActual.getDayOfMonth(); dia <= ultimoDia; dia++) {
            fechaViaje.add(LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), dia).toString());
        }

        fechaViaje.addItemListener(this);
        add(fechaViaje);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public LocalDate getFecha() {
        return LocalDate.parse(fechaViaje.getSelectedItem());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Fecha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        MenuFecha menuFecha = new MenuFecha();
        frame.add(menuFecha);

        frame.setVisible(true);
    }

}
