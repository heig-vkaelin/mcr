import figures.Circle;
import figures.Figure;
import figures.Square;
import utils.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class JBouncer extends JPanel implements ActionListener {
    private final List<Figure> figures;
    private final Timer timer;
    
    JBouncer() {
        setBackground(Color.WHITE);
        figures = new LinkedList<>();
        timer = new Timer(50, this);
        initShapes();
    }
    
    public void start() {
        timer.start();
    }
    
    private void initShapes() {
        // TODO:
        // - nbr random de chaque type, comment bien faire si + de 2 types ??
        // - taille random entre 2 limites
        // - position random entre 2 limites
        // - vitesse random entre 2 limites
        int NB_SHAPES = 10;
        for (int i = 0; i < NB_SHAPES; i++) {
            figures.add(new Circle(20, new Vector(20, 20), new Vector(4, 4)));
        }
        for (int i = 0; i < NB_SHAPES; i++) {
            figures.add(new Square(20, new Vector(40, 40), new Vector(6, 7)));
        }
    }
    
    public Dimension getPreferredSize() {
        // TODO: enlever les valeurs en dur
        return new Dimension(640, 480);
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
        int width = getWidth();
        int height = getHeight();
        
        for (Figure f : figures) {
            f.setPosition(f.getPosition().add(f.getDirection()));
            
            // Collisions
            if (f.getPosition().getX() + f.getSize() >= width
                    || f.getPosition().getX() <= 0) {
                f.setDirection(f.getDirection().multiply(new Vector(-1, 1)));
            }
            
            if (f.getPosition().getY() + f.getSize() >= height
                    || f.getPosition().getY() <= 0) {
                f.setDirection(f.getDirection().multiply(new Vector(1, -1)));
            }
        }
        repaint();
    }
}
