package states;

/**
 * Classe représentant l'état Platinium inchangeable d'un compte
 *
 * @author Alexandre Jaquier
 * @author Valentin Kaelin
 */
public class PlatiniumStateLock extends PlatiniumState {
    public static double LOWER_LIMIT_BALANCE = 100000;
    
    /**
     * Constructeur de la classe PlatiniumStateLock
     *
     * @param oldState l'état précédent du compte
     */
    public PlatiniumStateLock(AccountState oldState) {
        super(oldState);
    }
    
    /**
     * Méthode permettant de changer de compte, ici l'état est vérouillé
     */
    @Override
    protected void stateChangeCheck() {
    }
}
