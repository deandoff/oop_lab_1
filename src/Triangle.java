import javax.swing.*;
import java.awt.*;

public class Triangle extends JPanel {
    private int x1, x2, x3, y1, y2, y3;
    private final Color color;
    private boolean vision;

    public Triangle(int x1, int x2, int x3, int y1, int y2, int y3, Color color) {
        setLayout(null);
        setOpaque(false);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.color = color;
    }

    public void Move(int x, int y){
        x1 += x;
        x2 += x;
        x3 += x;
        y1 += y;
        y2 += y;
        y3 += y;
    }

    public void ChangeSize(int x, int y) {
        x1 -= x;
        x3 += x;
        y1 -= y;
        y3 -= y;
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
        component.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
    }

}
