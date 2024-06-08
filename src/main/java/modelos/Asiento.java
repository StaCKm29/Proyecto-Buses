package modelos;

public abstract class Asiento {
    private int numero;
    private boolean estado;

    public Asiento(int numero) {
        this.numero = numero;
        this.estado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getEstado() {
        return estado;
    }

    public void Ocupar(){
        this.estado = true;
    }

    public abstract String getTipo();

}
