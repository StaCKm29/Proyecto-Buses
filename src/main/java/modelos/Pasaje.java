package modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public Pasaje(Asiento asiento, int precioTotal, String origen, String destino, LocalTime horaSalida, LocalDate fechaSalida){
        this.asiento = asiento;
        this.precioTotal = precioTotal;
        this.origen = origen;
        this.destino = destino;
    }

    public void setDatos(String nombre, String apellido, String rut){
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public Asiento getAsiento(){
        return asiento;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getRut(){
        return rut;
    }
    public int getPrecioTotal(){
        return precioTotal;
    }
    public void generarPasajeTxt(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombre + "_" + apellido + "Asiento_"+ asiento.getNumero() + ".txt"));
            writer.write("Origen: " + origen + "\n");
            writer.write("Destino: " + destino + "\n");
            writer.write("Nombre: " + nombre + apellido + "\n");
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
