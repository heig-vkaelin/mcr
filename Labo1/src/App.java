import display.ViewDisplayer;
import factories.FillShapeFactory;
import factories.OutlineShapeFactory;
import bouncers.Bouncable;
import factories.ShapeFactory;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

public class App {
    private final List<Bouncable> bouncers = new LinkedList<>();
    private static final int NB_SHAPES = 10;
    private boolean running = false;
    
    private void addBouncers(ShapeFactory factory) {
        for (int i = 0; i < NB_SHAPES; i++) {
            bouncers.add(factory.createCircle());
            bouncers.add(factory.createSquare());
        }
    }
    
    public void run(int delta) {
        // On évite de pouvoir lancer plusieurs fois l'app
        if (running) return;
        
        ViewDisplayer.getInstance().setTitle("Bouncers");
        
        ViewDisplayer.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_E:
                        bouncers.clear();
                        break;
                    case KeyEvent.VK_B:
                        addBouncers(OutlineShapeFactory.getInstance());
                        break;
                    case KeyEvent.VK_F:
                        addBouncers(FillShapeFactory.getInstance());
                        break;
                    case KeyEvent.VK_Q:
                        System.exit(0);
                }
            }
        });
        
        new Timer(delta, e -> {
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
            ViewDisplayer.getInstance().repaint();
        }).start();
        running = true;
    }
    
    public static void main(String[] args) {
        int DELTA_MS = 20;
        new App().run(DELTA_MS);
    }
}
