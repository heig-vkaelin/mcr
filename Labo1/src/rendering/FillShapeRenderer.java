package rendering;

import bouncers.Bouncable;

import java.awt.*;

public class FillShapeRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
