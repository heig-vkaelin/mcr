package utils;

public class Vector {
    private int x;
    private int y;
    
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public Vector add(Vector other) {
        return new Vector(x + other.getX(), y + other.getY());
    }
    
    public Vector multiply(Vector other) {
        return new Vector(x * other.getX(), y * other.getY());
    }
}
