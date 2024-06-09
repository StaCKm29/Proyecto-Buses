package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DosPisosTest {
    private DosPisos bus;
    @BeforeEach
    void setUp() {
        TipoAsiento nivelUno = TipoAsiento.COMUN;
        TipoAsiento nivelDos = TipoAsiento.SALONCAMA;
        bus = new DosPisos(nivelUno, nivelDos);
    }

    @Test
    void comprarPasaje(){
        Pasaje pasaje1 = bus.comprarPasaje(1);
        assertEquals(true, pasaje1.getAsiento().getEstado());
    }
}