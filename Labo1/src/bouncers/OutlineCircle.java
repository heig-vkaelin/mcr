package bouncers;

import rendering.OutlineBouncerRenderer;

import java.awt.*;

/**
 * Classe représentant des Cercles vides avec un simple contour.
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class OutlineCircle extends Circle {

    /**
     * Constructeur d'un OutlineCircle
     */
    public OutlineCircle() {
        super(OutlineBouncerRenderer.getInstance());
    }
    
    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
