package unit03.products;
import unit03.products.Product.Manufacturable;

public abstract class factory implements Manufacturable {

    private String factoryName;
    private String factoryLocation;
    
    public factory(String factoryName, String factoryLocation) {
        this.factoryName = factoryName;
        this.factoryLocation = factoryLocation;
    }
    
    public String getFactoryName() {
        return factoryName;
    }

    public String getFactoryLocation() {
        return factoryLocation; 
    }

    public abstract Product createProduct();
    
    @Override
    public abstract Product manufacture();

    public void loadProducts(Truck truck) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadProducts'");
    }

}