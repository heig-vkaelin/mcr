package bouncers;

import rendering.Renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Classe abstraite représentant les différents Cercles
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public abstract class Circle extends Bouncer {
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }
}
