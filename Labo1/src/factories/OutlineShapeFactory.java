package factories;

import figures.Circle;
import figures.Square;
import rendering.OutlineShapeRenderer;

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
        return new Circle(new OutlineShapeRenderer());
    }
    
    @Override
    public Square createSquare() {
        return new Square(new OutlineShapeRenderer());
    }
}
