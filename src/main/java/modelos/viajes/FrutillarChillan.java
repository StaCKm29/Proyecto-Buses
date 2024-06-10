package modelos.viajes;

import modelos.Bus;
import modelos.DosPisosFactory;
import modelos.TipoAsiento;
import modelos.UnPisoFactory;

import java.util.ArrayList;

public class FrutillarChillan implements EstrategiaRecorrido {
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, UnPisoFactory unPisoFactory, DosPisosFactory dosPisosFactory) {
        buses.add(unPisoFactory.crearBus(TipoAsiento.COMUN));
        buses.add(dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(unPisoFactory.crearBus(TipoAsiento.SEMICAMA));
        buses.add(dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(unPisoFactory.crearBus(TipoAsiento.COMUN));
    }
}
