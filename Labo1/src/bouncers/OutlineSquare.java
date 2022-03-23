package bouncers;

import rendering.OutlineBouncerRenderer;

import java.awt.*;

public class OutlineSquare extends Square {
    public OutlineSquare() {
        super(new OutlineBouncerRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.RED;
    }
}
