package modelos.viajes;

import modelos.*;

import java.util.ArrayList;

/**
 * Clase que representa la estrategia de recorrido entre Frutillar y Santiago.
 */
public class FrutillarSantiago implements EstrategiaRecorrido{
    /**
     * Método que crea un recorrido entre Frutillar y Santiago, creando un stock de buses.
     * @param buses Lista donde se almacenarán los buses disponibles para dicho recorrido.
     * @param busFactory Abstract Method para un bus de un piso.
     * @param busFactory2 Abstract Method para un bus de dos pisos.
     */
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, BusFactory busFactory, BusFactory busFactory2) {
        int precioBase = 22000;
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SALONCAMA));
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SEMICAMA));
    }
}
