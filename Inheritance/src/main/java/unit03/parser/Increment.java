package unit03.parser;

public class Increment implements Expression {
    private final Expression exp;

    public Increment(Expression exp){
        this.exp = exp;
    }
    @Override
    public double evaluate(){
        return exp.evaluate() + 1;
    }



public static void main(String[] args) {
    Expression inc = new Increment(new Constant(5));
    System.out.println(inc.evaluate());
}
}

