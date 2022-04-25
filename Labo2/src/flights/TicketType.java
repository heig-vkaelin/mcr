package flights;

/**
 * Enum représentant les différents types de tickets possibles.
 * Chaque type a un coefficient pour le prix en dollars et un autre pour le prix
 * en miles.
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public enum TicketType {
    Economy(1, 1), Business(2, 5), FirstClass(5, 30);
    
    private final int priceCoeff;
    private final int milesCoeff;
    
    /**
     * Constructeur privé pour créer un élément de l'Enum
     *
     * @param priceCoeff : coefficient pour le prix en dollars
     * @param milesCoeff : coefficient pour le prix en miles
     */
    private TicketType(int priceCoeff, int milesCoeff) {
        this.priceCoeff = priceCoeff;
        this.milesCoeff = milesCoeff;
    }
    
    /**
     * @return le coefficient pour le prix en dollars
     */
    public int getCoeffPrice() {
        return priceCoeff;
    }
    
    /**
     * @return le coefficient pour le prix en miles
     */
    public int getCoeffMiles() {
        return milesCoeff;
    }
}
