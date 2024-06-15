package modelos;
/**
 * Clase que implementa la interfaz BusFactory para crear buses de un piso.
 */
public class UnPisoFactory implements BusFactory{
    /**
     * Método que crea un bus de un piso.
     * @param precioBase Precio base del bus.
     * @param asientos Tipos de asientos del bus.
     * @return Bus de un piso.
     */
    @Override
    public Bus crearBus(int precioBase, TipoAsiento... asientos) {
        if(asientos.length != 1){
            throw new IllegalArgumentException("Bus de un piso solo puede tener un tipo de asiento");
        }
        return new UnPiso(precioBase, asientos[0]);
    }
}
