package modelos;

public class Main {
    public static void main(String[] args) {
        BusFactory unPisoFactory = new UnPisoFactory();
        Bus unPiso = unPisoFactory.crearBus(TipoAsiento.COMUN);

        BusFactory dosPisosFactory = new DosPisosFactory();
        Bus dosPisos = dosPisosFactory.crearBus(TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA);
    }
}