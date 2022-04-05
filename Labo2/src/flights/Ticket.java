package flights;

public enum Ticket {
    Economy(1, 1), Business(2, 5), FirstClass(5, 3);
    
    private final int coeffPrice;
    private final int coeffMiles;
    
    private Ticket(int coeffPrice, int coeffMiles) {
        this.coeffPrice = coeffPrice;
        this.coeffMiles = coeffMiles;
    }
}
