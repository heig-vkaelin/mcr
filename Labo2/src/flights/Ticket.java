package flights;

public class Ticket {
    private final Flight flight;
    private final TicketType type;
    private final int price;
    
    public Ticket(Flight flight, TicketType type) {
        this.flight = flight;
        this.type = type;
        
        price = flight.getPrice() * type.getCoeffPrice();
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    public TicketType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return type + " " + price + "$";
    }
}
