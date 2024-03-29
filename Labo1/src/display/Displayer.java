package display;

import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * Interface à implémenter pour gérer l'affichage
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public interface Displayer {
    /**
     * @return la largeur du panel de l'affichage
     */
    int getWidth();
    
    /**
     * @return la hauteur du panel de l'affichage
     */
    int getHeight();
    
    /**
     * @return le Graphics sur lequel afficher
     */
    Graphics2D getGraphics();
    
    /**
     * Rafraîchit l'affichage
     */
    void repaint();
    
    /**
     * Modifie le titre de la fenêtre
     *
     * @param title : le titre souhaité
     */
    void setTitle(String title);
    
    /**
     * Ajoute un listener sur les entrées clavier de l'utilisateur
     *
     * @param ka : la classe écoutant les différentes touches
     */
    void addKeyListener(KeyAdapter ka);
}
