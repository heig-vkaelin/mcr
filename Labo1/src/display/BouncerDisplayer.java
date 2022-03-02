package display;

import figures.Circle;
import figures.Figure;
import figures.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class BouncerDisplayer implements ActionListener, Displayer {
    private final JPanel panel;
    private final JFrame frame;
    BufferedImage image;
    
    private final List<Figure> figures;
    private static BouncerDisplayer instance;
    private static final int NB_SHAPES = 10;
    private static final int INITIAL_WIDTH = 640;
    private static final int INITIAL_HEIGHT = 480;
    
    private BouncerDisplayer() {
        frame = new JFrame();
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.setContentPane(panel);
    
        frame.setVisible(true);
    
        image = (BufferedImage) panel.createImage(getWidth(), getHeight());
    
        figures = new LinkedList<>();
        
        for (int i = 0; i < NB_SHAPES; i++) {
            figures.add(new Circle(this));
            figures.add(new Square(this));
        }
    }
    
    public static BouncerDisplayer getInstance() {
        if (instance == null)
            instance = new BouncerDisplayer();
        return instance;
    }
    
//    public Dimension getPreferredSize() {
//        return new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT);
//    }
    
    public void paintComponent(Graphics g) {
//        super.paintComponent(g);

//        for (Figure f : figures) {
//            g.setColor(f.getColor());
//            f.draw(g);
//        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("UPDATE");
        for (Figure f : figures) {
            f.move();
            getGraphics().setColor(f.getColor());
            f.draw();
        }
        repaint();
    }
    
    @Override
    public int getWidth() {
        return panel.getWidth();
    }
    
    @Override
    public int getHeight() {
        return panel.getHeight();
    }
    
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }
    
    @Override
    public void repaint() {
//        getGraphics().setColor(Color.RED);
//        getGraphics().fillRect(20, 20, 20 ,20);
//        System.out.println(image);
        getGraphics().drawImage(image, 0, 0, null);
        image = (BufferedImage) panel.createImage(getWidth(), getHeight());
    }
    
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
