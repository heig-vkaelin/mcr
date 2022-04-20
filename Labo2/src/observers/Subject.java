package observers;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite sujet.
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public abstract class Subject {
    List<Observer> observers = new ArrayList<>();
    
    /**
     * Attache un observateur au sujet
     * @param o Observateur à attacher.
     */
    public void attach(Observer o){
        if(!observers.contains(o))
            observers.add(o);
    }
    
    /**
     * Détache un observateur du sujet
     * @param o Observateur à détacher.
     */
    public void detach(Observer o){
        observers.remove(o);
    }
    
    /**
     * Notifie tous les observateurs du sujet
     */
    protected void notifyObservers(){
        for (Observer o : observers){
            o.update();
        }
    }
}
