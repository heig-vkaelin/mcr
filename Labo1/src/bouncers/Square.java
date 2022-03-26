package bouncers;

import rendering.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Classe abstraite représentant les différents Carrés
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public abstract class Square extends Bouncer {

    /**
     * Constructeur d'un Square
     *
     * @param renderer : renderer à utiliser lors de l'affichage du Square
     */
    public Square(Renderer renderer) {
        super(renderer);
    }
    
    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
