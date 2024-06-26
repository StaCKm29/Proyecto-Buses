package vistas;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Clase SeleccionDeAsiento que se utilizará para seleccionar los asientos de un bus
 */
public class SeleccionDeAsiento extends JPanel {
    private ArrayList<Asiento> asientosDelBus;
    private ArrayList<Integer> asientosSeleccionados = new ArrayList<>();
    private AsientosEnUnPiso pisoUno;
    private AsientosEnUnPiso pisoDos;
    private DatosPersonales datosPersonales;
    private JButton botonCompra;
    private Cliente cliente;
    private Bus bus;
    private CambioPanelListener listener;
    /**
     * Constructor de la clase SeleccionDeAsiento
     * @param bus Bus a seleccionar asientos
     * @param listener Listener que se encargará de cambiar de panel
     */
    public SeleccionDeAsiento(Bus bus, CambioPanelListener listener) {
        this.listener = listener;
        this.bus = bus;
        String[] opcionesPago = {
            "Tarjeta de Credito",
            "Tarjeta de Debito",
            "Efectivo"};

        this.botonCompra = new JButton("COMPRAR");
        botonCompra.addActionListener(e -> {
            JOptionPane.showOptionDialog(
                    null,
                    "Seleccione el metodo de pago",
                    "Metodo de Pago",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opcionesPago,
            opcionesPago[0]
            );

            try {
                comprarPasajes();
                JOptionPane.showMessageDialog(this, "Espere.","Procesando pago", JOptionPane.INFORMATION_MESSAGE);

                try {
                    Thread.sleep(5000); // Espera 5 segundos
                } catch (InterruptedException a) {
                    a.printStackTrace();
                }

                JOptionPane.showMessageDialog(this, "Compra realizada con exito", "Compra", JOptionPane.INFORMATION_MESSAGE);
                listener.volverABuscador();

            } catch (AsientoNoSeleccionadoException | DatosVaciosException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        datosPersonales = new DatosPersonales();

        add(botonCompra);
        add(datosPersonales);

        if (bus.getClass() == UnPiso.class) {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus, "Piso 1", Color.PINK);
            add(pisoUno);
        } else {
            asientosDelBus = bus.getAsientos(1);
            pisoUno = new AsientosEnUnPiso(asientosDelBus, "Piso 1", Color.PINK);
            asientosDelBus = bus.getAsientos(2);
            pisoDos = new AsientosEnUnPiso(asientosDelBus, "Piso 2", Color.cyan);
            add(pisoUno);
            add(pisoDos);
        }
    }

    /**
     * Método que se encarga de comprar los pasajes
     */

    private void comprarPasajes() throws AsientoNoSeleccionadoException, DatosVaciosException {
        if (bus.getClass() == UnPiso.class) {
            asientosSeleccionados.addAll(pisoUno.getAsientosSeleccionados());
        } else {
            asientosSeleccionados.addAll(pisoUno.getAsientosSeleccionados());
            asientosSeleccionados.addAll(pisoDos.getAsientosSeleccionados());
        }
        if (asientosSeleccionados.isEmpty()) {
            throw new AsientoNoSeleccionadoException("Debe seleccionar al menos un asiento");
        }
        cliente = new Cliente(datosPersonales.getNombre(), datosPersonales.getApellido(), datosPersonales.getRut(), bus, asientosSeleccionados);
        if (bus.getClass() == UnPiso.class) {
            pisoUno.actualizarAsientos();
        } else {
            pisoUno.actualizarAsientos();
            pisoDos.actualizarAsientos();
        }
        revalidate();
        repaint();
    }

}

   /* public static void main(String[] args) {
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
    }*/

