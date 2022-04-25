package flights;

/**
 * Classe représentant un vol
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class Flight {
    private final String name;
    
    private final int distance; // en [miles]
    
    private final int price; // en [$]
    
    /**
     * Crée un nouveau vol
     *
     * @param name     : nom du vol
     * @param distance : distance du vol
     * @param price    : prix du vol
     */
    public Flight(String name, int distance, int price) {
        this.name = name;
        this.distance = distance;
        this.price = price;
    }
    
    /**
     * @return le prix du vol
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * @return la distance du vol
     */
    public int getDistance() {
        return distance;
    }
    
    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}
