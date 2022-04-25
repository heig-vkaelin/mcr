package states;

import java.awt.*;

/**
 * Classe représentant l'état Gold d'un compte
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class GoldState extends AccountState {
    public static double LOWER_LIMIT = 1000;
    
    /**
     * Constructeur de la classe GoldState
     *
     * @param oldState l'état précédent du compte
     */
    public GoldState(AccountState oldState) {
        super(oldState);
    }
    
    /**
     * Methode permettant de changer l'état du compte si besoin
     */
    protected void stateChangeCheck() {
        if (miles >= PlatiniumState.LOWER_LIMIT) {
            client.setState(new PlatiniumState(this));
        } else if (miles < LOWER_LIMIT) {
            client.setState(new SilverState(this));
        }
    }
    
    /**
     * Méthode permettant de connaître le coefficient de miles de l'état Gold
     *
     * @return le coefficient de miles de l'état Gold
     */
    @Override
    protected double coeffMiles() {
        return 0.5;
    }
    
    /**
     * Méthode permettant d'afficher l'état Gold
     *
     * @return l'état Gold sous forme de String
     */
    @Override
    public String toString() {
        return "GOLD";
    }
    
    /**
     * Méthode permettant d'avoir la couleur de l'état Gold
     *
     * @return la couleur de l'état Gold
     */
    @Override
    public Color getColor() {
        return Color.orange;
    }
}

