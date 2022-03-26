package factories;

import bouncers.Circle;
import bouncers.FilledCircle;
import bouncers.FilledSquare;
import bouncers.Square;

/**
 * Fabrique permettant de créer des Bouncers pleins
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class FillBouncerFactory extends BouncerFactory {
    private static FillBouncerFactory instance;

    /**
     * Constructeur privé afin d'empêcher toute instanciation en dehors de getInstance()
     */
    private FillBouncerFactory() {}
    
    /**
     * @return l'instance du Singleton de la fabrique
     */
    public static BouncerFactory getInstance() {
        if (instance == null)
            instance = new FillBouncerFactory();
        return instance;
    }
    
    @Override
    public Circle createCircle() {
        return new FilledCircle();
    }
    
    @Override
    public Square createSquare() {
        return new FilledSquare();
    }
}
