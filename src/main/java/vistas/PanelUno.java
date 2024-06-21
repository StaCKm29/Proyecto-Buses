package vistas;

import modelos.CrearRecorrido;
import modelos.LocalidadNullException;
import modelos.Localidades;
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

    private CrearRecorrido fruti_chillan;
    private CrearRecorrido chillan_fruti;
    private CrearRecorrido fruti_conce;
    private CrearRecorrido conce_fruti;
    private CrearRecorrido fruti_santi;
    private CrearRecorrido santi_fruti;
    private CrearRecorrido chillan_conce;
    private CrearRecorrido conce_chillan;
    private CrearRecorrido chillan_santi;
    private CrearRecorrido santi_chillan;
    private CrearRecorrido conce_santi;
    private CrearRecorrido santi_conce;

    public PanelUno() {
        setLayout(new FlowLayout());

        try {
            fruti_chillan = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.CHILLAN, LocalDate.now());
            chillan_fruti = new CrearRecorrido(Localidades.CHILLAN, Localidades.FRUTILLAR, LocalDate.now());
            fruti_conce = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.CONCEPCION, LocalDate.now());
            conce_fruti = new CrearRecorrido(Localidades.CONCEPCION, Localidades.FRUTILLAR, LocalDate.now());
            fruti_santi = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.SANTIAGO, LocalDate.now());
            santi_fruti = new CrearRecorrido(Localidades.SANTIAGO, Localidades.FRUTILLAR, LocalDate.now());
            chillan_conce = new CrearRecorrido(Localidades.CHILLAN, Localidades.CONCEPCION, LocalDate.now());
            conce_chillan = new CrearRecorrido(Localidades.CONCEPCION, Localidades.CHILLAN, LocalDate.now());
            chillan_santi = new CrearRecorrido(Localidades.CHILLAN, Localidades.SANTIAGO, LocalDate.now());
            santi_chillan = new CrearRecorrido(Localidades.SANTIAGO, Localidades.CHILLAN, LocalDate.now());
            conce_santi = new CrearRecorrido(Localidades.CONCEPCION, Localidades.SANTIAGO, LocalDate.now());
            santi_conce = new CrearRecorrido(Localidades.SANTIAGO, Localidades.CONCEPCION, LocalDate.now());
        } catch (MismaLocalidadException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (LocalidadNullException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        buscar = new JButton("Buscar");
        menuOrigen = new MenuOrigen();
        menuDestino = new MenuDestino();

        add(menuOrigen);
        add(menuDestino);
        add(buscar);

        configureActionListeners();
    }

    private void configureActionListeners() {
        buscar.addActionListener(e -> {
            Localidades origen = menuOrigen.getOrigen();
            Localidades destino = menuDestino.getDestino();
            switch (origen) {
                case FRUTILLAR -> {
                    switch (destino) {
                        case CHILLAN -> recorrido = fruti_chillan;
                        case CONCEPCION -> recorrido = fruti_conce;
                        case SANTIAGO -> recorrido = fruti_santi;
                    }
                }
                case CHILLAN -> {
                    switch (destino) {
                        case FRUTILLAR -> recorrido = chillan_fruti;
                        case CONCEPCION -> recorrido = chillan_conce;
                        case SANTIAGO -> recorrido = chillan_santi;
                    }
                }
                case CONCEPCION -> {
                    switch (destino) {
                        case FRUTILLAR -> recorrido = conce_fruti;
                        case CHILLAN -> recorrido = conce_chillan;
                        case SANTIAGO -> recorrido = conce_santi;
                    }
                }
                case SANTIAGO -> {
                    switch (destino) {
                        case FRUTILLAR -> recorrido = santi_fruti;
                        case CHILLAN -> recorrido = santi_chillan;
                        case CONCEPCION -> recorrido = santi_conce;
                    }
                }
            }
            seleccionDeBus = new SeleccionDeBus(recorrido.getBuses());
            add(seleccionDeBus);
            revalidate();
            repaint();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ventana");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            try {
                PanelUno panelUno = new PanelUno();
                frame.add(panelUno);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al inicializar el panel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            frame.setVisible(true);
        });
    }
}
