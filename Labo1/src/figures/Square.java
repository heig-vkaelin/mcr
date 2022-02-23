package figures;

import utils.Vector;

import java.awt.*;

public class Square extends Figure {
    public Square(int size, Vector position, Vector direction) {
        super(size, position, direction, Color.ORANGE);
    }
    
    @Override
    public void draw(Graphics g) {
        g.fillRect(getPosition().getX(), getPosition().getY(), getSize(), getSize());
    }
}
