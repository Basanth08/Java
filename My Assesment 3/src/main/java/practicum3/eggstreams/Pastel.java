package practicum3.eggstreams;

import java.util.Random;

/**
 * The available colors for a pastel egg.
 * 
 * @author GCCIS Faculty
 */
public enum Pastel {
    POWDER_BLUE,
    YELLOW,
    PINK,
    LAVENDER,
    ORANGE,
    GREEN;

    /**
     * Used for selecting a random color.
     */
    private static final Random RNG = new Random();

    /**
     * Returns a randomly selected pastel color.
     * 
     * @return A randomly selected pastel color.
     */
    public static Pastel randomPastel() {
        Pastel[] values = values();
        return values[RNG.nextInt(values.length)];
    }
}
