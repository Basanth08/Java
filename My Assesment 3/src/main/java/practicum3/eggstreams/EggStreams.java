package practicum3.eggstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A class that provides utility functions for generating random eggs.
 * 
 * @author GCCIS Faculty, <YOUR NAME HERE>
 */
public class EggStreams {
    /**
     * Pseudorandom number generator used for randomness.
     */
    private static final Random RNG = new Random(1);

    /**
     * The available egg sizes.
     */
    private static final Size[] SIZES = Size.values();

    /**
     * Creates and returns an egg with random size, color, and cracked 
     * attributes.
     * 
     * @return A randomly generated egg.
     */
    public static Egg randomEgg() {
        Color color = RNG.nextDouble() > 0.5 ? Color.WHITE : Color.BROWN;
        Size size = SIZES[RNG.nextInt(0, SIZES.length)];

        Egg egg = new Egg(color, size);

        if(RNG.nextDouble() > 0.75) {
            egg.crack();
        }

        return egg;
    }

    /**
     * Creates and returns a list with the specified number of random eggs in 
     * it.
     * 
     * @param n The number of eggs to generate.
     * 
     * @return A list of randomly generated eggs.
     */
    public static List<Egg> randomEggs(int n) {
        List<Egg> eggs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            eggs.add(randomEgg());
        }
        return eggs;
    }

    /**
     * Returns a list of eggs selected that meet the specified criteria. None 
     * of the eggs in the selected list should be cracked.
     * 
     * @param eggs The list of available eggs.
     * @param color The desired color of eggs.
     * @param minimumWeight The desired minimum weight of the eggs.
     * 
     * @return A list of eggs that meet the specified criteria (and are not 
     * cracked).
     */
    public static List<Egg> selectEggs(List<Egg> eggs, Color color, double minimumWeight) {
        return eggs.stream()
                .filter(egg -> !egg.isCracked() && egg.getColor() == color && egg.getSize().getOunces() >= minimumWeight)
                .map(egg -> new PaintedEgg(egg, Pastel.randomPastel()))
                .collect(Collectors.toList());
    }

    private static class PaintedEgg extends Egg {
        private final Pastel pastelColor;

        public PaintedEgg(Egg egg, Pastel pastelColor) {
            super(egg.getColor(), egg.getSize());
            this.pastelColor = pastelColor;
        }

        @Override
        public String toString() {
            return "A painted " + pastelColor.name().toLowerCase() + " " + super.toString();
        }
    }

    public static void main(String[] args) {
        List<Egg> eggs = randomEggs(100);
     
        List<Egg> selected = selectEggs(eggs, Color.BROWN, 1.55);
        for(Egg egg : selected) {
            System.out.println(egg);
        }
    }
    
}
