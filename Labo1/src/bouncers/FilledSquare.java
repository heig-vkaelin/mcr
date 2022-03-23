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
    public FilledSquare() {
        super(new FillBouncerRenderer());
    }
    
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }
}
