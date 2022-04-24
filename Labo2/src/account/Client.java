package account;

import flights.Ticket;
import observers.Subject;
import states.*;

import java.awt.*;

/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class Client extends Subject {
    private static int counter = 0;
    private final int id;
    
    private AccountState state;
    
    private final String firstName;
    private final String lastName;
    
    private String lastAction;
    
    /**
     * Constructeur d'un client défini par un prénom et un nom
     *
     * @param firstName : prénom du client
     * @param lastName  : nom du client
     */
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        id = counter++;
        state = new SilverState(this);
    }
    
    /**
     * Modifie la dernière action effectuée par l'utilisateur
     */
    private void updateLastAction(String format, Object... args) {
        lastAction = String.format(format, args) +
                String.format(" Balance: %.2f. State: %s.\n",
                        getBalance(), getActualStateToString());
    }
    
    /**
     * Méthode permettant de changer l'état du compte
     *
     * @param newState : nouvel état
     */
    public void setState(AccountState newState) {
        this.state = newState;
    }
    
    /**
     * Dépose de l'argent sur le compte
     *
     * @param amount : montant à déposer
     */
    public void deposit(double amount) {
        state.deposit(amount);
        updateLastAction("Deposited: %.2f. ", amount);
        notifyObservers();
    }
    
    /**
     * Procède au paiement d'un vol via de l'argent
     *
     * @param ticket ticket du vol contenant son prix
     */
    public void payFlightMoney(Ticket ticket) {
        if (state.payFlightMoney(ticket))
            updateLastAction("Paid flight %s with money: %s.",
                    ticket.getFlight(), ticket);
        else
            updateLastAction("Payment of the flight with money FAILED");
        
        notifyObservers();
    }
    
    /**
     * Procède au paiement d'un vol via des miles
     *
     * @param ticket ticket du vol contenant son prix
     */
    public void payFlightMiles(Ticket ticket) {
        if (state.payFlightMiles(ticket))
            updateLastAction("Paid flight %s with miles: %d miles",
                    ticket.getFlight(), ticket.getMilesPrice());
        else
            updateLastAction("Payment of the flight with miles FAILED");
        
        notifyObservers();
    }
    
    /**
     * @return l'identifiant unique du client
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return le prénom du client
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * @return le nom du client
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * @return le nom et prénom du client
     */
    public String getFullName() {
        return lastName + " " + firstName;
    }
    
    /**
     * @return la dernière action effectuée par le client
     */
    public String getLastAction() {
        return lastAction;
    }
    
    /**
     * @return la couleur de l'état du compte
     */
    public Color getColor() {
        return state.getColor();
    }
    
    /**
     * @return le solde du compte
     */
    public double getBalance() {
        return state.getBalance();
    }
    
    /**
     * @return le nombre de miles du compte
     */
    public double getMiles() {
        return state.getMiles();
    }
    
    /**
     * @return état du compte sous forme de string
     */
    public String getActualStateToString() {
        return state.toString();
    }
    
    /**
     * Affiche les informations du compte
     *
     * @return informations du compte sous forme de string
     */
    @Override
    public String toString() {
        return getFullName();
    }
    
    /**
     * Affiche les informations détaillées du compte
     *
     * @return informations détaillées du compte sous forme de string
     */
    public String toStringDetailed() {
        return this + " " + getActualStateToString();
    }
}
