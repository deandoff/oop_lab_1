import javax.swing.*;
import java.awt.*;
public class Rectangle extends JPanel {
    private int x, y, w, h;
    private final Color color;

    public Rectangle(int x, int y, int w, int h, Color color) {
        setLayout(null);
        setOpaque(false);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public void Move(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void ChangeSize(int x, int y){
        w += x;
        h += y;
    }
    public void Show(boolean vision) {
        setVisible(vision);
        this.repaint();
    }

    protected void paintComponent(Graphics component) {
        component.setColor(color);
        component.drawRect(x, y, w, h);
    }
}
