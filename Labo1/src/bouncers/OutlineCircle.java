package bouncers;

import rendering.OutlineBouncerRenderer;

import java.awt.*;

public class OutlineCircle extends Circle {
    public OutlineCircle() {
        super(new OutlineBouncerRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
