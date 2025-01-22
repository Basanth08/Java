package unit03.products;

import java.util.Random;

public class complex {

    private factory[] factories;
    
    public complex(factory[] factories) {
        this.factories = factories;
    }

    public void loadTruck(Truck truck) {
        
        while (!truck.isFull()) {
        
            int index = new Random().nextInt(factories.length);
            
            factory factory = factories[index];
            
            Product product = factory.createProduct();
            
            truck.load(product);
            
        }
    }

}