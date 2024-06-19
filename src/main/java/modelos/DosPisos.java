package modelos;

import java.util.ArrayList;

/**
 * Clase que representa un bus de dos pisos.
 */
public class DosPisos extends Bus{
    private Nivel<Asiento> primerPiso;
    private Nivel<Asiento> segundoPiso;
    private int capacidadNivelUno = 15;
    private int capacidadNivelDos = 30;
    private TipoAsiento nivelUno;
    private TipoAsiento nivelDos;
    /**
     * Constructor de la clase DosPisos.
     * @param precioBase Precio base del bus.
     * @param nivelUno Tipo de asiento del primer piso.
     * @param nivelDos Tipo de asiento del segundo piso.
     */
    public DosPisos(int precioBase, TipoAsiento nivelUno, TipoAsiento nivelDos){
        super(precioBase);
        primerPiso = new Nivel<>();
        segundoPiso = new Nivel<>();
        this.nivelUno = nivelUno;
        this.nivelDos = nivelDos;

        for ( int i = 0 ; i < capacidadNivelUno; i++) {
            Asiento asiento = nivelUno.crearAsiento(i+1);
            primerPiso.addAsiento(asiento);
        }

        for (int i = capacidadNivelUno - 1; i < capacidadNivelDos + (capacidadNivelUno-1) ; i++) {
            Asiento asiento = nivelDos.crearAsiento(i+1);
            segundoPiso.addAsiento(asiento);
        }
    }
    /**
     * Método que retorna el precio total de un pasaje.
     * @param num Número del asiento.
     * @return Precio total.
     */
    @Override
    public int getPrecioTotal(int num){
        int precioAsiento;
        int precioBus;

        if(num <= capacidadNivelUno){
            precioAsiento = nivelUno.getPrecio();
            precioBus = super.getPrecioBase();
        }
        else{
            precioAsiento = nivelDos.getPrecio();
            precioBus = super.getPrecioBase();
        }
        return precioBus+precioAsiento;
    }
    /**
     * Método que retorna un pasaje comprado con datos del bus.
     * @return Nuevo pasaje.
     */
    @Override
    public Pasaje comprarPasaje(int numero, int precioTotal){
        if(numero <= capacidadNivelUno){
            return new Pasaje(primerPiso.adquirirAsiento(numero), precioTotal, getOrigen(), getDestino(), getHoraSalida(), getFechaSalida());
        }
        else{
            return new Pasaje(segundoPiso.adquirirAsiento(numero - capacidadNivelUno), precioTotal, getOrigen(), getDestino(), getHoraSalida(), getFechaSalida());
        }
    }

    @Override
    public ArrayList<Asiento> getAsientos(int numeroNivel){
        if(numeroNivel == 1)
            return primerPiso.getArrayAsientos();
        else
            return segundoPiso.getArrayAsientos();
    }

    @Override
    public String toString() {
        int precioTotal;
        if(getPrecioTotal(1) > getPrecioTotal(16))
            precioTotal = getPrecioTotal(13);
        else
            precioTotal = getPrecioTotal(1);
        return "BUS DOS PISOS: " + nivelUno.toString() + " Y " + nivelDos.toString() + super.toString() + " Desde: $" + precioTotal;
    }

}
