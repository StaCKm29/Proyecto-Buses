package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DosPisosTest {
    private Bus bus;
    private BusFactory busFactory;

    @BeforeEach
    void setUp() {
        //Se crea un bus de dos pisos.
        busFactory = new DosPisosFactory();
        bus = busFactory.crearBus(2000, TipoAsiento.COMUN, TipoAsiento.SALONCAMA);
    }

    @Test
    @DisplayName("Test para obtener el precio total de un pasaje")
    void getPrecioTotal() {
        int precioTotal = bus.getPrecioTotal(1);
        assertEquals(2000 + TipoAsiento.COMUN.getPrecio(), precioTotal);
    }

    @Test
    @DisplayName("Test para comprar un pasaje")
    void comprarPasaje(){
        int precioTotal = bus.getPrecioTotal(3);
        Pasaje pasaje1 = bus.comprarPasaje(1, precioTotal);
        //true significa que el asiento esta ocupado.
        assertEquals(true, pasaje1.getAsiento().getEstado());
    }

}