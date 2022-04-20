package states;

import account.Client;
import flights.Ticket;

import java.awt.*;

/**
 * Classe permettant de gérer les états d'un compte client
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public abstract class AccountState {
    protected Client client;
    
    protected double balance;
    protected double miles;
    
    /**
     * Constructeur de base d'un compte
     *
     * @param client client du compte
     */
    protected AccountState(Client client) {
        this.client = client;
        balance = 0;
        miles = 0;
    }
    
    /**
     * Constructeur de copie d'un compte
     *
     * @param oldState état à copier
     */
    protected AccountState(AccountState oldState) {
        client = oldState.client;
        balance = oldState.balance;
        miles = oldState.miles;
    }
    
    /**
     * Dépose de l'argent sur le compte
     *
     * @param amount montant à déposer
     */
    public void deposit(double amount) {
        balance += amount;
        stateChangeCheck();
    }
    
    /**
     * Achète un ticket pour un vol
     *
     * @param ticket ticket à acheter
     * @return si l'achat a pu être fait ou non
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
     * @param ticket ticket à acheter
     * @return si l'achat a pu être fait ou non
     */
    public boolean payFlightMiles(Ticket ticket) {
        if (miles - ticket.getMilesPrice() < 0)
            return false;
        miles -= ticket.getMilesPrice();
        stateChangeCheck();
        return true;
    }
    
    /**
     * Retourne le montant d'argent du compte
     *
     * @return montant d'argent du compte
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Retourne le nombre de miles du compte
     *
     * @return nombre de miles du compte
     */
    public double getMiles() {
        return miles;
    }
    
    /**
     * Regarde si l'état du compte doit changer et change l'état si c'est le cas
     */
    protected abstract void stateChangeCheck();
    
    /**
     * Retourne le coefficient de gain de miles
     *
     * @return coefficient de gain de miles
     */
    protected abstract double coefMiles();
    
    /**
     * Retourne la couleur de l'état du compte
     *
     * @return
     */
    public abstract Color getColor();
}
