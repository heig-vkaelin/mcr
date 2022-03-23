package factories;

import bouncers.Circle;
import bouncers.Square;

/**
 * Fabrique abstraite afin de créer différents Bouncers
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public abstract class BouncerFactory {
    /**
     * @return un nouveau Cercle
     */
    public abstract Circle createCircle();
    
    /**
     * @return un nouveau Carré
     */
    public abstract Square createSquare();
}
