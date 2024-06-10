package modelos;

public class UnPisoFactory implements BusFactory{
    @Override
    public Bus crearBus(TipoAsiento... asientos) {
        if(asientos.length != 1){
            throw new IllegalArgumentException("Bus de un piso solo puede tener un tipo de asiento");
        }
        return new UnPiso(asientos[0]);
    }
}
