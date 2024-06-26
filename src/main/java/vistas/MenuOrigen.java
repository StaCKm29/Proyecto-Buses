package vistas;

import modelos.LocalidadNullException;
import modelos.Localidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuOrigen extends JPanel implements ItemListener {
    private Choice origen;
    private Localidades localidad;

    public MenuOrigen() {
        JLabel nombre = new JLabel("Origen: ");
        add(nombre);
        origen = new Choice();

        origen.add("Frutillar");
        origen.add("Concepción");
        origen.add("Chillán");
        origen.add("Santiago");

        origen.addItemListener(this);

        add(origen);
    }

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
    public Localidades getOrigen() throws LocalidadesNullException {
        if(localidad == null) {
            throw new LocalidadesNullException("No se ha seleccionado una localidad de origen");
        }
        return localidad;
    }
}
