package vistas;

import modelos.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SeleccionDeAsiento extends JPanel {
    private ArrayList<Asiento> asientosDelBus;
    private ArrayList<Integer> asientosSeleccionados = new ArrayList<>();
    private AsientosEnUnPiso pisoUno;
    private AsientosEnUnPiso pisoDos;
    private DatosPersonales datosPersonales;
    private JButton botonCompra;
    private Cliente cliente;
    private Bus bus;

    public SeleccionDeAsiento(Bus bus) {
        this.bus = bus;
        this.botonCompra = new JButton("COMPRAR");
        datosPersonales = new DatosPersonales();
        add(botonCompra);
        add(datosPersonales);
        if(bus.getClass() == UnPiso.class) {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus, "Piso 1");
            add(pisoUno);
        } else {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus, "Piso 1");
            asientosDelBus = bus.getAsientos(2);
            pisoDos = new AsientosEnUnPiso(asientosDelBus, "Piso 2");
            add(pisoUno);
            add(pisoDos);
        }
        botonCompra.addActionListener(e -> comprarPasajes());

    }

    public JButton getBotonCompra(){
        return botonCompra;
    }

    private void comprarPasajes(){
        if(bus.getClass() == UnPiso.class){
            asientosSeleccionados.addAll(pisoUno.getAsientosSeleccionados());
        }
        else{
            asientosSeleccionados.addAll(pisoUno.getAsientosSeleccionados());
            asientosSeleccionados.addAll(pisoDos.getAsientosSeleccionados());
        }
        cliente = new Cliente(datosPersonales.getNombre(), datosPersonales.getApellido(), datosPersonales.getRut(), bus, asientosSeleccionados);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccion de Asiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        //Bus bus = new UnPiso(2000, TipoAsiento.SEMICAMA);
        Bus bus= new DosPisos(2000, TipoAsiento.SEMICAMA, TipoAsiento.SEMICAMA);
        LocalTime hora = LocalTime.of(10, 0);
        LocalDate fecha = LocalDate.of(2024, 12, 12);
        bus.setHoraSalida(hora);
        bus.setOrigen(Localidades.SANTIAGO.toString());
        bus.setDestino(Localidades.CONCEPCION.toString());
        bus.setFechaSalida(fecha);
        SeleccionDeAsiento seleccionDeAsiento = new SeleccionDeAsiento(bus);

        frame.add(seleccionDeAsiento);

        frame.setVisible(true);
    }
}
