/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 */
public class Account {
    private AccountState state;
    
    /**
     * Constructeur par défaut de Account
     */
    Account(){
        state = new SilverState();
        state.balance = 0;
    }
    
    /**
     * Méthode permettant de changer le compte d'état
     * @param newState
     */
    void setState(AccountState newState){
        this.state = newState;
    }
    
    /**
     *  Renvoi les informations du compte
     * @param format
     * @param args
     */
    private void info() {
    }
    
    public void deposit(double amount){
        //state.deposit(amount);
    }
    
    public void withdraw(double amount){
        //state.withdraw(amount);
    }
    
    public void payFlight(/* des trucs et des machins*/) {
    }
}
