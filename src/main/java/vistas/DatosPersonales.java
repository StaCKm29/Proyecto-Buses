package vistas;

import javax.swing.*;
import java.awt.*;
/**
 * Clase DatosPersonales que se utilizará para que se ingresen los datos personales de un pasajero
 */
public class DatosPersonales extends JPanel {
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField rutTexto;

    /**
     * Constructor de la clase DatosPersonales
     */
    public DatosPersonales(){
        JLabel nombre = new JLabel("Nombre:");
        this.nombreTexto = new JTextField();
        JLabel apellido = new JLabel("Apellido:");
        this.apellidoTexto = new JTextField();
        JLabel rut = new JLabel("Rut:");
        this.rutTexto = new JTextField();
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(3, 2));
        contenedor.add(nombre);
        contenedor.add(nombreTexto);
        contenedor.add(apellido);
        contenedor.add(apellidoTexto);
        contenedor.add(rut);
        contenedor.add(rutTexto);
        contenedor.setPreferredSize(new Dimension(200, 100));
        add(contenedor);
    }

    /**
     * Método que retorna el nombre ingresado.
     * @return String con el nombre ingresado.
     * @throws DatosVaciosException si el nombre está vacío.
     */
    public String getNombre() throws DatosVaciosException{
        String nombre = nombreTexto.getText();
        if (nombre == null || nombre.trim().isEmpty()){
            throw new DatosVaciosException("Su nombre no puede estar vacío.");
        }
        return nombre;
    }

    /**
     * Método que retorna el apellido ingresado.
     * @return String con el apellido ingresado.
     * @throws DatosVaciosException si el apellido está vacío.
     */
    public String getApellido() throws DatosVaciosException{
        String apellido = apellidoTexto.getText();
        if (apellido == null || apellido.trim().isEmpty()){
            throw new DatosVaciosException("Su apellido no puede estar vacío.");
        }
        return apellido;
    }

    /**
     * Método que retorna el rut ingresado.
     * @return String con el rut ingresado.
     * @throws DatosVaciosException si el rut está vacío.
     */
    public String getRut() throws DatosVaciosException{
        String rut = rutTexto.getText();
        if (rut == null || rut.trim().isEmpty()){
            throw new DatosVaciosException("Su rut no puede estar vacío.");
        }
        return rut;
    }

}
