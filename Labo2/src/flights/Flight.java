package flights;

public class Flight {
    private final String name;
    
    private final int distance; // en [miles]
    
    private final int price; // en [$]
    
    public Flight(String name, int distance, int price) {
        this.name = name;
        this.distance = distance;
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getDistance() {
        return distance;
    }
    
    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}
