package vistas;

import modelos.Asiento;
import modelos.Bus;
import modelos.TipoAsiento;
import modelos.UnPiso;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AsientosEnUnPiso extends JPanel {
    private ArrayList<Asiento> asientos;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private Image asientoDisponible;
    private Image asientoOcupado;

    public AsientosEnUnPiso(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
        asientoDisponible = new ImageIcon(getClass().getResource("/AsientoDisponible.png")).getImage();
        asientoOcupado = new ImageIcon(getClass().getResource("/AsientoOcupado.png")).getImage();
        // Escalar las imágenes
        asientoDisponible = asientoDisponible.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        asientoOcupado = asientoOcupado.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = 10; // coordenada inicial x
        int y = 10; // coordenada inicial y
        int padding = 10; // espacio entre los asientos
        int asientosPorFila = asientos.size() / 2; // cantidad de asientos por fila
        int asientoActual = 0; // contador de asientos

        for (Asiento asiento : asientos) {
            Image img = asiento.getEstado() ? asientoOcupado : asientoDisponible;
            g2d.drawImage(img, x, y, this);
            y += HEIGHT + padding; // mover hacia abajo para el próximo asiento
            asientoActual++; // incrementar el contador de asientos

            // Si se ha alcanzado la cantidad de asientos por fila, comenzar una nueva fila
            if (asientoActual == asientosPorFila) {
                asientoActual = 0;
                y = 10;
                x += WIDTH + padding; // mover hacia la derecha para la próxima columna
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Asientos en un piso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        Bus bus = new UnPiso(4000, TipoAsiento.SEMICAMA);
        ArrayList<Asiento> asientos = bus.getAsientos(1);
        asientos.get(3).Ocupar();
        asientos.get(5).Ocupar();

        AsientosEnUnPiso asientosEnUnPiso = new AsientosEnUnPiso(asientos);
        frame.add(asientosEnUnPiso);

        frame.setVisible(true);
    }

}
