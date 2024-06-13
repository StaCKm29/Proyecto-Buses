package modelos;
/**
 * Clase que implementa la interfaz BusFactory para la creación de buses de dos pisos.
 */
public class DosPisosFactory implements BusFactory{
    /**
     * Método que crea un bus de dos pisos.
     * @param precioBase Precio base del bus.
     * @param asientos Tipo de asientos.
     * @return Bus de dos pisos.
     */
    @Override
    public Bus crearBus(int precioBase, TipoAsiento... asientos) {
        if(asientos.length != 2){
            throw new IllegalArgumentException("Bus de dos pisos solo puede tener dos tipos de asiento");
        }
        return new DosPisos(precioBase, asientos[0], asientos[1]);
    }
}
