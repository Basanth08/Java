package unit03.parser;

public class Constant implements Expression {
    private final double value;
    public Constant (double value){
        this.value = value;
    }
    @Override
    public double evaluate(){
        return value;
    }
    
    public static void main(String[] args) {
        Constant constant = new Constant(1);
        System.out.println(constant.evaluate());
    }
}
