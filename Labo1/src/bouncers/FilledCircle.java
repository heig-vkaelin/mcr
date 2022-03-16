package bouncers;

import rendering.FillShapeRenderer;

import java.awt.*;

public class FilledCircle extends Circle {
    public FilledCircle() {
        super(new FillShapeRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
