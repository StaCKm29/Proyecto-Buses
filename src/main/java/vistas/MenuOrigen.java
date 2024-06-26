package vistas;

import modelos.LocalidadNullException;
import modelos.Localidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 * Clase MenuOrigen que se utilizará para seleccionar el origen de un recorrido
 */
public class MenuOrigen extends JPanel implements ItemListener {
    private Choice origen;
    private Localidades localidad;
    /**
     * Constructor de la clase MenuOrigen
     */
    public MenuOrigen() {
        JLabel nombre = new JLabel("Origen: ");
        add(nombre);
        origen = new Choice();
        origen.add("Seleccione una localidad");
        origen.add("Frutillar");
        origen.add("Concepción");
        origen.add("Chillán");
        origen.add("Santiago");

        origen.addItemListener(this);

        add(origen);
    }

    /**
     * Metodo que mantiene actualizada la localidad de origen
     * @param e Evento que se activa al seleccionar un choice
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == origen) {
            String seleccion = origen.getSelectedItem();
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
    public Localidades getOrigen() throws LocalidadesNullException {
        if(localidad == null) {
            throw new LocalidadesNullException("No se ha seleccionado una localidad de origen");
        }
        return localidad;
    }
}
