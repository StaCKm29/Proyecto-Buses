package modelos;


public abstract class Bus {
    private int patente;
    private int capacidad;

    public abstract Pasaje comprarPasaje(int numero);
}
