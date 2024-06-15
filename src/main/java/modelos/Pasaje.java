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
     * @param origen Origen del recorrido.
     * @param destino Destino del recorrido.
     * @param horaSalida Hora de salida del pasaje.
     * @param fechaSalida Fecha de salida del pasaje.
     */
    public Pasaje(Asiento asiento, int precioTotal, String origen, String destino, LocalTime horaSalida, LocalDate fechaSalida){
        this.asiento = asiento;
        this.precioTotal = precioTotal;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.fechaSalida = fechaSalida;
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
     * Método que retorna el nombre del pasajero.
     * @return Nombre.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Método que retorna el apellido del pasajero.
     * @return Apellido.
     */
    public String getApellido(){
        return apellido;
    }
    /**
     * Método que retorna el rut del pasajero.
     * @return rut.
     */
    public String getRut(){
        return rut;
    }
    /**
     * Método que retorna precio del pasaje.
     * @return Origen.
     */
    public int getPrecioTotal(){
        return precioTotal;
    }
    /**
     * Método crea un archivo txt con los datos del pasaje.
     */
    public void generarPasajeTxt(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + nombre + "_" + apellido + "Asiento_"+ asiento.getNumero() + ".txt"));
            writer.write("Origen: " + origen + "\n");
            writer.write("Destino: " + destino + "\n");
            writer.write("Nombre: " + nombre +"_"+ apellido + "\n");
            writer.write("Rut: " + rut + "\n");
            writer.write("Asiento: " + asiento.getNumero() + "\n");
            writer.write("Precio: " + precioTotal + "\n");
            writer.write("Hora de salida: " + horaSalida.toString() + "\n");
            writer.write("Fecha de salida: " + fechaSalida.toString() + "\n");
            writer.write("Recuerde llegar al terminal con 15 minutos de anticipación\n");
            writer.write("Gracias por preferirnos");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
