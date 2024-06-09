package modelos;

import java.util.ArrayList;

public interface EstrategiaRecorrido {
    void crearRecorrido(ArrayList<Bus> buses, UnPisoFactory unPisoFactory, DosPisosFactory dosPisosFactory);
}
