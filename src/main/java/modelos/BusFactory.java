package modelos;
/**
 * Interfaz que utiliza el patron factory para la creacion de buses.
 */
public interface BusFactory {
    /**
     * Método que crea un bus.
     * @param precioBase Precio base del bus.
     * @param asientos Tipo de asientos.
     */
    Bus crearBus(int precioBase, TipoAsiento... asientos);
}
