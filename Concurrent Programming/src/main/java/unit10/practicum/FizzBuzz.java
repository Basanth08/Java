package unit10.practicum;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 0 && i % 5 == 0)
                .forEach(i -> System.out.println("FizzBuzz: " + i));
    }
}
