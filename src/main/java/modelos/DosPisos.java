package modelos;

public class DosPisos extends Bus{
    private Nivel<Asiento> primerPiso;
    private Nivel<Asiento> segundoPiso;
    private int capacidadNivelUno = 12;
    private int capacidadNivelDos = 20;

    public DosPisos(TipoAsiento nivelUno, TipoAsiento nivelDos){
        primerPiso = new Nivel<>();
        segundoPiso = new Nivel<>();


        for ( int i = 0 ; i < capacidadNivelUno; i++) {
            Asiento asiento = nivelUno.crearAsiento(i+1);
            primerPiso.addAsiento(asiento);
        }

        for (int i = capacidadNivelUno - 1; i < capacidadNivelDos + (capacidadNivelUno-1) ; i++) {
            Asiento asiento = nivelDos.crearAsiento(i+1);
            segundoPiso.addAsiento(asiento);
        }
    }

    @Override
    public Pasaje comprarPasaje(int numero){
        if(numero <= capacidadNivelUno){
            return new Pasaje(primerPiso.getAsiento(numero));
        }
        else{
            return new Pasaje(segundoPiso.getAsiento(numero - capacidadNivelUno));
        }
    }
}
