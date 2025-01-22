package practicum2.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTMinMaxTest {
    
    @Test
    public void testGetMin() {
        BSTMinMax<Integer> bst = new BSTMinMax<>(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
        
        assertEquals(1, bst.getMin());
    }
    
    @Test
    public void testGetMax() {
        BSTMinMax<Integer> bst = new BSTMinMax<>(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
        
        assertEquals(9, bst.getMax());
    }
}