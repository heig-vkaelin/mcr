package states;

public class PlatiniumStateLock extends PlatiniumState{
    public PlatiniumStateLock(AccountState oldState) {
        super(oldState);
    }
    @Override
    protected void stateChangeCheck(){}
}
