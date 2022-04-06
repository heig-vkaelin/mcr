package states;

public class PlatiniumState extends AccountState {
    public PlatiniumState(AccountState oldState) {
        super(oldState);
    }
    
    protected void stateChangeCheck() {
        if (miles < 10000) {
            account.setState(new GoldState(this));
        } else if (balance > 100000) {
            account.setState(new PlatiniumStateLock(this));
        }
    }
    
    @Override
    protected double coefMiles() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "PLATINIUM";
    }
}
