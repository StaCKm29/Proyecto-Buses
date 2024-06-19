package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasajeTest {
    private Pasaje pasaje;
    private int precioTotal = 10000;
    private BusFactory busFactory;
    private Bus bus;

    @BeforeEach
    void setUp() {
        bus = busFactory.crearBus(precioTotal, TipoAsiento.SALONCAMA, TipoAsiento.SEMICAMA);
        SalonCama asiento1 = new SalonCama(1);
        pasaje = new Pasaje(asiento1, precioTotal, bus);
    }

    /*
    @Test
    void setDatos() {
        pasaje.setDatos("Marcos", "Martinez", "12345678-9");
        assertEquals("Marcos", pasaje.getNombre());
        assertEquals("Martinez", pasaje.getApellido());
        assertEquals("12345678-9", pasaje.getRut());
        assertEquals(precioTotal, pasaje.getPrecioTotal());
    }*/
}