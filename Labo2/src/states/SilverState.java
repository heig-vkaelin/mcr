package states;

import account.Client;

import java.awt.*;

/**
 * Classe representant l'etat Silver d'un compte
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class SilverState extends AccountState {
    /**
     * Constructeur de copie de la classe SilverState
     * @param oldState l'état précédent du compte
     */
    public SilverState(AccountState oldState) {
        super(oldState);
    }
    
    /**
     * Constructeur de la classe SilverState
     * @param client le client du compte
     */
    public SilverState(Client client) {
        super(client);
    }
    
    /**
     * Methode permettant de changer l'état du compte si besoin
     */
    protected void stateChangeCheck() {
        if (miles >= 1000) {
            client.setState(new GoldState(this));
        }
    }
    
    /**
     * Methode permettant de connaître le coefficient miles de l'état Silver
     * @return le coefficient miles de l'état Silver
     */
    @Override
    protected double coefMiles() {
        return 0.1;
    }
    
    /**
     * Methode permettant d'afficher l'état Silver
     * @return l'état Silver sous forme de String
     */
    @Override
    public String toString() {
        return "SILVER";
    }
    
    /**
     * Méthode permettant de connaitre la couleur de l'état Silver
     * @return la couleur de l'état Silver
     */
    @Override
    public Color getColor() {
        return Color.gray;
    }
}
