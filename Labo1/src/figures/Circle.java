package figures;

import utils.Vector;

import java.awt.*;

public class Circle extends Figure {
    public Circle(int size, Vector position, Vector direction) {
        super(size, position, direction, Color.BLUE);
    }
    
    @Override
    public void draw(Graphics g) {
        g.fillOval(getPosition().getX(), getPosition().getY(), getSize(), getSize());
    }
}
