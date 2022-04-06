package flights;

public class Ticket {
    private final Flight flight;
    private final TicketType type;
    private final int moneyPrice;
    private final int milesPrice;
    
    public Ticket(Flight flight, TicketType type) {
        this.flight = flight;
        this.type = type;
        
        moneyPrice = flight.getPrice() * type.getCoeffPrice();
        milesPrice = flight.getPrice() * type.getCoeffMiles();
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    public TicketType getType() {
        return type;
    }
    
    public int getMoneyPrice() {
        return moneyPrice;
    }
    
    public int getMilesPrice() {
        return milesPrice;
    }
    
    @Override
    public String toString() {
        return type + " " + moneyPrice + "$";
    }
}
