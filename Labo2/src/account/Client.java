package account;

import states.*;

/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 */
public class Client {
    private AccountState state;
    
    private int id;
    static int counter = 0;
    
    protected String firstName;
    protected String lastName;
    
    
    /**
     * Constructeur par défaut de account.Account
     */
    public Client(String firstName, String lastName) {
        // TODO: check pk pas public avant
        this.firstName = firstName;
        this.lastName = lastName;
        id = counter++;
        state = new SilverState(this);
    }
    
    /**
     * Méthode permettant de changer le compte d'état
     *
     * @param newState
     */
    public void setState(AccountState newState) {
        this.state = newState;
    }
    
    /**
     * Renvoi les informations du compte
     *
     * @param format
     * @param args
     */
    public String info() {
        return firstName + " " + lastName + " " + state;
    }
    
    /**
     * Depose de l'argent sur le compte
     *
     * @param amount
     */
    public void deposit(double amount) {
        //state.deposit(amount);
    }
    
    /**
     * Procède au paiement d'un vol
     *
     * @param amount prix du vol
     */
    public void payFlightMoney(int amount) {
    }
    
    /**
     * Procède au paiement d'un vol via des miles
     *
     * @param amount prix du vol
     */
    public void payFlightMiles(int amount) {
    }
    
    public int getId() {
        return id;
    }
    
    public AccountState getState() {
        return state;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
