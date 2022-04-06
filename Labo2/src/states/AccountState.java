package states;
import account.Account;

public abstract class AccountState {
    protected Account account;
    protected double balance;
    protected double miles;
    
    protected AccountState(Account account){
        this.account = account;
        balance = 0;
        miles = 0;
    }
    
    protected AccountState(AccountState oldState){
        balance = oldState.balance;
        miles = oldState.miles;
    }
    
    /**
     * Dépose de l'argent sur le compte
     * @param amount
     */
    public void deposit(double amount){
        balance += amount;
        stateChangeCheck();
    }
    
    /**
     * Achète un ticket pour un vol
     * @param amount
     * @return si l'achat a pu être fait
     */
    protected boolean payFlightMoney(int amount){
        if(balance-amount < 0)
            return false;
        balance -=amount;
        // miles += nbMiles du vol + nbMiles* coefMiles
        stateChangeCheck();
        return true;
    }
    
    /**
     * Achète un ticket pour un vol
     * @param amount
     * @return si l'achat a pu être fait
     */
    protected boolean payFlightMiles(int amount){
        if(miles-amount < 0)
            return false;
        miles -=amount;
        stateChangeCheck();
        return true;
    }
    
    /**
     * Regarde si l'état du compte doit changer
     */
    protected abstract void stateChangeCheck();
    
    /**
     * Retourne le coefficient de gain de miles
     * @return coefficient de gain de miles
     */
    protected abstract double coefMiles();
}
