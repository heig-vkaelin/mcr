package bouncers;

import rendering.FillBouncerRenderer;

import java.awt.*;

public class FilledSquare extends Square {
    public FilledSquare() {
        super(new FillBouncerRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }
}
