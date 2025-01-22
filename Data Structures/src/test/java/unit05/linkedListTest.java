package unit05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit05.mcf.linkedList;

public class linkedListTest {
    @Test
    public void testAppend(){
        linkedList <String> list = new linkedList<>(null);
        list.append("A");
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testSize() {
        linkedList <Integer> list = new linkedList<>(null);
        assertEquals(0, list.size());
        list.append(1);
        assertEquals(1, list.size());
    }
    
    @Test
     public void testEquals() {
        linkedList<String> list1 = new linkedList <> (null);
        list1.append("A");
        
        linkedList <String> list2 = new linkedList<>(null);
        list2.append("A");
        
        assertTrue(list1.equals(list2));
        
        list2.append("B");
        
        assertFalse(list1.equals(list2));
}
}
