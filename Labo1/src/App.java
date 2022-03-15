import display.BouncerDisplayer;
import figures.Bouncable;
import figures.Circle;
import figures.Square;
import rendering.FillShapeRenderer;
import rendering.OutlineShapeRenderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class App implements ActionListener {
    private final List<Bouncable> bouncers;
    private static final int NB_SHAPES = 10;
    
    public App() {
        BouncerDisplayer.getInstance().setTitle("Bouncers");
        
        bouncers = new LinkedList<>();
        for (int i = 0; i < NB_SHAPES; i++) {
            // TODO: change renderer here
            bouncers.add(new Circle(new FillShapeRenderer()));
            bouncers.add(new Square(new OutlineShapeRenderer()));
        }
    }
    
    public void run(int delta) {
        new Timer(delta, this).start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Bouncable b : bouncers) {
            b.move();
            b.draw();
        }
        BouncerDisplayer.getInstance().repaint();
    }
    
    public static void main(String[] args) {
        int DELTA_MS = 20;
        new App().run(DELTA_MS);
    }
}
