import display.BouncerDisplayer;
import factories.FillShapeFactory;
import factories.OutlineShapeFactory;
import bouncers.Bouncable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class App implements ActionListener {
    private final List<Bouncable> bouncers;
    private static final int NB_SHAPES = 10;
    
    public App() {
        bouncers = new LinkedList<>();
        
        BouncerDisplayer.getInstance().setTitle("Bouncers");
        
        BouncerDisplayer.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_E:
                        bouncers.clear();
                        break;
                    case KeyEvent.VK_B:
                        for (int i = 0; i < NB_SHAPES; i++) {
                            bouncers.add(OutlineShapeFactory.getInstance().createCircle());
                            bouncers.add(OutlineShapeFactory.getInstance().createSquare());
                        }
                        break;
                    case KeyEvent.VK_F:
                        for (int i = 0; i < NB_SHAPES; i++) {
                            bouncers.add(FillShapeFactory.getInstance().createCircle());
                            bouncers.add(FillShapeFactory.getInstance().createSquare());
                        }
                        break;
                    case KeyEvent.VK_Q:
                        System.exit(0);
                }
            }
        });
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
