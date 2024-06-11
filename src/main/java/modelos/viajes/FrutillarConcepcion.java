package modelos.viajes;

import modelos.*;

import java.util.ArrayList;

public class FrutillarConcepcion implements EstrategiaRecorrido{
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, BusFactory busFactory, BusFactory busFactory2) {
        buses.add(busFactory.crearBus(TipoAsiento.COMUN));
        buses.add(busFactory2.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory.crearBus(TipoAsiento.SEMICAMA));
        buses.add(busFactory2.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(busFactory.crearBus(TipoAsiento.COMUN));
    }
}
