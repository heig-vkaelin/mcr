import display.BouncerDisplayer;
import figures.Circle;
import figures.Figure;
import figures.Square;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class App implements ActionListener {
    private final List<Figure> figures;
    private static final int NB_SHAPES = 10;
    
    public App() {
        BouncerDisplayer.getInstance().setTitle("Bouncers");
        
        figures = new LinkedList<>();
        for (int i = 0; i < NB_SHAPES; i++) {
            figures.add(new Circle());
            figures.add(new Square());
        }
    }
    
    public void loop(int delta) {
        new Timer(delta, this).start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Figure f : figures) {
            f.move();
            f.draw();
        }
        BouncerDisplayer.getInstance().repaint();
    }
    
    public static void main(String[] args) {
        int DELTA_MS = 20;
        new App().loop(DELTA_MS);
    }
}
