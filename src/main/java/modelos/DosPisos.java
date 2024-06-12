package modelos;

public class DosPisos extends Bus{
    private Nivel<Asiento> primerPiso;
    private Nivel<Asiento> segundoPiso;
    private int capacidadNivelUno = 12;
    private int capacidadNivelDos = 20;
    private TipoAsiento nivelUno;
    private TipoAsiento nivelDos;

    public DosPisos(int precioBase, TipoAsiento nivelUno, TipoAsiento nivelDos){
        super(precioBase);
        primerPiso = new Nivel<>();
        segundoPiso = new Nivel<>();
        this.nivelUno = nivelUno;
        this.nivelDos = nivelDos;

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
    public int getPrecioTotal(int num){
        int precioAsiento;
        int precioBus;

        if(num <= capacidadNivelUno){
            precioAsiento = nivelUno.getPrecio();
            precioBus = super.getPrecioBase();
        }
        else{
            precioAsiento = nivelDos.getPrecio();
            precioBus = super.getPrecioBase();
        }
        return precioBus+precioAsiento;
    }

    @Override
    public Pasaje comprarPasaje(int numero, int precioTotal){
        if(numero <= capacidadNivelUno){
            return new Pasaje(primerPiso.adquirirAsiento(numero), precioTotal);
        }
        else{
            return new Pasaje(segundoPiso.adquirirAsiento(numero - capacidadNivelUno), precioTotal);
        }
    }

}
