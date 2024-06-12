package modelos;

public class Pasaje {
    private Asiento asiento;
    private String nombre;
    private String apellido;
    private String rut;
    private int precioTotal;

    public Pasaje(Asiento asiento, int precioTotal){
        this.asiento = asiento;
        this.precioTotal = precioTotal;
    }

    public void setDatos(String nombre, String apellido, String rut){
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public Asiento getAsiento(){
        return asiento;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getRut(){
        return rut;
    }
    public int getPrecioTotal(){
        return precioTotal;
    }
    
}
