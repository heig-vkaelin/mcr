import java.util.Stack;

public abstract class AccountState {
    
    protected double balance;
    protected double miles;
    
    protected String name;
    protected String firstName;
    AccountState(){}
    AccountState(String name,String firstName){
        balance = 0;
        miles = 0;
        this.name = name;
        this.firstName = firstName;
    }
    
    AccountState(AccountState oldState){
        balance = oldState.balance;
        miles = oldState.miles;
        name = oldState.name;
        firstName = oldState.firstName;
    }
}
