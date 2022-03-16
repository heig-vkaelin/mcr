package factories;

import bouncers.Circle;
import bouncers.OutlineCircle;
import bouncers.OutlineSquare;
import bouncers.Square;

public class OutlineShapeFactory extends ShapeFactory {
    private static OutlineShapeFactory instance;
    
    private OutlineShapeFactory() {
    }
    
    public static ShapeFactory getInstance() {
        if (instance == null)
            instance = new OutlineShapeFactory();
        return instance;
    }
    
    @Override
    public Circle createCircle() {
        return new OutlineCircle();
    }
    
    @Override
    public Square createSquare() {
        return new OutlineSquare();
    }
}
