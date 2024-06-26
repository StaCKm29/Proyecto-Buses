package vistas;

import modelos.Localidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuDestino extends JPanel implements ItemListener {
    private Choice destino;
    private Localidades localidad;

    public MenuDestino() {
        JLabel nombre = new JLabel("Destino: ");
        add(nombre);
        destino = new Choice();

        destino.add("Frutillar");
        destino.add("Concepción");
        destino.add("Chillán");
        destino.add("Santiago");

        destino.addItemListener(this);

        add(destino);
    }

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

    public Localidades getDestino() throws LocalidadesNullException {
        if(localidad == null) {
            throw new LocalidadesNullException("No se ha seleccionado una localidad de destino");
        }
        return localidad;
    }
}