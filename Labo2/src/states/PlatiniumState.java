package states;

public class PlatiniumState extends AccountState{
    public PlatiniumState(AccountState oldState){
        super(oldState);
    }
    protected void stateChangeCheck(){
        if(balance > 100000){
            // platine stuck
            account.setState(new GoldState(this));
        } else if(miles < 10000){
            account.setState(new GoldState(this));
        }
    }
    
    @Override
    protected double coefMiles() {
        return 1;
    }
}
