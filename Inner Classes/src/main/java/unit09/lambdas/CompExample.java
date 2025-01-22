package unit09.lambdas;

public class CompExample {

    public interface Computation {
        double compute (double x, double y);
    }
    
    public static void computeAndPrint (Computation c) {
        double result = c.compute (10.5, 2.7);
        System.out.println (result);
    }

    public static void main(String[] args) {
        Computation add = (x, y) -> x + y;
        computeAndPrint (add);

        // Computation pow = (x, y) -> Math.pow (x, y);
        Computation pow = Math::pow;
        computeAndPrint (pow);
    }
}