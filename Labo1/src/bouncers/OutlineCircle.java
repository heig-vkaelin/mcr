package bouncers;

import rendering.OutlineShapeRenderer;

public class OutlineCircle extends Circle {
    public OutlineCircle() {
        super(new OutlineShapeRenderer());
    }
}
