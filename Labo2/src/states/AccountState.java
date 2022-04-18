package states;

import account.Client;
import flights.Ticket;

import java.awt.*;

public abstract class AccountState{
    protected Client client;
    
    protected double balance;
    protected double miles;
    
    protected AccountState(Client client) {
        this.client = client;
        balance = 0;
        miles = 0;
    }
    
    protected AccountState(AccountState oldState) {
        client = oldState.client;
        balance = oldState.balance;
        miles = oldState.miles;
    }
    
    /**
     * Dépose de l'argent sur le compte
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
        stateChangeCheck();
    }
    
    /**
     * Achète un ticket pour un vol
     *
     * @param ticket
     * @return si l'achat a pu être fait
     */
    public boolean payFlightMoney(Ticket ticket) {
        if (balance - ticket.getMoneyPrice() < 0)
            return false;
        balance -= ticket.getMoneyPrice();
        miles += ticket.getFlight().getDistance() + ticket.getFlight().getDistance() * coefMiles();
        stateChangeCheck();
        return true;
    }
    
    /**
     * Achète un ticket pour un vol
     *
     * @param ticket
     * @return si l'achat a pu être fait
     */
    public boolean payFlightMiles(Ticket ticket) {
        if (miles - ticket.getMilesPrice() < 0)
            return false;
        miles -= ticket.getMilesPrice();
        stateChangeCheck();
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
    
    public AccountState getState(){
        return this;
    }
    
    public Client getClient() {
        return client;
    }
}
