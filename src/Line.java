import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {
    private int x1, x2, y1, y2;
    private final Color color;
    private boolean vision;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        setLayout(null);
        setOpaque(false);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.repaint();
    }

    public void Move(int x, int y) {
        x1 += x;
        y1 += y;
        x2 += x;
        y2 += y;
    }

    public void ChangeSize(int x) {
        x2 += x;
        y2 += x;
    }

    public void Show(boolean vision) {
        this.vision = vision;
        setVisible(this.vision);
        this.vision = true;
        this.repaint();
    }

    protected void paintComponent(Graphics component){
//        super.paintComponent(component);
        component.setColor(color);
        component.drawLine(x1, y1, x2, y2);
    }

}