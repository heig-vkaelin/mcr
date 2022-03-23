import display.ViewDisplayer;
import factories.FillBouncerFactory;
import factories.OutlineBouncerFactory;
import bouncers.Bouncable;
import factories.BouncerFactory;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe principale de l'application. Ouvre la fenêtre.
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class Bouncers {
    private final List<Bouncable> bouncers = new LinkedList<>();
    private static final int NB_SHAPES = 10;
    private boolean running = false;
    
    /**
     * Ajoute un nombre de Bouncers de la fabrique souhaitée
     *
     * @param factory : la fabrique à utiliser
     */
    private void addBouncers(BouncerFactory factory) {
        for (int i = 0; i < NB_SHAPES; i++) {
            bouncers.add(factory.createCircle());
            bouncers.add(factory.createSquare());
        }
    }
    
    /**
     * Démarre le rafraîchissement de l'application. Ecoute les entrées utilisateurs.
     *
     * @param delta : ms entre deux rafraîchissements
     */
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
                        addBouncers(OutlineBouncerFactory.getInstance());
                        break;
                    case KeyEvent.VK_F:
                        addBouncers(FillBouncerFactory.getInstance());
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
    
    /**
     * Démarre l'application
     *
     * @param args : arguments passés lors de l'exécution, non utilisés ici
     */
    public static void main(String[] args) {
        int DELTA_MS = 20;
        new Bouncers().run(DELTA_MS);
    }
}
