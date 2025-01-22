package unit06;

import java.util.Comparator;

public class FruitComparator implements Comparator <Fruit> {
    
    @Override
    public int compare(Fruit a, Fruit b) {
        if (a.getPrice () == b.getPrice ()) {
            return a.getName ().compareTo (b.getName ());
        }
        else {
            return ((Double)a.getPrice ()).compareTo ((Double)b.getPrice ());
        }
    }
}