package unit06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pokemon implements Comparable <Pokemon> {
    private final int number;
    private final String name;

    public Pokemon (String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    @Override
    public int compareTo (Pokemon o) {
        return number - o.number;
    }

    public String getName () {
        return name;
    }

    public int getNumber () {
        return number;
    }

    public static void main(String[] args) {
        List <Pokemon> pList = new ArrayList<> ();
        pList.add (new Pokemon ("Raichu", 26));
        pList.add (new Pokemon ("Pikachu", 25));
        pList.add (new Pokemon ("Pichu", 172));
        
        System.out.println (pList);
        Collections.sort (pList);
        System.out.println (pList);
        Collections.sort (pList, new PokemonComparator ());
        System.out.println (pList);
    }
}