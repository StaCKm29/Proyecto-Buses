package modelos.viajes;

import modelos.Bus;
import modelos.BusFactory;

import java.util.ArrayList;

/**
 * Interfaz que representa la estrategia de recorrido.
 */
public interface EstrategiaRecorrido {
    /**
     * Método que crea un recorrido.
     * @param buses Lista donde se almacenarán los buses disponibles para dicho recorrido.
     * @param busfactory1 Abstract Method para un bus de un piso.
     * @param busFactory2 Abstract Method para un bus de dos pisos.
     */
    void crearRecorrido(ArrayList<Bus> buses, BusFactory busfactory1, BusFactory busFactory2);
}
