package modelos;

import modelos.viajes.*;

import java.util.ArrayList;

public class CrearRecorrido {
    private ArrayList<Bus> buses;
    private UnPisoFactory unPisoFactory = new UnPisoFactory();
    private DosPisosFactory dosPisosFactory = new DosPisosFactory();
    private EstrategiaRecorrido recorrido;
    private Bus bus;
    public CrearRecorrido(Localidades partida, Localidades destino) throws MismaLocalidadException {
        if(partida == destino)
            throw new MismaLocalidadException("La partida y el destino no pueden ser iguales");

        switch (partida){
            case FRUTILLAR -> {
                switch (destino){
                    case CHILLAN -> recorrido = new FrutillarChillan();
                    case CONCEPCION -> recorrido = new FrutillarConcepcion();
                    case SANTIAGO -> recorrido = new FrutillarSantiago();
                }
            }
            case CHILLAN -> {
                switch (destino){
                    case FRUTILLAR -> recorrido = new FrutillarChillan();
                    case CONCEPCION -> recorrido = new ChillanConcepcion();
                    case SANTIAGO -> recorrido = new ChillanSantiago();
                }
            }
            case CONCEPCION -> {
                switch (destino){
                    case FRUTILLAR -> recorrido = new FrutillarConcepcion();
                    case CHILLAN -> recorrido = new ChillanConcepcion();
                    case SANTIAGO -> recorrido = new SantiagoConcepcion();
                }
            }
            case SANTIAGO -> {
                switch (destino){
                    case FRUTILLAR ->recorrido = new FrutillarSantiago();
                    case CHILLAN -> recorrido = new ChillanSantiago();
                    case CONCEPCION -> recorrido = new SantiagoConcepcion();
                }
            }
        }
    }
}
