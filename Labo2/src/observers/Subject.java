package observers;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<>();
    void attach(Observer o){
        if(!observers.contains(o))
            observers.add(o);
    }
    void detach(Observer o){
        observers.remove(o);
    }
    void notifyObservers(){
        for (Observer o : observers){
            o.update();
        }
    }
}
