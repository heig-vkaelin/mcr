package figures;

import rendering.Renderable;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {
    public Circle(Renderable renderer) {
        super(renderer, Color.BLUE);
    }
    
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }
}
