import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * Clase que genera un Árbol de Pitágoras fractal usando recursión.
 * Muestra tres árboles con diferentes niveles de profundidad (6, 8 y 10).
 */
public class PythagorasTree extends JPanel {
    private int profundidad;  // Niveles de recursión (profundidad del árbol)
    private Color color;      // Color del árbol

    /**
     * Constructor del árbol fractal
     * @param profundidad Número de niveles recursivos (ej: 6, 8, 10)
     */
    public PythagorasTree(int profundidad, Color color) {
        this.profundidad = profundidad;
        this.color = color;
        setPreferredSize(new Dimension(400, 400));  // Tamaño del panel
        setBackground(Color.BLACK);                 // Fondo negro
    }
    /**
     * Método de dibujo automático (llamado por Swing)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Configuración para líneas suaves:
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                           RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        
        // Inicia la recursión desde la base del árbol:
        trazaArbol(g2d, getWidth()/2, getHeight()-50, 60, -90, profundidad);
    }
    /**
     * Método recursivo que dibuja el árbol fractal
     *  g Objeto Graphics2D para dibujar
     * x,y Coordenadas iniciales
     * lado Longitud de la línea actual
     * angulo Ángulo de inclinación (grados)
     * nivel Nivel de recursión restante
     */
    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        // Caso base: detiene la recursión
        if (nivel == 0 || lado < 1) return;
        // Calcula punto final de la línea
        int x2 = x + (int)(lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int)(lado * Math.sin(Math.toRadians(angulo)));
        // Dibuja la línea actual
        g.drawLine(x, y, x2, y2);
        // Reduce el tamaño para las ramas
        int nuevoLado = (int)(lado * 0.7);
                // Llamadas recursivas para las ramas izquierda y derecha:
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);  // Rama izquierda
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);  // Rama derecha
    }
    public static void main(String[] args) {
        // Configuración de la ventana principal
        JFrame frame = new JFrame("Árboles de Pitágoras");
        frame.setLayout(new GridLayout(1, 3));  // 3 árboles en una fila
                // Crea árboles con diferentes niveles y colores:
        frame.add(new PythagorasTree(6, Color.GREEN));   // Árbol de 6 niveles (verde)
        frame.add(new PythagorasTree(8, Color.CYAN));    // Árbol de 8 niveles (cian)
        frame.add(new PythagorasTree(10, Color.ORANGE)); // Árbol de 10 niveles (naranja)
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();                   // Ajusta tamaño automáticamente
        frame.setLocationRelativeTo(null);  // Centra la ventana
        frame.setVisible(true);         // Muestra la ventana
    }
}