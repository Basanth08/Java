package unit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit01.primes;

public class primesTest {
    @Test
    public void primenumberTest(){
        // setup
        // invoke
        boolean result = primes.isPrime(10);
        // analyze
        assertEquals(false, result);
    }
    // public void primenumberTest(){
    //     // setup
    //     // invoke
    //     boolean result = primes.isPrime(7);
    //     // analyze
    //     assertEquals(true, result);
    // }
    // public void primenumberTest(){
    //     // setup
    //     // invoke
    //     boolean result = primes.isPrime(3);
    //     // analyze
    //     assertEquals(true, result);
    // }
}
