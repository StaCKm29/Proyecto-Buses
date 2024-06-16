package vistas;

import modelos.CrearRecorrido;
import modelos.LocalidadNullException;
import modelos.MismaLocalidadException;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class PanelUno extends JPanel {
    private JButton buscar;
    private SeleccionDeBus seleccionDeBus;
    private CrearRecorrido recorrido;
    private MenuOrigen menuOrigen;
    private MenuDestino menuDestino;
    private MenuFecha menuFecha;

    public PanelUno() {
        setLayout(new FlowLayout());

        buscar = new JButton("Buscar");
        menuOrigen = new MenuOrigen();
        menuDestino = new MenuDestino();
        menuFecha = new MenuFecha();

        add(menuOrigen);
        add(menuDestino);
        add(menuFecha);
        add(buscar);

        configureActionListeners();
    }
    private void configureActionListeners() {
        buscar.addActionListener(e -> {
            try {
                recorrido = new CrearRecorrido(menuOrigen.getOrigen(), menuDestino.getDestino(), menuFecha.getFecha());
                seleccionDeBus = new SeleccionDeBus(recorrido.getBuses());
                add(buscar);
                add(seleccionDeBus);
                revalidate();
                repaint();
            } catch (MismaLocalidadException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            } catch (LocalidadNullException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        PanelUno panelUno = new PanelUno();
        frame.add(panelUno);

        frame.setVisible(true);
    }
}
