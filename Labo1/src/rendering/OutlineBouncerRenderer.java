package rendering;

import bouncers.Bouncable;

import java.awt.*;

/**
 * Affiche des Bouncers vides avec un simple contour
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class OutlineBouncerRenderer implements Renderer {
    private static final int STROKE_WIDTH = 2;
    private static final Stroke STROKE = new BasicStroke(STROKE_WIDTH);

    private static OutlineBouncerRenderer instance;

    /**
     * Constructeur privé afin d'empêcher toute instanciation en dehors de getInstance()
     */
    private OutlineBouncerRenderer() {}

    /**
     * @return l'instance unique du Singleton
     */
    public static OutlineBouncerRenderer getInstance() {
        if (instance == null)
            instance = new OutlineBouncerRenderer();
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setStroke(STROKE);
        g.setColor(b.getColor());
        g.draw(b.getShape());
    }
}
