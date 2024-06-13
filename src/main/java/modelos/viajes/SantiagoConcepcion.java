package modelos.viajes;

import modelos.*;

import java.util.ArrayList;

/**
 * Clase que representa la estrategia de recorrido entre Santiago y Concepción.
 */
public class SantiagoConcepcion implements EstrategiaRecorrido{
    /**
     * Método que crea un recorrido entre Santiago y Concepción, creando un stock de buses.
     * @param buses Lista donde se almacenarán los buses disponibles para dicho recorrido.
     * @param busFactory Abstract Method para un bus de un piso.
     * @param busFactory2 Abstract Method para un bus de dos pisos.
     */
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, BusFactory busFactory, BusFactory busFactory2) {
        int precioBase = 10000;
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SALONCAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SALONCAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SALONCAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SEMICAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SEMICAMA, TipoAsiento.SEMICAMA));
    }
}
