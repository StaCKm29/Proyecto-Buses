package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Buscador extends JPanel {
    private JButton buscar;
    private MenuOrigen origen;
    private MenuDestino destino;
    private CrearRecorrido recorrido;

    public Buscador(){
        setLayout(new FlowLayout());

        origen = new MenuOrigen();
        destino = new MenuDestino();
        buscar = new JButton("Buscar");

        buscar.addActionListener(e -> {
            Localidades origen = this.origen.getLocalidad();
            Localidades destino = this.destino.getLocalidad();
            try {
                recorrido = new CrearRecorrido(origen, destino, LocalDate.now());
                JOptionPane.showMessageDialog(this, "Recorrido creado con éxito.");
            } catch(LocalidadNullException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            } catch (MismaLocalidadException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(origen);
        add(destino);
        add(buscar);
    }

    public ArrayList<Bus> getBuses() {
        return recorrido.getBuses();
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
