/**
 * Classe permettant de gérer un compte utilisateur possédant de multiple état
 */
public class Account {
    private AccountState state;
    
    private double balance;
    private double miles;
    
    private String name;
    private String firstName;
    
    /**
     * Constructeur par défaut de Account
     */
    Account(){
        balance = 0;
        state = null;
    }
    
    /**
     * Méthode permettant de changer le compte d'état
     * @param newState
     */
    void setState(AccountState newState){
        this.state = newState;
    }
    
    /**
     *
     * @param format
     * @param args
     */
    private void info() {
    }
    
    public void deposit(double amount){
        //state.deposit(amount);
    }
}
