package vistas;

import modelos.Asiento;
import modelos.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ImageAsiento extends JPanel implements MouseListener {
    private ArrayList<Integer> asientosSeleccionados;
    private ImageIcon iconDisponible;
    private ImageIcon iconOcupado;
    private ImageIcon iconSeleccionado;
    private Asiento asiento;
    private JLabel label;
    private boolean seleccionado;
    private JWindow ventanita;

    public ImageAsiento(Asiento asiento, ArrayList<Integer> asientosSeleccionados) {
        int ancho = 30;
        int alto = 30;

        this.asiento = asiento;
        this.seleccionado = false; // Inicialmente no seleccionado
        this.asientosSeleccionados = asientosSeleccionados;

        // Cargar las imágenes de los iconos
        iconDisponible = new ImageIcon(new ImageIcon(getClass().getResource("/AsientoDisponible.png")).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        iconOcupado = new ImageIcon(new ImageIcon(getClass().getResource("/AsientoOcupado.png")).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        iconSeleccionado = new ImageIcon(new ImageIcon(getClass().getResource("/AsientoSeleccionado.png")).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

        // Configurar el icono inicial basado en el estado del asiento
        label = new JLabel();
        updateIcon();

        add(label);
        addMouseListener(this);
    }

    public void updateIcon() {
        if (asiento.getEstado()) {
            label.setIcon(iconOcupado);
        } else if (seleccionado) {
            label.setIcon(iconSeleccionado);
        } else {
            label.setIcon(iconDisponible);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!asiento.getEstado()) {
            seleccionado = !seleccionado; // Alternar el estado seleccionado
            updateIcon(); // Actualizar el icono en función del nuevo estado
            if (seleccionado) {
                asientosSeleccionados.add(asiento.getNumero());
            } else {
                asientosSeleccionados.remove(asiento.getNumero());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ventanita = new JWindow();
        JLabel info = new JLabel("Asiento " + asiento.getNumero() + " - Tipo: " + asiento.getTipo());
        ventanita.getContentPane().add(info);
        ventanita.pack();
        Point cursor = MouseInfo.getPointerInfo().getLocation();
        ventanita.setLocation(cursor.x, cursor.y);
        ventanita.setVisible(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (ventanita != null) {
            ventanita.dispose();
            ventanita = null;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Asiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        Asiento semicama = TipoAsiento.SEMICAMA.crearAsiento(1);

        ImageAsiento imageAsiento = new ImageAsiento(semicama, new ArrayList<>());
        frame.add(imageAsiento);

        frame.setVisible(true);
    }
}
