package unit02.swb;

import java.util.Arrays;
import java.util.Random;

public class Activities {
    private static final int START_YEAR = 1900;
    private static final int END_YEAR = 2025;
    /**
     * Converts the comma sepeerated string of years into an array of years
     * @param years years comma seperated string of years
     * @return string of arrays
     */
    public static String[] years (String years) {
        return years.split(", ");
    }
    public static int getRandomYear(){
        Random random = new Random();
        return random.nextInt(END_YEAR - START_YEAR) + START_YEAR;

    }
    public static void main(String[] args) {
        String years = " 2000, 2001, 2002, 2003, 2004, 2005";
        String[] yearArray= years(years);
        System.out.println(Arrays.toString(yearArray));
        System.out.println(getRandomYear());
        System.out.println(getRandomYear());
        System.out.println(getRandomYear());

    }
    
}
