package modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pasaje {
    private Asiento asiento;
    private String nombre;
    private String apellido;
    private String rut;
    private String origen;
    private String destino;
    private int precioTotal;

    public Pasaje(Asiento asiento, int precioTotal, String origen, String destino){
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
