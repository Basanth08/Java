package unit03.products;

public class Truck {

    private Product[] products;
    private int loaded;
    private int capacity;

    public Truck(int capacity) {
        this.products = new Product[capacity];
        this.capacity = capacity;
    }

    public boolean isFull() {
        return loaded == capacity; 
    }

    public boolean isEmpty() { 
        return loaded == 0;
    }

    public void load(Product product) {
        if(!isFull()) {
            products[loaded++] = product;
        }
        else {
            System.out.println("Full!");
        }
    }

    public Product unload() {
        if(!isEmpty()) {
            loaded--;
            Product unloaded = products[loaded];
            products[loaded] = null; 
            return unloaded;
        }
        else {
            System.out.println("Empty!");
            return null; 
        }
    }
}