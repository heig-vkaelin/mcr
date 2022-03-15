package rendering;

import figures.Bouncable;

import java.awt.*;

public class OutlineShapeRenderer implements Renderable {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setStroke(new BasicStroke(2));
        g.setColor(b.getColor());
        g.draw(b.getShape());
    }
}
