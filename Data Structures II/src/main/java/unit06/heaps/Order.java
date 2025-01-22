package unit06.heaps;
import java.util.PriorityQueue;

public class Order {
    private int cost;
    private PriorityQueue<Sushi> bag;

    public Order() {
        this.bag = new PriorityQueue<>();
    }

    public void addSushi(Sushi sushi) {
        if (sushi != null) {
            bag.add(sushi);
            cost += sushi.getPrice();
        }
    }
    
    public PriorityQueue<Sushi> getBag() {
        return bag;
    }

    public int getCost() {
        return cost; 
    }
}