package modelos;


import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Bus {
    private int patente;
    private int capacidad;
    private int precioBase;
    private String origen;
    private String destino;
    private LocalTime horaSalida;
    private LocalDate fechaSalida;

    public Bus(int precioBase){
        this.precioBase = precioBase;
    }

    public abstract Pasaje comprarPasaje(int numero, int precioTotal);
    public abstract int getPrecioTotal(int num);

    protected int getPrecioBase() {
        return precioBase;
    }
    public void setOrigen(String origen){
        this.origen = origen;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public String getOrigen(){
        return origen;
    }
    public String getDestino(){
        return destino;
    }
    public void setHoraSalida(LocalTime horaSalida){
        this.horaSalida = horaSalida;
    }
    public void setFechaSalida(LocalDate fechaSalida){
        this.fechaSalida = fechaSalida;
    }
}
