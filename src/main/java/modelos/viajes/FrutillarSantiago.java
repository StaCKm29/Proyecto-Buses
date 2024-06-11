package modelos.viajes;

import modelos.*;

import java.util.ArrayList;

public class FrutillarSantiago implements EstrategiaRecorrido{
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
