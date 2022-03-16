package factories;

import bouncers.Circle;
import bouncers.Square;

public abstract class ShapeFactory {
    public abstract Circle createCircle();
    
    public abstract Square createSquare();
}
