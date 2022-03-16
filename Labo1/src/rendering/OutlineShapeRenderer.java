package rendering;

import bouncers.Bouncable;

import java.awt.*;

public class OutlineShapeRenderer implements Renderer {
    private static final int STROKE_WIDTH = 2;
    private static final Stroke stroke = new BasicStroke(STROKE_WIDTH);
    
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setStroke(stroke);
        g.setColor(b.getColor());
        g.draw(b.getShape());
    }
}
