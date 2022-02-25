package display;

import figures.Circle;
import figures.Figure;
import figures.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class JBouncer extends JPanel implements ActionListener {
    private final List<Figure> figures;
    private static JBouncer instance;
    private static final int NB_SHAPES = 10;
    private static final int INITIAL_WIDTH = 640;
    private static final int INITIAL_HEIGHT = 480;
    
    public JBouncer() {
        setBackground(Color.WHITE);
        figures = new LinkedList<>();
        
        for (int i = 0; i < NB_SHAPES; i++) {
            figures.add(new Circle(this));
            figures.add(new Square(this));
        }
    }
    
    public static JBouncer getInstance() {
        if (instance == null)
            instance = new JBouncer();
        return instance;
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Figure f : figures) {
            g.setColor(f.getColor());
            f.draw(g);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Figure f : figures) {
            f.move();
        }
        repaint();
    }
}
