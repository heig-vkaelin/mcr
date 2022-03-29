package bouncers;

import java.awt.geom.Rectangle2D;

/**
 * Classe abstraite représentant les différents Carrés
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public abstract class Square extends Bouncer {
    @Override
    public Rectangle2D.Double getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
