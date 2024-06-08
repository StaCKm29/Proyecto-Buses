package modelos;

public abstract class Asiento {
    private int numero;
    private String ubicacion;
    private boolean estado;

    public Asiento(int numero, String ubicacion) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.estado = false;
    }

    public int getNumero() {
        return numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void Ocupar(){
        this.estado = true;
    }

    public abstract int getPrecio();
    public abstract String getTipo();

}
