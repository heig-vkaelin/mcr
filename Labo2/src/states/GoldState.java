package states;

import java.awt.*;

public class GoldState extends AccountState {
    public GoldState(AccountState oldState) {
        super(oldState);
    }
    
    protected void stateChangeCheck() {
        if (miles >= 10000) {
            account.setState(new GoldState(this));
        } else if (miles < 1000) {
            account.setState(new SilverState(this));
        }
    }
    
    @Override
    protected double coefMiles() {
        return 0.5;
    }
    
    @Override
    public String toString() {
        return "GOLD";
    }
    
    @Override
    public Color getColor() {
        return Color.yellow;
    }
}

