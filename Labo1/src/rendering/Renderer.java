package rendering;

import bouncers.Bouncable;

import java.awt.*;

/**
 * Interface à implémenter afin de gérer l'affichage des Bouncers
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public interface Renderer {
    /**
     * Affiche un Bouncable sur un Graphics souhaité
     *
     * @param g : le Graphics sur lequel afficher le Bouncable
     * @param b : le Bouncable à afficher
     */
    void display(Graphics2D g, Bouncable b);
}
