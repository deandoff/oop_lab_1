import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame = new JFrame("Lab_1");
    private final JButton back_btn = new JButton("Назад"); //0
    private final JButton line_btn = new JButton("Линия"); //1
    private final JButton circle_btn = new JButton("Окружность"); //2
    private final JButton rectangle_btn = new JButton("Прямоугольник"); //3
    private final JButton triangle_btn = new JButton("Треугольник"); //4
    private final JButton create_btn = new JButton("Создать"); //5
    private final JButton move_btn = new JButton("Передвинуть"); //6
    private final JButton remove_btn = new JButton("Удалить объект"); //7
    private final JButton csize_btn = new JButton("Изменить размер"); //8
    private final JButton array_btn = new JButton("Массив"); //9

    private final JPanel Canvas = canvas();
    private final JPanel NPanel = navigation_panel();
    private JPanel line = null;
    private Line[] lines = null;
    private JPanel circle = null;

    private Circle[] circles = null;
    private JPanel rectangle = null;
    private Rectangle[] rectangles = null;
    private JPanel triangle = null;
    private Triangle[] triangles = null;

    private int btn_num;

    private Main() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1920,1080);
        frame.add(Canvas, BorderLayout.CENTER);
        frame.add(NPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel canvas() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        canvas.setBackground(Color.WHITE);
        return canvas;
    }

    private void SetDefaultMenu(JPanel panel){
        panel.removeAll();
        panel.add(line_btn);
        panel.add(rectangle_btn);
        panel.add(circle_btn);
        panel.add(triangle_btn);
    }

    private void SetLineMenu(JPanel panel){
        panel.removeAll();
        panel.add(back_btn);
        panel.add(create_btn);
        panel.add(move_btn);
        panel.add(remove_btn);
        panel.add(array_btn);
        panel.revalidate();
        panel.repaint();
    }
    private void SetShapeMenu(JPanel panel){
        panel.removeAll();
        panel.add(back_btn);
        panel.add(create_btn);
        panel.add(move_btn);
        panel.add(csize_btn);
        panel.add(remove_btn);
        panel.add(array_btn);
        panel.revalidate();
        panel.repaint();
    }

    private JPanel navigation_panel() {
        JPanel NPanel = new JPanel();
        NPanel.setLayout(new FlowLayout());
        NPanel.setBackground(Color.lightGray);
        SetDefaultMenu(NPanel);

        back_btn.addActionListener(e -> {
            SetDefaultMenu(NPanel);
            NPanel.revalidate();
            NPanel.repaint();

        });

        line_btn.addActionListener(e -> {
            SetLineMenu(NPanel);
            btn_num = 1;
        });

        rectangle_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 2;
        });

        circle_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 3;
        });

        triangle_btn.addActionListener(e -> {
            SetShapeMenu(NPanel);
            btn_num = 4;
        });

        array_btn.addActionListener(e -> {
            if (btn_num == 1){
                    JOptionPane.showMessageDialog(frame, "Выбран массив линий");
                    NPanel.remove(array_btn);
                    btn_num = 5;
            }
            else if (btn_num == 2) {
                    JOptionPane.showMessageDialog(frame, "Выбран массив прямоугольников");
                    NPanel.remove(array_btn);
                    btn_num = 6;
            }
            else if (btn_num == 3) {
                    JOptionPane.showMessageDialog(frame, "Выбран массив окружностей");
                    NPanel.remove(array_btn);
                    btn_num = 7;
            }
            else if (btn_num == 4) {
                    JOptionPane.showMessageDialog(frame, "Выбран массив треугольников");
                    NPanel.remove(array_btn);
                    btn_num = 8;
            }
            NPanel.revalidate();
            NPanel.repaint();
        });

        remove_btn.addActionListener(e -> {
            if (btn_num == 1) {
                if (line != null) {
                    Canvas.remove(line);
                    line = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 2) {
                if (rectangle != null) {
                    Canvas.remove(rectangle);
                    rectangle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 3) {
                if (circle != null) {
                    Canvas.remove(circle);
                    circle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 4) {
                if (triangle != null) {
                    Canvas.remove(triangle);
                    triangle = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 5) {
                if (lines != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(lines[i]);
                        lines[i] = null;
                    }
                    lines = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 6) {
                if (rectangles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(rectangles[i]);
                        rectangles[i] = null;
                    }
                    rectangles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 7) {
                if (circles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(circles[i]);
                        circles[i] = null;
                    }
                    circles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
            if (btn_num == 8) {
                if (triangles != null) {
                    for (int i = 0; i < 10; i++) {
                        Canvas.remove(triangles[i]);
                        triangles[i] = null;
                    }
                    triangles = null;
                    Canvas.revalidate();
                    Canvas.repaint();
                }
            }
        });

        create_btn.addActionListener(e -> {
            int x1 = (int) (Math.random() * 500);
            int x2 = (int) (Math.random() * 500);
            int x3 = (int) (Math.random() * 500);
            int y1 = (int) (Math.random() * 500);
            int y2 = (int) (Math.random() * 500);
            int y3 = (int) (Math.random() * 500);

            if (btn_num == 1) {
                if (line == null) {
                    line = new Line (x1, y1, x2, y2, Color.cyan);
                    Canvas.add(line, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 2) {
                if (rectangle == null) {
                    rectangle = new Rectangle (x1, y1, x2, y2, Color.black);
                    Canvas.add(rectangle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 3) {
                if (circle == null) {
                    circle = new Circle (x1, x2, x3, Color.green);
                    Canvas.add(circle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 4) {
                if (triangle == null) {
                    triangle = new Triangle (x1, x2, x3, y1, y2, y3, Color.red);
                    Canvas.add(triangle, BorderLayout.CENTER);
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 5) {
                if (lines == null) {
                    lines = new Line[10];
                    for (int i = 0; i < 10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        y2 = (int) (Math.random() * 500);
                        lines[i] = new Line(x1, y1, x2, y2, Color.cyan);
                        Canvas.add(lines[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
            else if (btn_num == 6) {
                if (rectangles == null) {
                    rectangles = new Rectangle[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        y2 = (int) (Math.random() * 500);
                        rectangles[i] = new Rectangle (x1, y1, x2, y2, Color.black);
                        Canvas.add(rectangles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }

            }
            else if (btn_num == 7) {
                if (circles == null) {
                    circles = new Circle[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        x3 = (int) (Math.random() * 500);
                        circles[i] = new Circle (x1, x2, x3, Color.green);
                        Canvas.add(circles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }

            }
            else if (btn_num == 8) {
                if (triangles == null) {
                    triangles = new Triangle[10];
                    for (int i=0; i<10; i++) {
                        x1 = (int) (Math.random() * 500);
                        x2 = (int) (Math.random() * 500);
                        x3 = (int) (Math.random() * 500);
                        y1 = (int) (Math.random() * 500);
                        y2 = (int) (Math.random() * 500);
                        y3 = (int) (Math.random() * 500);
                        triangles[i] = new Triangle(x1, x2, x3, y1, y2, y3, Color.red);
                        Canvas.add(triangles[i], BorderLayout.CENTER);
                        Canvas.validate();
                        Canvas.repaint();
                    }
                    Canvas.revalidate();
                }
            }
        });

        return NPanel;
    }

    public static void main(String[] argc) {
        SwingUtilities.invokeLater(Main::new);
    }
}