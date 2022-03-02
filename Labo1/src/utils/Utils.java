package utils;

import java.util.Random;

public class Utils {
    private static final Random random = new Random();
    
    public static int getRandom(int max) {
        return random.nextInt(max);
    }
    
    public static int getRandomBetween(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
