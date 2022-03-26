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

    /**
     * Constructeur d'un FilledCircle
     */
    public FilledCircle() {
        super(FillBouncerRenderer.getInstance());
    }
    
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
