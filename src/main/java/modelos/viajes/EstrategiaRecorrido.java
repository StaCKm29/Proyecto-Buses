package modelos.viajes;

import modelos.Bus;
import modelos.BusFactory;

import java.util.ArrayList;

public interface EstrategiaRecorrido {
    void crearRecorrido(ArrayList<Bus> buses, BusFactory busfactory1, BusFactory busFactory2);
}
