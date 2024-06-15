package modelos;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase abstracta Bus que representa un bus.
 */
public abstract class Bus {
    private int patente;
    private int capacidad;
    private int precioBase;
    private String origen;
    private String destino;
    private LocalTime horaSalida;
    private LocalDate fechaSalida;

    /**
     * Constructor de la clase Bus.
     * @param precioBase Precio base del bus.
     */
    public Bus(int precioBase){
        this.precioBase = precioBase;
    }

    /**
     * Método que retorna un pasaje comprado con datos del bus.
     * @return Nuevo pasaje.
     */
    public abstract Pasaje comprarPasaje(int numero, int precioTotal);
    /**
     * Método que retorna el precio total de un pasaje.
     * @param num Número del asiento.
     * @return Precio total.
     */
    public abstract int getPrecioTotal(int num);
    /**
     * Método que retorna el precio base del bus.
     * @return Precio base.
     */
    protected int getPrecioBase() {
        return precioBase;
    }
    /**
     * Método que establece la localidad de origen.
     * @param origen Localidad de origen.
     */
    public void setOrigen(String origen){
        this.origen = origen;
    }
    /**
     * Método establece la localidad de destino.
     * @param destino Localidad de destino.
     */
    public void setDestino(String destino){
        this.destino = destino;
    }
    /**
     * Método que retorna la ciudad de origen.
     * @return origen.
     */
    public String getOrigen(){
        return origen;
    }
    /**
     * Método que retorna la ciudad de destino.
     * @return destino.
     */
    public String getDestino(){
        return destino;
    }
    /**
     * Método que establece la hora de salida.
     * @param horaSalida Hora de salida.
     */
    public void setHoraSalida(LocalTime horaSalida){
        this.horaSalida = horaSalida;
    }
    /**
     * Método que establece la fecha de salida.
     * @param fechaSalida Fecha de salida.
     */
    public void setFechaSalida(LocalDate fechaSalida){
        this.fechaSalida = fechaSalida;
    }
    /**
     * Método que retorna la hora de salida.
     * @return horaSalida.
     */
    public LocalTime getHoraSalida(){
        return horaSalida;
    }
    /**
     * Método que retorna la fecha de salida.
     * @return fechaSalida.
     */
    public LocalDate getFechaSalida(){
        return fechaSalida;
    }
}
