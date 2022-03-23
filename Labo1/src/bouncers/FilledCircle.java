package bouncers;

import rendering.FillBouncerRenderer;

import java.awt.*;

public class FilledCircle extends Circle {
    public FilledCircle() {
        super(new FillBouncerRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
