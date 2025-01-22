package practicum1.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    public void testTheString() {
        Rectangle rect = new Rectangle(2, 3); 
        String expected = "Rectangle [ Area=6.0 ]";
        assertEquals(expected, rect.toString());
    }

    @Test
    public void testEqualsCase() {
        Rectangle rect1 = new Rectangle(2, 3);
        Rectangle rect2 = new Rectangle(2, 3);
        assertTrue(rect1.equals(rect2)); 
    }
}
