package bouncers;

import rendering.OutlineShapeRenderer;

public class OutlineSquare extends Square {
    public OutlineSquare() {
        super(new OutlineShapeRenderer());
    }
}
