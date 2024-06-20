package vistas;

import modelos.Asiento;
import modelos.Bus;
import modelos.TipoAsiento;
import modelos.UnPiso;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DatosPersonales extends JPanel {
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField rutTexto;
    private String nombre;
    private String apellido;
    private String rut;

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

    public String getNombre(){
        return nombreTexto.getText();
    }

    public String getApellido(){
        return apellidoTexto.getText();
    }

    public String getRut(){
        return rutTexto.getText();
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Asientos en un piso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        DatosPersonales DatosPersonales = new DatosPersonales();
        frame.add(DatosPersonales);
        frame.setVisible(true);
    }
}
