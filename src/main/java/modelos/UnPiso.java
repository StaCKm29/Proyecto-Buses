package modelos;

import java.util.ArrayList;

/**
 * Clase que representa un bus de un piso.
 */
public class UnPiso extends Bus{
    private Nivel<Asiento> primerPiso;
    private TipoAsiento nivelUno;
    private int capacidadNivelUno = 27;
    /**
     * Constructor de la clase UnPiso.
     * @param precioBase Precio base del bus.
     * @param nivelUno Tipo de asiento del nivel uno.
     */
    public UnPiso(int precioBase, TipoAsiento nivelUno){
        super(precioBase);
        primerPiso = new Nivel<>();
        this.nivelUno = nivelUno;

        for (int i = 0; i < capacidadNivelUno; i++) {
            Asiento asiento = nivelUno.crearAsiento(i+1);
            primerPiso.addAsiento(asiento);
        }
    }
    /**
     * Método que retorna el precio total de un asiento.
     * @param num Número del asiento.
     * @return Precio total de un asiento.
     */
    @Override
    public int getPrecioTotal(int num){
        int precioAsiento = nivelUno.getPrecio();
        int precioBus = super.getPrecioBase();
        return precioAsiento + precioBus;
    }
    /**
     * Método que retorna un nuevo oasaje
     * @param numero Número del asiento.
     * @param precioTotal Precio total del pasaje.
     * @return Pasaje nuevo.
     */
    @Override
    public Pasaje comprarPasaje(int numero, int precioTotal, Bus bus){
        return new Pasaje(primerPiso.adquirirAsiento(numero), precioTotal, bus);
    }

    @Override
    public ArrayList<Asiento> getAsientos(int numero) {
        return primerPiso.getArrayAsientos();
    }

    @Override
    public String toString() {
        int precioTotal = getPrecioTotal(1);
        return "BUS UN PISO: " + nivelUno.toString() + super.toString() + " Desde: $" + precioTotal;
    }
}

