package vistas;

import modelos.Asiento;
import modelos.TipoAsiento;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImageAsiento extends JPanel implements MouseListener {
    private ImageIcon iconDisponible;
    private ImageIcon iconOcupado;
    private ImageIcon iconSeleccionado;
    private Asiento asiento;
    private JLabel label;
    private boolean seleccionado;

    public ImageAsiento(Asiento asiento) {
        this.asiento = asiento;
        this.seleccionado = false; // Inicialmente no seleccionado

        // Cargar las imágenes de los iconos
        iconDisponible = new ImageIcon(getClass().getResource("/AsientoDisponible.png"));
        iconOcupado = new ImageIcon(getClass().getResource("/AsientoOcupado.png"));
        iconSeleccionado = new ImageIcon(getClass().getResource("/AsientoSeleccionado.png"));

        // Configurar el icono inicial basado en el estado del asiento
        label = new JLabel();
        updateIcon();

        add(label);
        addMouseListener(this);
    }

    private void updateIcon() {
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Asiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        Asiento semicama = TipoAsiento.SEMICAMA.crearAsiento(1);

        ImageAsiento imageAsiento = new ImageAsiento(semicama);
        frame.add(imageAsiento);

        frame.setVisible(true);
    }
}
