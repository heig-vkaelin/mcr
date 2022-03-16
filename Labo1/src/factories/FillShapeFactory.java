package factories;

import bouncers.Circle;
import bouncers.Square;
import rendering.FillShapeRenderer;

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
        return new Circle(new FillShapeRenderer());
    }
    
    @Override
    public Square createSquare() {
        return new Square(new FillShapeRenderer());
    }
}
