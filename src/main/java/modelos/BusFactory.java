package modelos;

public interface BusFactory {
    Bus crearBus(int precioBase, TipoAsiento... asientos);
}
