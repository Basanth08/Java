package unit11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import unit11.ggg.Trough;


public class GreedyGreedyGoatsTest {
    @Test
    public void testGetTurnipsSoFar() {
        Trough trough = new Trough(10);
        trough.drop();
        trough.drop();
        trough.drop();
        assertEquals(3, trough.getTurnipsSoFar(), "Incorrect number of turnips dropped so far");
    }
 
    @Test
    public void testAtLimit() {
        Trough trough = new Trough(5);
        assertFalse(trough.atLimit(), "Trough should not be at limit initially");
        trough.drop();
        trough.drop();
        trough.drop();
        trough.drop();
        trough.drop();
        assertTrue(trough.atLimit(), "Trough should be at limit after 5 drops");
    }
 
    @Test
    public void testIsEmpty() {
        Trough trough = new Trough(10);
        assertTrue(trough.isEmpty(), "Trough should be empty initially");
        trough.drop();
        trough.drop();
        assertFalse(trough.isEmpty(), "Trough should not be empty after drops");
        trough.eat();
        trough.eat();
        assertTrue(trough.isEmpty(), "Trough should be empty after eating all turnips");
    }
 
    @Test
    public void testEat() {
        Trough trough = new Trough(10);
        trough.drop();
        trough.drop();
        trough.drop();
        assertTrue(trough.eat(), "Goat should be able to eat a turnip");
        assertTrue(trough.eat(), "Goat should be able to eat another turnip");
        
    }
 }