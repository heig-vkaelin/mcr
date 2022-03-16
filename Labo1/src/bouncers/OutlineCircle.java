package bouncers;

import rendering.OutlineShapeRenderer;

import java.awt.*;

public class OutlineCircle extends Circle {
    public OutlineCircle() {
        super(new OutlineShapeRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
