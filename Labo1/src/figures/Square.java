package figures;

import utils.Vector;

import java.awt.*;

public class Square extends Figure {
    public Square(int size, Vector position, Vector direction, Color color) {
        super(size, position, direction, color);
    }
    
    @Override
    public void draw(Graphics g) {
        g.fillRect(getPosition().getX(), getPosition().getY(), getSize(), getSize());
    }
}
