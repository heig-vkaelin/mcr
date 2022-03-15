package factories;

import figures.Circle;
import figures.Square;

public abstract class ShapeFactory {
    public abstract Circle createCircle();
    
    public abstract Square createSquare();
}
