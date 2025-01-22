package unit03.parser;

public class Addition implements Expression{
    private final Expression left;
    private final Expression right;
    public Addition(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public double evaluate(){
        return left.evaluate() + right.evaluate();
    }



public static void main(String[] args) {
    Expression inc = new Increment(new Constant(5));
    Expression dec = new Decrement(inc);
    System.out.println(inc.evaluate());
    System.out.println(dec.evaluate());
    Expression add = new Addition(inc,dec);
    System.out.println(inc.evaluate());
    System.out.println(add.evaluate());
}
    
}
