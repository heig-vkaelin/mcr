package bouncers;

import rendering.FillBouncerRenderer;

import java.awt.*;

/**
 * Classe représentant des Carrés pleins.
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class FilledSquare extends Square {
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }
    
    @Override
    protected FillBouncerRenderer getRenderer() {
        return FillBouncerRenderer.getInstance();
    }
}
