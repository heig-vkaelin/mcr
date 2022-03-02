package figures;

import display.BouncerDisplayer;

import java.awt.*;

public class Circle extends Figure {
    public Circle(BouncerDisplayer bouncer) {
        super(bouncer, Color.BLUE);
    }
    
    @Override
    public void draw() {
        BouncerDisplayer.getInstance().getGraphics()
                .fillOval(getX(), getY(), getSize(), getSize());
    }
}
