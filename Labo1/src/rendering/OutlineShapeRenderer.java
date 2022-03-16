package rendering;

import bouncers.Bouncable;

import java.awt.*;

public class OutlineShapeRenderer implements Renderable {
    private static final int STROKE_WIDTH = 2;
    
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setStroke(new BasicStroke(STROKE_WIDTH));
        g.setColor(b.getColor());
        g.draw(b.getShape());
    }
}
