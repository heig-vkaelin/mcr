package figures;

import display.BouncerDisplayer;

import java.awt.*;
import java.util.Random;

public abstract class Figure {
    private final int size;
    private int x, y;
    private int dx, dy;
    private final Color color;
    private static final Random random = new Random();
    
    private static final int MAX_SIZE = 30;
    private static final int MIN_SIZE = 8;
    private static final int MAX_SPEED = 7;
    private static final int MIN_SPEED = -7;
    
    /**
     * Constructeur d'une Figure avec des propriétés aléatoires
     */
    public Figure(Color color) {
        this.color = color;
        
        size = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
        
        x = random.nextInt(BouncerDisplayer.getInstance().getWidth() - size);
        y = random.nextInt(BouncerDisplayer.getInstance().getHeight() - size);
        
        dx = random.nextInt((MAX_SPEED + 1) - MIN_SPEED) + MIN_SPEED;
        dy = random.nextInt((MAX_SPEED + 1) - MIN_SPEED) + MIN_SPEED;
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
        Graphics2D g = BouncerDisplayer.getInstance().getGraphics();
        g.setColor(getColor());
        g.fill(getShape());
    }
    
    public abstract Shape getShape();
}
