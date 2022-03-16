package bouncers;

import rendering.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Square extends Bouncer {
    public Square(Renderer renderer) {
        super(renderer);
    }
    
    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
