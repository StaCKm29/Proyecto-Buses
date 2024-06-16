package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Buscador extends JPanel {
    private MenuOrigen origen;
    private MenuDestino destino;
    private CrearRecorrido recorrido;

    public Buscador(){
        setLayout(new FlowLayout());

        origen = new MenuOrigen();
        destino = new MenuDestino();

        add(origen);
        add(destino);
    }

    public ArrayList<Bus> getBuses() {
        return recorrido.getBuses();
    }
    public Localidades getOrigen() {
        return origen.getOrigen();
    }
    public Localidades getDestino() {
        return destino.getDestino();
    }

    public static void main(String[] args) {
        // Configurar el JFrame
        JFrame frame = new JFrame("Buscador de Recorridos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Crear una instancia de Buscador y agregarla al JFrame
        Buscador buscador = new Buscador();

        frame.add(buscador);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}
