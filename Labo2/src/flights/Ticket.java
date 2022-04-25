package flights;

/**
 * Classe représentant un ticket pour un vol spécifique
 * Le ticket a également un type donné
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class Ticket {
    private final Flight flight;
    private final TicketType type;
    private final int moneyPrice;
    private final int milesPrice;
    
    /**
     * Crée un nouveau ticket pour le vol du type souhaité
     *
     * @param flight : vol du ticket
     * @param type   : type du ticket
     */
    public Ticket(Flight flight, TicketType type) {
        this.flight = flight;
        this.type = type;
        
        moneyPrice = flight.getPrice() * type.getCoeffPrice();
        milesPrice = flight.getPrice() * type.getCoeffMiles();
    }
    
    /**
     * @return le vol du ticket
     */
    public Flight getFlight() {
        return flight;
    }
    
    /**
     * @return le type du ticket
     */
    public TicketType getType() {
        return type;
    }
    
    /**
     * @return le prix en dollars du ticket
     */
    public int getMoneyPrice() {
        return moneyPrice;
    }
    
    /**
     * @return le prix en miles du ticket
     */
    public int getMilesPrice() {
        return milesPrice;
    }
    
    @Override
    public String toString() {
        return type + " " + moneyPrice + "$";
    }
}
