package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MismaLocalidadException, LocalidadNullException {
        LocalDate fechaViaje = LocalDate.of(2024, 06, 14);
        Localidades partida = Localidades.FRUTILLAR;
        Localidades destino = Localidades.SANTIAGO;
        CrearRecorrido recorrido = new CrearRecorrido(partida, destino, fechaViaje);

        Cliente Marcos = new Cliente("Marcos", "Martínez", "21.351.870-4", recorrido.getBuses().get(0), new ArrayList<>(Arrays.asList(1, 2, 3)));
    }
}