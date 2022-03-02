package figures;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Figure {
    public Square() {
        super(Color.ORANGE);
    }
    
    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
