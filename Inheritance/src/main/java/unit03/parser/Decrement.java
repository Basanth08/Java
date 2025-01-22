package unit03.parser;

public class Decrement implements Expression {
    private final Expression exp;

    public Decrement(Expression exp){
        this.exp = exp;
    }
    @Override
    public double evaluate(){
        return exp.evaluate() - 1;
    }



public static void main(String[] args) {
    Expression inc = new Increment(new Constant(5));
    Expression dec = new Decrement(new Constant(5));
    System.out.println(inc.evaluate());
    System.out.println(dec.evaluate());
}
}
