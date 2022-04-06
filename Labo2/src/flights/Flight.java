package flights;

public class Flight {
    private final String name;
    
    private final double distance; // en [miles]
    
    private final double price; // en [$]
    
    public Flight(String name, double distance, double price) {
        this.name = name;
        this.distance = distance;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return name + " (" + distance + ")";
    }
}
