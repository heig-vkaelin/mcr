package rendering;

import bouncers.Bouncable;

import java.awt.*;

/**
 * Affiche des Bouncers pleins
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class FillBouncerRenderer implements Renderer {

    private static FillBouncerRenderer instance;

    /**
     * Constructeur privé afin d'empêcher toute instanciation en dehors de getInstance()
     */
    private FillBouncerRenderer() {}

    /**
     * @return l'instance unique du Singleton
     */
    public static FillBouncerRenderer getInstance() {
        if (instance == null)
            instance = new FillBouncerRenderer();
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
