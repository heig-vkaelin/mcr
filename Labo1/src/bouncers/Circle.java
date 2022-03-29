package bouncers;

import java.awt.geom.Ellipse2D;

/**
 * Classe abstraite représentant les différents Cercles
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public abstract class Circle extends Bouncer {
    @Override
    public Ellipse2D.Double getShape() {
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }
}
