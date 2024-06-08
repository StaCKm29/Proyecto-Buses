package modelos;

public class UnPiso extends Bus{
    private Nivel<Asiento> primerPiso;
    private int capacidadNivelUno = 20;

    public UnPiso(TipoAsiento nivelUno){
        primerPiso = new Nivel<>();

        for (int i = 0; i < capacidadNivelUno; i++) {
            Asiento asiento = nivelUno.crearAsiento(i+1);
            primerPiso.addAsiento(asiento);
        }
    }
}
