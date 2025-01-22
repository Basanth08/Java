package unit03.toys;
import unit03.products.Product;

// public abstract class toys extends products{
//     private static long nextProductCode = 1000000;
//     private final long productCode;
//     private final String name;
//     private final double msrp;

//     public toys(String name, double msrp){
//         this.productCode = nextProductCode++;
//         this.name = name;
//         this.msrp = msrp;
//     }
//     public double getMsrp() {
//         return msrp;
//     }

//     public String getName() {
//         return name;
//     }

//     public long getProductCode() {
//         return productCode;
//     }
//     @Override
//     public String toString() {
//         return name + " (" + productCode + ") ";
//     }
// }

public abstract class toys extends Product {

    public toys(String name, long productCode, double msrp) {
        super(productCode, name, msrp);
    }

    @Override 
    public String toString() {
        return getName() + " (" + getProductCode() + ")"; 
    }

}
