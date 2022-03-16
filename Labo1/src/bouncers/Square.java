package bouncers;

import rendering.Renderable;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Bouncer {
    public Square(Renderable renderer) {
        super(renderer, Color.ORANGE);
    }
    
    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
