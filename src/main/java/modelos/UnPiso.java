package modelos;

public class UnPiso extends Bus{
    private Nivel<Asiento> primerPiso;
    private int capacidadNivelUno = 20;

    public UnPiso(int precioBase, TipoAsiento nivelUno){
        super(precioBase);
        primerPiso = new Nivel<>();

        for (int i = 0; i < capacidadNivelUno; i++) {
            Asiento asiento = nivelUno.crearAsiento(i+1);
            primerPiso.addAsiento(asiento);
        }
    }

    @Override
    public int getPrecioTotal(int num){
        int precioAsiento = primerPiso.getAsiento(num).getPrecio();
        int precioBus = super.getPrecioBase();
        return precioAsiento + precioBus;
    }

    @Override
    public Pasaje comprarPasaje(int numero){
        return new Pasaje(primerPiso.adquirirAsiento(numero));
    }

}

