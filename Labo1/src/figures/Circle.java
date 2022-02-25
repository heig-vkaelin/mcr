package figures;

import display.JBouncer;

import java.awt.*;

public class Circle extends Figure {
    public Circle(JBouncer bouncer) {
        super(bouncer, Color.BLUE);
    }
    
    @Override
    public void draw(Graphics g) {
        g.fillOval(getX(), getY(), getSize(), getSize());
    }
}
