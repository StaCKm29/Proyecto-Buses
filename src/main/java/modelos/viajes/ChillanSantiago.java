package modelos.viajes;

import modelos.*;
import java.util.ArrayList;

/**
 * Clase que representa un recorrido entre Chillán y Santiago.
 */
public class ChillanSantiago implements EstrategiaRecorrido{
    /**
     *
     * @param buses
     * @param busFactory
     * @param busFactory2
     */
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, BusFactory busFactory, BusFactory busFactory2) {
        int precioBase = 10000;
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SEMICAMA));
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SALONCAMA));
        buses.add(busFactory.crearBus(precioBase, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(precioBase, TipoAsiento.SALONCAMA, TipoAsiento.SALONCAMA));
    }
}
