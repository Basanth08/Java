package unit07;

import org.junit.jupiter.api.Test;
import unit07.practicum.ArrayHeap;
import static org.junit.jupiter.api.Assertions.*;
public class ArrayHeapTest {

    @Test
    public void testArrayheap() {
        ArrayHeap heap = new ArrayHeap();
        heap.add(10);
        assertEquals(10, heap.remove());
        heap.add(20);
        heap.add(5);
        assertEquals(5, heap.remove());
        heap.add(30);
        heap.add(1);
        assertEquals(1, heap.remove());
        assertEquals(2, heap.size()); 
        assertEquals(20, heap.remove());
        assertEquals(30, heap.remove());
        assertEquals(0, heap.size());
    }
}
