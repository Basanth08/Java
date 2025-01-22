package unit05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit05.iteratorss.IterableFibonacci;
import static org.junit.jupiter.api.Assertions.*;

public class IterableFibonacciTest {
    private IterableFibonacci fib;

    @BeforeEach
    public void setUp() {
        fib = new IterableFibonacci(2, 5);
    }

    @Test
    public void testInitialSequence() {
        assertEquals(2, fib.get(0));
        assertEquals(5, fib.get(1)); 
    }

    @Test
    public void testAdd() {
        fib.add();
        assertEquals(7, fib.get(2));
    }

    @Test
    public void testLength() {
        assertEquals(2, fib.length());
        fib.add();
        assertEquals(3, fib.length());
    }

    @Test
    public void testToString() {
        String expected = "[2, 5]";
        assertEquals(expected, fib.toString());
    }

    @Test
    public void testIterator() {
        fib.add();
        int index = 0;
        for (long fiboo : fib) {
            assertEquals(fib.get(index++), fiboo);
        }
    }
}