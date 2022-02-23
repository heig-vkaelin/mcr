package figures;

import utils.Vector;

import java.awt.*;

public abstract class Figure {
    private final int size;
    private Vector position;
    private Vector direction;
    private final Color color;
    
    public Figure(int size, Vector position, Vector direction, Color color) {
        this.size = size;
        this.position = position;
        this.direction = direction;
        this.color = color;
    }
    
    public int getSize() {
        return size;
    }
    
    public Vector getPosition() {
        return position;
    }
    
    public Vector getDirection() {
        return direction;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setPosition(Vector position) {
        this.position = position;
    }
    
    public void setDirection(Vector direction) {
        this.direction = direction;
    }
    
    public abstract void draw(Graphics g);
}
