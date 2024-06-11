package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CrearRecorridoTest {
    private CrearRecorrido recorrido;
    @BeforeEach
    void setUp() throws MismaLocalidadException {
        Localidades Inicio = Localidades.CHILLAN;
        Localidades Destino = Localidades.CONCEPCION;
        this.recorrido = new CrearRecorrido(Inicio, Destino);
    }

    @Test
    void getBuses() {
        ArrayList<Bus> buses = new ArrayList<>();
        buses.addAll(recorrido.getBuses());
        assertEquals(5, buses.size());
    }
}