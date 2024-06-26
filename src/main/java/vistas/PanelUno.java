package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
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
     * @throws MismaLocalidadException
     * @throws LocalidadNullException
     */
    public PanelUno(CambioPanelListener listener) throws MismaLocalidadException, LocalidadNullException {
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

        configActionListener();
    }
    /**
     * Método que configura los action listener de los botones y asi no hacerlo dentro del constructor
     */
    private void configActionListener() {
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
            if(seleccionDeBus!=null){
                remove(seleccionDeBus);
            }
            seleccionDeBus = new SeleccionDeBus(recorrido.getBuses());
            add(seleccionDeBus);
            revalidate();
            repaint();
        });

        seleccionar.addActionListener(e -> {
            busSeleccionado = seleccionDeBus.getBusSeleccionado();
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
