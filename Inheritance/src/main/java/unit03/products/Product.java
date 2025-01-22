package unit03.products;

public abstract class Product {

    private long productCode;
    private String name; 
    private double msrp;
  
    public Product(long productCode, String name, double msrp) {
      this.productCode = productCode;
      this.name = name;
      this.msrp = msrp;
    }
    
    public long getProductCode() {
      return productCode;
    }
  
    public void setProductCode(long productCode) {
      this.productCode = productCode;
    }
  
    public String getName() {
      return name; 
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public double getMsrp() {
      return msrp;
    }
  
    public void setMsrp(double msrp) {
      this.msrp = msrp;
    }
    
    @Override
    public String toString() {
      return "Product[code=" + productCode + ",name=" + name + ",msrp=" + msrp + "]"; 
    }

    public interface Manufacturable {
        public Product manufacture();
    }
  }