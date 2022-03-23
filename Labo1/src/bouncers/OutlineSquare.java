package bouncers;

import rendering.OutlineBouncerRenderer;

import java.awt.*;

/**
 * Classe représentant des Carrés vides avec un simple contour.
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class OutlineSquare extends Square {
    public OutlineSquare() {
        super(new OutlineBouncerRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.RED;
    }
}
