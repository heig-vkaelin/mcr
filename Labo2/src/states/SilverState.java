package states;

import account.Account;

import java.awt.*;

public class SilverState extends AccountState {
    public SilverState(AccountState oldState) {
        super(oldState);
    }
    
    public SilverState(Account account) {
        super(account);
    }
    
    protected void stateChangeCheck() {
        if (miles >= 1000) {
            account.setState(new GoldState(this));
        }
    }
    
    @Override
    protected double coefMiles() {
        return 0.1;
    }
    
    @Override
    public String toString() {
        return "SILVER";
    }
    
    @Override
    public Color getColor() {
        return Color.gray;
    }
}
