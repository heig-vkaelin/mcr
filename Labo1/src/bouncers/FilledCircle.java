package bouncers;

import rendering.FillShapeRenderer;

public class FilledCircle extends Circle {
    public FilledCircle() {
        super(new FillShapeRenderer());
    }
}
