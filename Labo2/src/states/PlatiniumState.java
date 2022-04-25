package states;

import java.awt.*;

/**
 * Classe représentant l'état Platinium d'un compte
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class PlatiniumState extends AccountState {
    /**
     * Constructeur de la classe PlatiniumState
     *
     * @param oldState état précédent du compte
     */
    public PlatiniumState(AccountState oldState) {
        super(oldState);
    }
    
    /**
     * Methode permettant de changer l'état du compte si besoin
     */
    protected void stateChangeCheck() {
        if (miles < 10000) {
            client.setState(new GoldState(this));
        } else if (balance > 100000) {
            client.setState(new PlatiniumStateLock(this));
        }
    }
    
    /**
     * Methode permettant de connaître le coefficient miles de l'état Platinium
     *
     * @return le coefficient miles de l'état Platinium
     */
    @Override
    protected double coeffMiles() {
        return 1;
    }
    
    /**
     * Methode permettant d'afficher l'état Platinium
     *
     * @return l'état Platinium sous forme de String
     */
    @Override
    public String toString() {
        return "PLATINIUM";
    }
    
    /**
     * Methode permettant de connaitre la couleur de l'état Platinium
     *
     * @return la couleur de l'état Platinium
     */
    @Override
    public Color getColor() {
        return Color.cyan;
    }
}
