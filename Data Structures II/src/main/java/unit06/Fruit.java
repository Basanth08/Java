package unit06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fruit implements Comparable <Fruit> {
    private final double price;
    private final String name;

    public Fruit (String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " $" + price;
    }

    @Override
    public int compareTo (Fruit o) {
        if (name.equals (o.name)) {
            return ((Double)price).compareTo ((Double)o.price);
        }
        else {
            return name.compareTo (o.name);
        }
    }

    public String getName () {
        return name;
    }

    public double getPrice () {
        return price;
    }

    public static void main(String[] args) {
        List<Fruit> fList = new ArrayList<> ();
        fList.add (new Fruit ("Unique Fruit", 3.25));
        fList.add (new Fruit ("Pumello", 4.25));
        fList.add (new Fruit ("Kumquat", 0.35));

        System.out.println (fList);
        Collections.sort (fList);
        System.out.println (fList);
        Collections.sort (fList, new FruitComparator ());
        System.out.println (fList);
    }
}