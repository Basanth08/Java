package calculonTest.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit01.calculon;

public class calculonTest {
    @Test
    public void testadd(){
        // setup

        // invoke
        double actual = calculon.add(4, 6);
        // analyze
        assertEquals(10.0, actual, 0.00000000001);
    }
    public void testsub(){
        // setup

        // invoke
        double actual = calculon.sub(4, 6);
        // analyze
        assertEquals(-2, actual, 0.00000000001);
    }
    public void testmul(){
        // setup

        // invoke
        double actual = calculon.mul(4, 6);
        // analyze
        assertEquals(24, actual, 0.00000000001);
    }
    public void testdiv(){
        // setup

        // invoke
        double actual = calculon.divide(6, 3);
        // analyze
        assertEquals(10.0, actual, 0.00000000001);
    }
    public void testraise(){
        // setup

        // invoke
        double actual = calculon.add(2, 2);
        // analyze
        assertEquals(4, actual, 0.00000000001);
    }
    }
