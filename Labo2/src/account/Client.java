package account;

import flights.Ticket;
import observers.Subject;
import states.*;

/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class Client extends Subject {
    private AccountState state;
    
    private int id;
    static int counter = 0;
    
    protected String firstName;
    protected String lastName;
    
    
    /**
     * Constructeur par défaut de Client
     */
    public Client(String firstName, String lastName) {
        // TODO: check pk pas public avant
        this.firstName = firstName;
        this.lastName = lastName;
        id = counter++;
        state = new SilverState(this);
    }
    
    /**
     * Méthode permettant de changer l'état du compte
     *
     * @param newState
     */
    public void setState(AccountState newState) {
        this.state = newState;
    }
    
    /**
     * Renvoi les informations du compte
     * @param format
     * @param args
     */
    public String info() {
        return firstName + " " + lastName + " " + state;
    }
    
    /**
     * Depose de l'argent sur le compte
     * @param amount
     */
    public void deposit(double amount) {
        state.deposit(amount);
        notifyObservers();
    }
    
    /**
     * Procède au paiement d'un vol via de l'argent
     * @param ticket prix du vol
     */
    public void payFlightMoney(Ticket ticket) {
        state.payFlightMoney(ticket);
        notifyObservers();
    }
    
    /**
     * Procède au paiement d'un vol via des miles
     * @param ticket prix du vol
     */
    public void payFlightMiles(Ticket ticket) {
        state.payFlightMiles(ticket);
        notifyObservers();
    }
    
    /**
     * Renvoi l'id du client
     * @return id du client
     */
    public int getId() {
        return id;
    }
    
    /**
     * Renvoi l'état du compte
     * @return état du compte
     */
    public AccountState getState() {
        return state;
    }
    
    /**
     * Renvoi le prénom du client
     * @return prénom du client
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Renvoi le nom du client
     * @return nom du client
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Affiche les informations du compte
     * @return informations du compte sous forme de string
     */
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
