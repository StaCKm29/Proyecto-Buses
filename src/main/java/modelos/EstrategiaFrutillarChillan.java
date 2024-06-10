package modelos;

import java.util.ArrayList;

public class EstrategiaFrutillarChillan implements EstrategiaRecorrido{
    @Override
    public void crearRecorrido(ArrayList<Bus> buses, UnPisoFactory unPisoFactory, DosPisosFactory dosPisosFactory) {
        buses.add(unPisoFactory.crearBus(TipoAsiento.COMUN));
        buses.add(dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(unPisoFactory.crearBus(TipoAsiento.SEMICAMA));
        buses.add(dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA));
        buses.add(unPisoFactory.crearBus(TipoAsiento.COMUN));
    }
}
