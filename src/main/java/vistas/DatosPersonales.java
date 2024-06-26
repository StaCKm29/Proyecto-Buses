package vistas;

import modelos.Asiento;
import modelos.Bus;
import modelos.TipoAsiento;
import modelos.UnPiso;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
     * Método que retorna el nombre ingresado
     * @return String con el nombre ingresado
     */
    public String getNombre(){
        return nombreTexto.getText();
    }
    /**
     * Método que retorna el apellido ingresado
     * @return String con el apellido ingresado
     */
    public String getApellido(){
        return apellidoTexto.getText();
    }
    /**
     * Método que retorna el rut ingresado
     * @return String con el rut ingresado
     */
    public String getRut(){
        return rutTexto.getText();
    }

}
