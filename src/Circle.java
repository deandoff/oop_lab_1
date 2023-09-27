import javax.swing.*;
import java.awt.*;


public class Circle extends JPanel {
    private int x, y, d;
    private final Color color;

    public Circle(int x, int y, int d, Color color) {
        setLayout(null);
        setOpaque(false);
        this.x = x;
        this.y = y;
        this.d = d;
        this.color = color;
    }

    public void Move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }
    public void ChangeRadius(int d) {
        this.d = d;
    }

    protected void paintComponent(Graphics component) {
//        super.paintComponent(component);
        component.setColor(color);
        component.drawOval(x-d/2, y-d/2, d, d);
    }
}
