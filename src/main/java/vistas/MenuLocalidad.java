package vistas;

import modelos.Localidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * Clase MenuLocalidad que se utilizará para seleccionar el origen o destino de un recorrido.
 */
public class MenuLocalidad extends JPanel implements ItemListener {
    private Choice opciones;
    private Localidades localidad;

    /**
     * Constructor de la clase MenuLocalidad
     */
    public MenuLocalidad(String titulo) {
        JLabel nombre = new JLabel(titulo);
        add(nombre);
        opciones = new Choice();
        opciones.add("Seleccione una localidad");
        opciones.add("Frutillar");
        opciones.add("Concepción");
        opciones.add("Chillán");
        opciones.add("Santiago");

        opciones.addItemListener(this);

        add(opciones);
    }

    /**
     * Metodo que mantiene actualizada la localidad de origen o destino.
     * @param e Evento que se activa al seleccionar un choice.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == opciones) {
            String seleccion = opciones.getSelectedItem();
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
     * @throws LocalidadesNullException Excepción que se lanza si no se ha seleccionado una localidad.
     */
    public Localidades getLocalidad() throws LocalidadesNullException {
        if(localidad == null) {
            throw new LocalidadesNullException("No se ha seleccionado una localidad.");
        }
        return localidad;
    }
}
