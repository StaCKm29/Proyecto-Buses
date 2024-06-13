package modelos.viajes;

import modelos.*;

import java.util.ArrayList;

/**
 * Clase que representa el recorrido entre Frutillar y Chillán.
 */
public class FrutillarChillan implements EstrategiaRecorrido {
    /**
     * Crear un stock de buses.
     * @param buses Lista donde se almacenarán los buses disponibles para dicho recorrido.
     * @param busFactory Abstract Method para un bus de un piso.
     * @param busFactory2 Abstract Method para un bus de dos pisos.
     */
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, BusFactory busFactory, BusFactory busFactory2) {
        int precioBase = 12000;
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.COMUN));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
    }
}
