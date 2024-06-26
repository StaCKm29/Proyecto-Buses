package vistas;

import modelos.Localidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * Clase MenuDestino que se utilizará para seleccionar el destino de un recorrido
 */
public class MenuDestino extends JPanel implements ItemListener {
    private Choice destino;
    private Localidades localidad;
    /**
     * Constructor de la clase MenuDestino
     */
    public MenuDestino() {
        JLabel nombre = new JLabel("Destino: ");
        add(nombre);
        destino = new Choice();
        destino.add("Seleccione una localidad");
        destino.add("Frutillar");
        destino.add("Concepción");
        destino.add("Chillán");
        destino.add("Santiago");

        destino.addItemListener(this);

        add(destino);
    }

    /**
     * Metodo que mantiene actualizada la localidad de destino
     * @param e Evento que se activa al seleccionar un choice
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == destino) {
            String seleccion = destino.getSelectedItem();
            switch(seleccion) {
                case "Frutillar":
                    localidad = Localidades.FRUTILLAR;
                    break;
                case "Concepción":
                    localidad = Localidades.CONCEPCION;
                    break;
                case "Chillán":
                    localidad = Localidades.CHILLAN;
                    break;
                case "Santiago":
                    localidad = Localidades.SANTIAGO;
                    break;
            }
        }
    }
    /**
     * Método que retorna la localidad seleccionada
     * @return Localidad seleccionada
     */
    public Localidades getDestino() {
        return localidad;
    }
}