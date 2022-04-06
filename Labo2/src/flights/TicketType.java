package flights;

public enum TicketType {
    Economy(1, 1), Business(2, 5), FirstClass(5, 3);
    
    private final int priceCoeff;
    private final int milesCoeff;
    
    private TicketType(int priceCoeff, int milesCoeff) {
        this.priceCoeff = priceCoeff;
        this.milesCoeff = milesCoeff;
    }
    
    public int getCoeffPrice() {
        return priceCoeff;
    }
    
    public int getCoeffMiles() {
        return milesCoeff;
    }
}
