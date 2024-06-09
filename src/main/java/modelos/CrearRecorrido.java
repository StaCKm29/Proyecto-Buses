package modelos;

import java.util.ArrayList;

public class CrearRecorrido {
    private ArrayList<Bus> buses;
    private Bus bus1 = new UnPiso(TipoAsiento.COMUN);
    private Bus bus2 = new UnPiso(TipoAsiento.SEMICAMA);
    private Bus bus3 = new UnPiso(TipoAsiento.SALONCAMA);
    private Bus bus4 = new DosPisos(TipoAsiento.SALONCAMA, TipoAsiento.SALONCAMA);
    private Bus bus5 = new DosPisos(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA);
    private Bus bus6 = new DosPisos(TipoAsiento.SEMICAMA, TipoAsiento.SEMICAMA);
    private Bus bus7 = new DosPisos(TipoAsiento.SEMICAMA, TipoAsiento.COMUN);
    private Bus bus8 = new DosPisos(TipoAsiento.COMUN, TipoAsiento.COMUN);

    public CrearRecorrido(Localidades partida, Localidades destino) throws MismaLocalidadException {
        if(partida == destino)
            throw new MismaLocalidadException("La partida y el destino no pueden ser iguales");

        switch (partida){
            case FRUTILLAR -> {
                switch (destino){
                    case CHILLAN -> {
                        // Crear recorrido
                        Bus bus1 = new UnPiso(TipoAsiento.COMUN);
                        buses.add(bus1);
                        Bus bus2 = new DosPisos(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA);
                        buses.add(bus2);
                    }
                    case CONCEPCION -> {
                        // Crear recorrido
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
