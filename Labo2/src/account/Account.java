package account;

import states.*;

/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 */
public class Account {
    private AccountState state;
    private int id;
    static int counter = 0;
    protected String firstName;
    protected String lastName;
    
    
    /**
     * Constructeur par défaut de account.Account
     */
    public Account(String firstName, String lastName) {
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
    private void info() {
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
     * @param amount
     */
    public void payFlight(int amount) {
    }
    
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
