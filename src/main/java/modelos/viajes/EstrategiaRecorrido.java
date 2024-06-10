package modelos.viajes;

import modelos.Bus;
import modelos.DosPisosFactory;
import modelos.UnPisoFactory;

import java.util.ArrayList;

public interface EstrategiaRecorrido {
    void crearRecorrido(ArrayList<Bus> buses, UnPisoFactory unPisoFactory, DosPisosFactory dosPisosFactory);
}
