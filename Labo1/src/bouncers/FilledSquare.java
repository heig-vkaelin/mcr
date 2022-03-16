package bouncers;

import rendering.FillShapeRenderer;

import java.awt.*;

public class FilledSquare extends Square {
    public FilledSquare() {
        super(new FillShapeRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }
}
