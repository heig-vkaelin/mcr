package states;

import account.Client;
import flights.Ticket;
import observers.Subject;

import java.awt.*;

public abstract class AccountState extends Subject {
    protected Client client;
    
    protected double balance;
    protected double miles;
    
    protected AccountState(Client client) {
        this.client = client;
        balance = 0;
        miles = 0;
    }
    
    protected AccountState(AccountState oldState) {
        balance = oldState.balance;
        miles = oldState.miles;
    }
    
    /**
     * Dépose de l'argent sur le compte
     *
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
        stateChangeCheck();
        notifyObservers();
    }
    
    /**
     * Achète un ticket pour un vol
     *
     * @param amount
     * @return si l'achat a pu être fait
     */
    protected boolean payFlightMoney(Ticket ticket){
        if(balance - ticket.getPrice() < 0)
            return false;
        balance -= ticket.getPrice();
        miles += ticket.getFlight().getDistance() + ticket.getFlight().getDistance() * coefMiles();
        stateChangeCheck();
        notifyObservers();
        return true;
    }
    
    /**
     * Achète un ticket pour un vol
     * @param amount
     * @return si l'achat a pu être fait
     */
    protected boolean payFlightMiles(Ticket ticket){
        if(miles - ticket.getPrice() < 0)
            return false;
        //TODO kek prixMiles
        miles -= ticket.getPrice();
        stateChangeCheck();
        notifyObservers();
        return true;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getMiles() {
        return miles;
    }
    
    /**
     * Regarde si l'état du compte doit changer
     */
    protected abstract void stateChangeCheck();
    
    /**
     * Retourne le coefficient de gain de miles
     *
     * @return coefficient de gain de miles
     */
    protected abstract double coefMiles();
    
    public abstract Color getColor();
}
