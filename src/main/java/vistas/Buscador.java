package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
/**
 * Clase Buscador que se utilizará para seleccionar el origen y destino de un recorrido
 */
public class Buscador extends JPanel {
    private JButton buscar;
    private JButton seleccionar;
    private SeleccionDeBus seleccionDeBus;
    private CrearRecorrido recorrido;
    private MenuLocalidad menuOrigen;
    private MenuLocalidad menuDestino;
    private Bus busSeleccionado;
    private CambioPanelListener listener;

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
     * Constructor de la clase Buscador.
     * @param listener Listener que se encargará de cambiar de panel.
     */
    public Buscador(CambioPanelListener listener) {
        this.listener = listener;
        setLayout(new FlowLayout());

        buscar = new JButton("Buscar");
        menuOrigen = new MenuLocalidad("Origen");
        menuDestino = new MenuLocalidad("Destino");
        seleccionar = new JButton("Seleccionar");
        seleccionar.addActionListener(e -> listener.cambiarASeleccionAsiento());

        add(menuOrigen);
        add(menuDestino);
        add(buscar);

        configActionListener();
    }

    /**
     * Método que configura los ActionListener de los botones y asi no hacerlo dentro del constructor
     */
    private void configActionListener() {
        buscar.addActionListener(e -> {
            Localidades origen = null;
            Localidades destino = null;

            try {
                origen = menuOrigen.getLocalidad();
                destino = menuDestino.getLocalidad();
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
            add(seleccionar);
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
}
