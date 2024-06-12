package modelos;

public class Main {
    public static void main(String[] args) {
        BusFactory unPisoFactory = new UnPisoFactory();
        Bus unPiso = unPisoFactory.crearBus(2,TipoAsiento.COMUN);

        BusFactory dosPisosFactory = new DosPisosFactory();
        Bus dosPisos = dosPisosFactory.crearBus(3,TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA);
    }
}