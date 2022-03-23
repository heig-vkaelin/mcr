package bouncers;

import display.ViewDisplayer;
import rendering.Renderer;
import utils.Utils;

import java.awt.*;

/**
 * Classe abstraite représentant les différentes formes mouvantes à afficher dans
 * l'application.
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public abstract class Bouncer implements Bouncable {
    private final int size;
    private int x, y;
    private int dx, dy;
    private final Renderer renderer;
    
    private static final int MAX_SIZE = 30;
    private static final int MIN_SIZE = 8;
    private static final int MAX_SPEED = 8;
    private static final int MIN_SPEED = -7;
    
    /**
     * Constructeur d'un Bouncer avec des propriétés aléatoires
     *
     * @param renderer : renderer à utiliser lors de l'affichage du Bouncer
     */
    public Bouncer(Renderer renderer) {
        this.renderer = renderer;
        
        size = Utils.getRandomBetween(MIN_SIZE, MAX_SIZE);
        
        x = Utils.getRandom(ViewDisplayer.getInstance().getWidth() - size);
        y = Utils.getRandom(ViewDisplayer.getInstance().getHeight() - size);
        
        dx = Utils.getRandomBetween(MIN_SPEED, MAX_SPEED);
        dy = Utils.getRandomBetween(MIN_SPEED, MAX_SPEED);
    }
    
    public int getSize() {
        return size;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void move() {
        ViewDisplayer display = ViewDisplayer.getInstance();
        int width = display.getWidth();
        int height = display.getHeight();
        x += dx;
        y += dy;
        
        // Collisions
        if (x >= width - size || x <= 0) {
            x = x <= 0 ? 0 : width - size;
            dx = -dx;
        }
        
        if (y >= height - size || y <= 0) {
            y = y <= 0 ? 0 : height - size;
            dy = -dy;
        }
    }
    
    public void draw() {
        renderer.display(ViewDisplayer.getInstance().getGraphics(), this);
    }
    
    public abstract Color getColor();
    
    public abstract Shape getShape();
}
