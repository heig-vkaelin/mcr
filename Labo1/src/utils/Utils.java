package utils;

import java.util.Random;

public class Utils {
    private static final Random random = new Random();
    
    public static int getRandom(int max) {
        return random.nextInt(max);
    }
    
    public static int getRandomBetween(int min, int max) {
        int result;
        do {
            result = random.nextInt(max - min) + min;
        } while (result == 0);
        return result;
    }
}
