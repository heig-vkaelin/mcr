package bouncers;

import rendering.FillBouncerRenderer;

import java.awt.*;

/**
 * Classe représentant des Cercles pleins.
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class FilledCircle extends Circle {
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
    
    @Override
    protected FillBouncerRenderer getRenderer() {
        return FillBouncerRenderer.getInstance();
    }
}
