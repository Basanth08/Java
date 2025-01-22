package unit03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import unit03.practicum.Test;
import unit03.toys.Robot;
public class toysTest {

    @Test 
    public void testRobot() {
        Robot r = new Robot("Beepppp", 29.99); 
        assertEquals("Robot", r.getName());
        assertTrue(r.getProductCode() >= 1000000); 
}
}
