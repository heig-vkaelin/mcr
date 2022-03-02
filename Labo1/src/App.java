import display.BouncerDisplayer;
import figures.Circle;
import figures.Figure;
import figures.Square;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class App implements ActionListener {
    private final java.util.List<Figure> figures = new LinkedList<>();
    private static final int NB_SHAPES = 10;
    
    public App() {
        BouncerDisplayer.getInstance().setTitle("Bouncers");
        
        for (int i = 0; i < NB_SHAPES; i++) {
            figures.add(new Circle());
            figures.add(new Square());
        }
    }
    
    public void loop(int delta) {
        new Timer(delta, this).start();
    }
    
    public static void main(String[] args) {
        int DELTA_MS = 50;
        new App().loop(DELTA_MS);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("UPDATE");
        for (Figure f : figures) {
            f.move();
            f.draw();
        }
        BouncerDisplayer.getInstance().repaint();
    }
}
