package bouncers;

import java.awt.*;

/**
 * Interface représentant les différentes formes affichées dans l'application
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public interface Bouncable {
    /**
     * Dessine le Bouncer à sa position courante
     */
    void draw();
    
    /**
     * Déplace le Bouncer
     */
    void move();
    
    /**
     * @return la couleur du Bouncer
     */
    Color getColor();
    
    /**
     * @return la forme du Bouncer
     */
    Shape getShape();
}
