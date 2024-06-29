package modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Clase que representa un pasaje de bus.
 */
public class Pasaje {
    private Asiento asiento;
    private String nombre;
    private String apellido;
    private String rut;
    private String origen;
    private String destino;
    private LocalTime horaSalida;
    private LocalDate fechaSalida;
    private int precioTotal;
    /**
     * Constructor de la clase Pasaje.
     * @param asiento Asiento del pasaje.
     * @param precioTotal Precio total del pasaje.
     * @param bus Bus del pasaje.
     */
    public Pasaje(Asiento asiento, int precioTotal, Bus bus){
        this.asiento = asiento;
        this.precioTotal = precioTotal;
        this.origen = bus.getOrigen();
        this.destino = bus.getDestino();
        this.horaSalida = bus.getHoraSalida();
        this.fechaSalida = bus.getFechaSalida();
    }
    /**
     * Método que establece los datos del pasajero.
     * @param nombre Nombre del pasajero.
     * @param apellido Apellido del pasajero.
     * @param rut Rut del pasajero.
     */
    public void setDatos(String nombre, String apellido, String rut){
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }
    /**
     * Método que retorna el asiento del pasaje.
     * @return Asiento.
     */
    public Asiento getAsiento(){
        return asiento;
    }


    /**
     * Método crea un archivo txt con los datos del pasaje.
     */
    public void generarPasajeTxt(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + nombre + "_" + apellido + "Asiento_"+ asiento.getNumero() + ".txt"));
            writer.write("Origen: " + origen + ".\n");
            writer.write("Destino: " + destino + ".\n");
            writer.write("Nombre: " + nombre +"_"+ apellido + ".\n");
            writer.write("Rut: " + rut + ".\n");
            writer.write("Asiento: " + asiento.getNumero() + ".\n");
            writer.write("Precio: " + precioTotal + "\n");
            writer.write("Hora de salida: " + horaSalida.toString() + "\n");
            writer.write("Fecha de salida: " + fechaSalida.toString() + "\n");
            writer.write("Recuerde llegar al terminal con 15 minutos de anticipación.\n");
            writer.write("Gracias por preferirnos.");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
