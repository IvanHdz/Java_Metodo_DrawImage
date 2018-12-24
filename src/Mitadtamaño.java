
/**
 * En este ejemplo se presenta una imagen en pantalla a la mitad de su
 * tamaño real.
 * Cuando se crea la ventana, la imagen no aparece en ese mismo instante
 * sino que hay que esperar a que se termine de realizar la operación de
 * escalado para hacer que aparezca esa imagen en la ventana.
 */

import java.awt.*;
import java.awt.event.*;

// Clase de control del ejemplo
public class Mitadtamaño extends Frame {
    // Referencia a la imagen

    Image imagen;

    // Constructor de la clase
    public Mitadtamaño() {
        this.setTitle("Tutorial de Java, Gráficos");
        this.setSize(275, 250);

        // Recogemos en la variable "imagen" el fichero de imagen que
        // se indica, y que se supone situado en el mismo directorio y
        // disco que la clase del ejemplo
        imagen = Toolkit.getDefaultToolkit().getImage("java1.png");

        // Se hace visible el Frame, que en la pantalla da origen a
        // la ventana, aunque la primera imagen no es visible en el
        // mismo momento en que aparece la ventana en pantalla, porque
        // hasta que se invoque por primera vez el método paint(), no
        // se colocará una imagen en el contendor
        this.setVisible(true);

        // Clase anónima anidada que permite terminar la ejecución del
        // programa, controlando el botón de cierre del Frame
        this.addWindowListener(
                new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                // Se sale al sistema
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // Se instancia un objeto de la clase
        Mitadtamaño mitadtamaño = new Mitadtamaño();
    }

    // Se sobrecarga el método para pintar la imagen
    @Override
    public void paint(Graphics g) {
        // Se traslada el origen para evitar el efecto del borde
        g.translate(this.getInsets().left, this.getInsets().top);

        // Ahora se pinta la imagen a la mitad de su tamaño
        g.drawImage(imagen, 0, 0,
                imagen.getWidth(this) / 2, imagen.getHeight(this) / 2, this);
    }
}
