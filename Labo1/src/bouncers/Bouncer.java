package bouncers;

import display.BouncerDisplayer;
import rendering.Renderer;
import utils.Utils;

import java.awt.*;

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
     */
    public Bouncer(Renderer renderer) {
        this.renderer = renderer;
        
        size = Utils.getRandomBetween(MIN_SIZE, MAX_SIZE);
        
        x = Utils.getRandom(BouncerDisplayer.getInstance().getWidth() - size);
        y = Utils.getRandom(BouncerDisplayer.getInstance().getHeight() - size);
        
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
        BouncerDisplayer display = BouncerDisplayer.getInstance();
        x += dx;
        y += dy;
        
        // Collisions
        if (x + size >= display.getWidth() || x <= 0) {
            dx = -dx;
        }
        
        if (y + size >= display.getHeight() || y <= 0) {
            dy = -dy;
        }
    }
    
    public void draw() {
        renderer.display(BouncerDisplayer.getInstance().getGraphics(), this);
    }
    
    public abstract Color getColor();
    
    public abstract Shape getShape();
}
