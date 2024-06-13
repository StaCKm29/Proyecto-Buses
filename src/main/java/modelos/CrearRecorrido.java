package modelos;

import modelos.viajes.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * Clase que crea una lista de buses para un recorrido.
 */
public class CrearRecorrido {
    private ArrayList<Bus> buses = new ArrayList<>();
    private BusFactory busFactory1 = new UnPisoFactory();
    private BusFactory busFactory2 = new DosPisosFactory();
    private EstrategiaRecorrido recorrido;
    /**
     * Constructor de la clase CrearRecorrido.
     * @param partida Localidad de partida.
     * @param destino Localidad de destino.
     * @param fechaViaje Fecha de viaje.
     * @throws MismaLocalidadException Si la partida y el destino son iguales.
     */
    public CrearRecorrido(Localidades partida, Localidades destino, LocalDate fechaViaje) throws MismaLocalidadException {
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

        recorrido.crearRecorrido(buses, busFactory1,busFactory2 );
        for(int i = 0; i < buses.size(); i++){
            buses.get(i).setOrigen(partida.toString());
            buses.get(i).setDestino(destino.toString());
        }

        LocalTime horaActual = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        LocalDate fechaActual = fechaViaje;

        for (int i = 0; i < buses.size(); i++) {
            LocalTime nuevaHora = horaActual.plusHours(2 * (i+1));
            if (nuevaHora.isBefore(horaActual)) { // Si la nueva hora es antes que la hora actual, ha pasado un día
                fechaActual = fechaActual.plusDays(1);
            }
            buses.get(i).setHoraSalida(nuevaHora);
            buses.get(i).setFechaSalida(fechaActual);
            horaActual = nuevaHora;
        }
    }
    /**
     * Método que retorna la lista de buses.
     * @return Lista de buses.
     */
    public ArrayList<Bus> getBuses() {
        return buses;
    }
}
