package figures;

import display.BouncerDisplayer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Figure {
    public Square(BouncerDisplayer bouncer) {
        super(bouncer, Color.ORANGE);
    }
    
    @Override
    public void draw() {
        BouncerDisplayer.getInstance().getGraphics().setColor(getColor());
    
        Rectangle2D shape = new Rectangle2D.Double(getX(), getY(), getSize(),
                getSize());
    
        BouncerDisplayer.getInstance().getGraphics()
                .fill(shape);
    }
}
