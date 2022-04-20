package states;

import java.awt.*;

/**
 * Classe représentant l'état Gold d'un compte
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class GoldState extends AccountState {
    /**
     * Constructeur de la classe GoldState
     * @param oldState l'état précédent du compte
     */
    public GoldState(AccountState oldState) {
        super(oldState);
    }
    
    /**
     * Methode permettant de changer l'état du compte si besoin
     */
    protected void stateChangeCheck() {
        if (miles >= 10000) {
            client.setState(new PlatiniumState(this));
        } else if (miles < 1000) {
            client.setState(new SilverState(this));
        }
    }
    
    /**
     * Méthode permettant de connaître le coefficient de miles de l'état Gold
     * @return le coefficient de miles de l'état Gold
     */
    @Override
    protected double coefMiles() {
        return 0.5;
    }
    
    /**
     * Méthode permettant d'afficher l'état Gold
     * @return l'état Gold sous forme de String
     */
    @Override
    public String toString() {
        return "GOLD";
    }
    
    /**
     * Méthode permettant d'avoir la couleur de l'état Gold
     * @return la couleur de l'état Gold
     */
    @Override
    public Color getColor() {
        return Color.yellow;
    }
}

