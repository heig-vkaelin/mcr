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
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
