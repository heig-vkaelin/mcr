package figures;

import display.JBouncer;

import java.awt.*;

public class Square extends Figure {
    public Square(JBouncer bouncer) {
        super(bouncer, Color.ORANGE);
    }
    
    @Override
    public void draw(Graphics g) {
        g.fillRect(getX(), getY(), getSize(), getSize());
    }
}
