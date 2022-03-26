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

    /**
     * Constructeur d'un OutlineSquare
     */
    public OutlineSquare() {
        super(OutlineBouncerRenderer.getInstance());
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
