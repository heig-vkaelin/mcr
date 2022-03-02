package figures;

import display.BouncerDisplayer;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Figure {
    public Circle() {
        super(Color.BLUE);
    }
    
    @Override
    public Shape getShape() {
        // TODO: faire des cercles
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }
}
