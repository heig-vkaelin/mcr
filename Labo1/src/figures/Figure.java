package figures;

import display.BouncerDisplayer;
import rendering.Renderable;
import utils.Utils;

import java.awt.*;

public abstract class Figure implements Bouncable {
    private final int size;
    private int x, y;
    private int dx, dy;
    private final Renderable renderer;
    private final Color color;
    
    private static final int MAX_SIZE = 30;
    private static final int MIN_SIZE = 8;
    private static final int MAX_SPEED = 7;
    private static final int MIN_SPEED = -7;
    
    /**
     * Constructeur d'une Figure avec des propriétés aléatoires
     */
    public Figure(Renderable renderer, Color color) {
        this.renderer = renderer;
        this.color = color;
        
        size = Utils.getRandomBetween(MIN_SIZE, MAX_SIZE);
        
        x = Utils.getRandom(BouncerDisplayer.getInstance().getWidth() - size);
        y = Utils.getRandom(BouncerDisplayer.getInstance().getHeight() - size);
        
        dx = Utils.getRandomBetween(MIN_SPEED, MAX_SPEED + 1);
        dy = Utils.getRandomBetween(MIN_SPEED, MAX_SPEED + 1);
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
    
    public Color getColor() {
        return color;
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
    
    @Override
    public Renderable getRenderer() {
        return renderer;
    }
    
    public abstract Shape getShape();
}
