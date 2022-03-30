package account;

import states.*;

/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 */
public class Account {
    private AccountState state;
    private int id;
    static int counter = 0;
    protected String name;
    protected String firstName;
    /**
     * Constructeur par défaut de account.Account
     */
    Account(){
        id = counter++;
        state = new SilverState(this);
    }
    
    /**
     * Méthode permettant de changer le compte d'état
     * @param newState
     */
    public void setState(AccountState newState){
        this.state = newState;
    }
    
    /**
     *  Renvoi les informations du compte
     * @param format
     * @param args
     */
    private void info() {
    }
    
    /**
     * Depose de l'argent sur le compte
     * @param amount
     */
    public void deposit(double amount){
        //state.deposit(amount);
    }
    
    /**
     * Procède au paiement d'un vol
     * @param amount
     */
    public void payFlight(int amount) {
    }
}
