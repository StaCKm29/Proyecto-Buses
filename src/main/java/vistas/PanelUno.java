package vistas;

import modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
/**
 * Clase PanelUno que se utilizará para seleccionar el origen y destino de un recorrido
 */
public class PanelUno extends JPanel {
    private JButton buscar;
    private JButton seleccionar;
    private SeleccionDeBus seleccionDeBus;
    private CrearRecorrido recorrido;
    private MenuOrigen menuOrigen;
    private MenuDestino menuDestino;
    private Bus busSeleccionado;
    private CambioPanelListener listener;
    private Image imagenFondo;

    private CrearRecorrido fruti_chillan = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.CHILLAN, LocalDate.now());
    private CrearRecorrido chillan_fruti = new CrearRecorrido(Localidades.CHILLAN, Localidades.FRUTILLAR, LocalDate.now());
    private CrearRecorrido fruti_conce = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.CONCEPCION, LocalDate.now());
    private CrearRecorrido conce_fruti = new CrearRecorrido(Localidades.CONCEPCION, Localidades.FRUTILLAR, LocalDate.now());
    private CrearRecorrido fruti_santi = new CrearRecorrido(Localidades.FRUTILLAR, Localidades.SANTIAGO, LocalDate.now());
    private CrearRecorrido santi_fruti = new CrearRecorrido(Localidades.SANTIAGO, Localidades.FRUTILLAR, LocalDate.now());
    private CrearRecorrido chillan_conce = new CrearRecorrido(Localidades.CHILLAN, Localidades.CONCEPCION, LocalDate.now());
    private CrearRecorrido conce_chillan = new CrearRecorrido(Localidades.CONCEPCION, Localidades.CHILLAN, LocalDate.now());
    private CrearRecorrido chillan_santi = new CrearRecorrido(Localidades.CHILLAN, Localidades.SANTIAGO, LocalDate.now());
    private CrearRecorrido santi_chillan = new CrearRecorrido(Localidades.SANTIAGO, Localidades.CHILLAN, LocalDate.now());
    private CrearRecorrido conce_santi = new CrearRecorrido(Localidades.CONCEPCION, Localidades.SANTIAGO, LocalDate.now());
    private CrearRecorrido santi_conce = new CrearRecorrido(Localidades.SANTIAGO, Localidades.CONCEPCION, LocalDate.now());
    /**
     * Constructor de la clase PanelUno
     * @param listener Listener que se encargará de cambiar de panel
     */
    public PanelUno(CambioPanelListener listener) {
        this.listener = listener;
        setLayout(new FlowLayout());

        buscar = new JButton("Buscar");
        menuOrigen = new MenuOrigen();
        menuDestino = new MenuDestino();
        seleccionar = new JButton("Seleccionar");
        seleccionar.addActionListener(e -> listener.cambiarASeleccionAsiento());

        add(menuOrigen);
        add(menuDestino);
        add(buscar);
        add(seleccionar);
        try {
            imagenFondo = ImageIO.read(getClass().getResource("/imagenFondo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configActionListener();
    }
    /**
     * Método que configura los action listener de los botones y asi no hacerlo dentro del constructor
     */
    private void configActionListener() {
        buscar.addActionListener(e -> {
            Localidades origen = null;
            Localidades destino = null;

            try {
                origen = menuOrigen.getOrigen();
                destino = menuDestino.getDestino();
                if (origen == destino){
                    throw new MismasLocalidadesException("El origen y el destino no pueden ser la misma localidad");
                }
            } catch (LocalidadesNullException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (MismasLocalidadesException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

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

            if(seleccionDeBus!=null){
                remove(seleccionDeBus);
            }

            seleccionDeBus = new SeleccionDeBus(recorrido.getBuses());
            add(seleccionDeBus);
            revalidate();
            repaint();
        });

        seleccionar.addActionListener(e -> {
            try {
                busSeleccionado = seleccionDeBus.getBusSeleccionado();
            } catch (BusSeleccionadoNullException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    /**
     * Método que retorna el bus seleccionado
     * @return Bus seleccionado
     */
    public Bus getBusSeleccionado() {
        return busSeleccionado;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}
