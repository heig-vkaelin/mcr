package observers;

import states.AccountState;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<>();
    public void attach(Observer o){
        if(!observers.contains(o))
            observers.add(o);
    }
    public void detach(Observer o){
        observers.remove(o);
    }
    protected void notifyObservers(){
        for (Observer o : observers){
            o.update();
        }
    }
}
