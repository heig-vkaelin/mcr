package utils;

import java.util.Random;

/**
 * Classe contenant des fonctions utilitaires
 *
 * @author Lazar Pavicevic
 * @author Valentin Kaelin
 */
public class Utils {
    private static final Random RANDOM = new Random();
    
    /**
     * Retourne une valeur aléatoire
     *
     * @param max borne supérieure (exclue)
     * @return la valeur aléatoire
     */
    public static int getRandom(int max) {
        return RANDOM.nextInt(max);
    }
    
    /**
     * Retourne une valeur aléatoire (non-nulle) entre les deux bornes
     *
     * @param min borne inférieure (inclue)
     * @param max borne supérieure (exclue)
     * @return la valeur aléatoire
     */
    public static int getRandomBetween(int min, int max) {
        int result;
        do {
            result = RANDOM.nextInt(max - min) + min;
        } while (result == 0);
        return result;
    }
}
