package unit09.lambdas;

import java.util.stream.IntStream;

public class Sum {
    private static int sum (int num) {
        // IntStream.range (1, num).forEach (System.out::println);
        // return IntStream.range (1, num).sum ();

        // Do both in the same stream
        return IntStream.range (1, num).map (i -> {
            System.out.println(i);
            return i;
        }).sum ();
    }

    public static void main(String[] args) {
        System.out.println (sum (100));
    }
}