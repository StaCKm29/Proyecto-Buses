package modelos;

import java.util.ArrayList;

public class CrearRecorrido {
    private ArrayList<Bus> buses;
    private UnPisoFactory unPisoFactory = new UnPisoFactory();
    private DosPisosFactory dosPisosFactory = new DosPisosFactory();
    private EstrategiaRecorrido estrategia;
    private Bus bus; 
    public CrearRecorrido(Localidades partida, Localidades destino) throws MismaLocalidadException {
        if(partida == destino)
            throw new MismaLocalidadException("La partida y el destino no pueden ser iguales");

        switch (partida){
            case FRUTILLAR -> {
                switch (destino){
                    case CHILLAN -> estrategia = new EstrategiaFrutillarChillan();
                    case CONCEPCION -> {
                        // Crear recorrido
                        bus = dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA);
                        buses.add(bus);
                        bus = unPisoFactory.crearBus(TipoAsiento.SEMICAMA);
                        buses.add(bus);
                        bus = dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SALONCAMA);
                        buses.add(bus);
                        bus = dosPisosFactory.crearBus(TipoAsiento.COMUN, TipoAsiento.COMUN);
                        buses.add(bus);
                    }
                    case SANTIAGO -> {
                        // Crear recorrido
                    }
                }
            }
            case CHILLAN -> {
                switch (destino){
                    case FRUTILLAR -> {
                        // Crear recorrido
                    }
                    case CONCEPCION -> {
                        // Crear recorrido
                    }
                    case SANTIAGO -> {
                        // Crear recorrido
                    }
                }
            }
            case CONCEPCION -> {
                switch (destino){
                    case FRUTILLAR -> {
                        // Crear recorrido
                    }
                    case CHILLAN -> {
                        // Crear recorrido
                    }
                    case SANTIAGO -> {
                        // Crear recorrido
                    }
                }
            }
            case SANTIAGO -> {
                switch (destino){
                    case FRUTILLAR -> {
                        // Crear recorrido
                    }
                    case CHILLAN -> {
                        // Crear recorrido
                    }
                    case CONCEPCION -> {
                        // Crear recorrido
                    }
                }
            }
        }
    }
}
