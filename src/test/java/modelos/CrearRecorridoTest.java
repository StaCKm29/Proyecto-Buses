package modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CrearRecorridoTest {
    private CrearRecorrido recorrido;
    @BeforeEach
    void setUp() {
        Localidades Inicio = Localidades.CHILLAN;
        Localidades Destino = Localidades.CONCEPCION;
        this.recorrido = new CrearRecorrido(Inicio, Destino, LocalDate.now());
    }

    @Test
    void getBuses() {
        ArrayList<Bus> buses = new ArrayList<>();
        buses.addAll(recorrido.getBuses());
        assertEquals(3, buses.size());
    }
}