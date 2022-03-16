package bouncers;

import rendering.FillShapeRenderer;

public class FilledSquare extends Square {
    public FilledSquare() {
        super(new FillShapeRenderer());
    }
}
