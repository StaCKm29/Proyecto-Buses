package vistas;

import modelos.Asiento;
import modelos.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 * Clase ImageAsiento que se utilizará para mostrar un asiento gráficamente
 */
public class ImageAsiento extends JPanel implements MouseListener {
    private ArrayList<Integer> asientosSeleccionados;
    private ImageIcon iconDisponible;
    private ImageIcon iconOcupado;
    private ImageIcon iconSeleccionado;
    private Asiento asiento;
    private JLabel label;
    private boolean seleccionado;
    private JWindow ventanita;
    private MenuInformacion menuInformacion;
    /**
     * Constructor de la clase ImageAsiento
     * @param asiento Asiento a mostrar
     * @param asientosSeleccionados ArrayList con los asientos seleccionados
     */
    public ImageAsiento(Asiento asiento, ArrayList<Integer> asientosSeleccionados, MenuInformacion menuInformacion){
        int ancho = 30;
        int alto = 30;
        this.menuInformacion = menuInformacion;
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
    /**
     * Método que actualiza el icono del asiento
     */
    public void updateIcon() {
        if (asiento.getEstado()) {
            label.setIcon(iconOcupado);
        } else if (seleccionado) {
            label.setIcon(iconSeleccionado);
        } else {
            label.setIcon(iconDisponible);
        }
    }
    /**
     * Método que modifica el ArrayList de los asientos seleccionados si es que el asiento es seleccionado
     * o deseleccionado
     */
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
        menuInformacion.actualizarInformacion();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    /**
     * Método que muestra información del asiento al pasar el mouse por encima
     */
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
    /**
     * Método que cierra la ventana de información al salir del asiento
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (ventanita != null) {
            ventanita.dispose();
            ventanita = null;
        }
    }
}
