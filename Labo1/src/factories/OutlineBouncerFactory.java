package factories;

import bouncers.Circle;
import bouncers.OutlineCircle;
import bouncers.OutlineSquare;
import bouncers.Square;

/**
 * Fabrique permettant de créer des Bouncers vides avec un simple contour
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class OutlineBouncerFactory extends BouncerFactory {
    private static OutlineBouncerFactory instance;

    /**
     * Constructeur privé afin d'empêcher toute instanciation en dehors de getInstance()
     */
    private OutlineBouncerFactory() {}
    
    /**
     * @return l'instance du Singleton de la fabrique
     */
    public static BouncerFactory getInstance() {
        if (instance == null)
            instance = new OutlineBouncerFactory();
        return instance;
    }
    
    @Override
    public Circle createCircle() {
        return new OutlineCircle();
    }
    
    @Override
    public Square createSquare() {
        return new OutlineSquare();
    }
}
