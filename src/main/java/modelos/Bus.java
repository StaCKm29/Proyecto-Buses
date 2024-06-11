package modelos;


public abstract class Bus {
    private int patente;
    private int capacidad;
    private int precioBase;

    public Bus(int precioBase){
        this.precioBase = precioBase;
    }

    public abstract Pasaje comprarPasaje(int numero);
    public abstract int getPrecioTotal(int num);

    protected int getPrecioBase() {
        return precioBase;
    }
}
