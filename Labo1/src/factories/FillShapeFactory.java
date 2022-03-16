package factories;

import bouncers.Circle;
import bouncers.FilledCircle;
import bouncers.FilledSquare;
import bouncers.Square;

public class FillShapeFactory extends ShapeFactory {
    private static FillShapeFactory instance;
    
    private FillShapeFactory() {
    }
    
    public static ShapeFactory getInstance() {
        if (instance == null)
            instance = new FillShapeFactory();
        return instance;
    }
    
    @Override
    public Circle createCircle() {
        return new FilledCircle();
    }
    
    @Override
    public Square createSquare() {
        return new FilledSquare();
    }
}
