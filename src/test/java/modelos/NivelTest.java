package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NivelTest {
    private Nivel<Asiento> nivel1;
    private SemiCama asiento1;
    private SemiCama asiento2;
    private SemiCama asiento3;


    @BeforeEach
    void setUp() {
        nivel1 = new Nivel<Asiento>();
        asiento1 = new SemiCama(1);
        asiento2 = new SemiCama(2);
        asiento3 = new SemiCama(3);
    }

    @Test
    void TestaddAsiento() {
        nivel1.addAsiento(asiento1);
        assertEquals(1, nivel1.asientosDisponibles());
    }

    @Test
    void TestaddAsiento2() {
        nivel1.addAsiento(asiento1);
        nivel1.addAsiento(asiento2);
        nivel1.addAsiento(asiento3);
        assertEquals(3, nivel1.asientosDisponibles());
    }

    @Test
    void adquirirAsiento() {
        nivel1.addAsiento(asiento1);
        assertEquals(asiento1, nivel1.adquirirAsiento(1));
    }

    @Test
    void asientosDisponibles() {
        nivel1.addAsiento(asiento1);
        nivel1.addAsiento(asiento2);
        nivel1.addAsiento(asiento3);
        nivel1.adquirirAsiento(1);
        assertEquals(2, nivel1.asientosDisponibles());
    }
}