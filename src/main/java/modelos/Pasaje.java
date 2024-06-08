package modelos;

public class Pasaje {
    private Asiento asiento;
    private String nombre;
    private String apellido;
    private String rut;

    public Pasaje(Asiento asiento){
        this.asiento = asiento;
    }

    public void setDatos(String nombre, String apellido, String rut){
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }
    
}
