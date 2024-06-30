package vistas;

import modelos.Asiento;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Clase AsientosEnUnPiso que se utilizará para mostrar los asientos de un piso de un bus.
 */
public class AsientosEnUnPiso extends JPanel {
    private ArrayList<Asiento> asientos;
    private ArrayList<ImageAsiento>  asientosgraficos;
    private ArrayList<Integer> asientosSeleccionados = new ArrayList<>();

    /**
     * Constructor de la clase AsientosEnUnPiso
     * @param asientos ArrayList de asientos
     * @param piso String con el numero de piso del bus
     */
    public AsientosEnUnPiso(ArrayList<Asiento> asientos, String piso, MenuInformacion menuInformacion) {
        this.asientos = asientos;
        //Creacion de arreglo gráfico
        this.asientosgraficos = new ArrayList<>();
        this.setBackground(Color.BLACK);
        for(Asiento asiento: asientos){
            ImageAsiento asientoGrafico = new ImageAsiento(asiento , asientosSeleccionados,menuInformacion);
            asientosgraficos.add(asientoGrafico);
        }

        //Se crea panel contenedor de los asientos
        JPanel columna1 = new JPanel();
        JPanel columna2 = new JPanel();
        JPanel pasillo = new JPanel();
        JPanel columna3 = new JPanel();
        columna1.setLayout(new GridLayout(asientos.size()/3, 1));
        columna2.setLayout(new GridLayout(asientos.size()/3, 1));
        pasillo.setLayout(new GridLayout(asientos.size()/3, 1));
        columna3.setLayout(new GridLayout(asientos.size()/3, 1));
        Image pasilloImage = new ImageIcon(getClass().getResource("/pasillo.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);

        //Se agregan los asientos al panel contenedor
        for(int i = 0; i < asientosgraficos.size(); i++){
            columna1.add(asientosgraficos.get(i));
            i++;
            columna2.add(asientosgraficos.get(i));
            i++;
            pasillo.add(new JLabel(new ImageIcon(pasilloImage)));
            columna3.add(asientosgraficos.get(i));
        }

        //Se agregan los paneles al contenedor
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(1, 4));
        contenedor.add(columna1);
        contenedor.add(columna2);
        contenedor.add(pasillo);
        contenedor.add(columna3);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(piso), BorderLayout.NORTH);
        panel.add(contenedor, BorderLayout.CENTER);
        add(panel);
    }
    /**
     * Método que actualiza los iconos de los asientos
     */
    public void actualizarAsientos(){
        for(int i = 0 ; i<asientosgraficos.size(); i++){
            asientosgraficos.get(i).updateIcon();
        }
    }
    /**
     * Método que retorna los asientos seleccionados
     * @return ArrayList de enteros con los asientos seleccionados
     */
    public ArrayList<Integer> getAsientosSeleccionados(){
        return asientosSeleccionados;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
