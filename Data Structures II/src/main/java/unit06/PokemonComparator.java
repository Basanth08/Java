package unit06;

import java.util.Comparator;

public class PokemonComparator implements Comparator <Pokemon> {

    @Override
    public int compare (Pokemon a, Pokemon b) {
        return a.getName ().compareTo (b.getName ());
    }
}