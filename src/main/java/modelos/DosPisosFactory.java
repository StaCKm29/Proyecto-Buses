package modelos;

public class DosPisosFactory implements BusFactory{
    @Override
    public Bus crearBus(int precioBase, TipoAsiento... asientos) {
        if(asientos.length != 2){
            throw new IllegalArgumentException("Bus de dos pisos solo puede tener dos tipos de asiento");
        }
        return new DosPisos(precioBase, asientos[0], asientos[1]);
    }
}
