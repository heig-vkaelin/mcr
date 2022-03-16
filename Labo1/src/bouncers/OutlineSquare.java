package bouncers;

import rendering.OutlineShapeRenderer;

import java.awt.*;

public class OutlineSquare extends Square {
    public OutlineSquare() {
        super(new OutlineShapeRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.RED;
    }
}
