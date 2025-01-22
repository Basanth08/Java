package practicum2.question2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyDequeTest {
    @Test
    public void create() {
        // setup - none

        // invoke
        Deque<String> deque = new MyDeque<>();

        // analyze
        assertEquals(0, deque.size());
    }

    @Test
    public void enqueueFront() {
        // setup
        String element = "a";
        Deque<String> deque = new MyDeque<>();

        // invoke
        deque.enqueueFront(element);

        // analyze
        assertEquals(1, deque.size());
    }

    @Test
    public void enqueueBack() {
        // setup
        String element = "b";
        Deque<String> deque = new MyDeque<>();

        // invoke
        deque.enqueueBack(element);

        // analyze
        assertEquals(1, deque.size());
    }

    @Test
    public void enqueueFrontDequeueFront() {
        // setup
        String expected = "c";
        Deque<String> deque = new MyDeque<>();
        deque.enqueueFront(expected);

        // invoke
        String actual = deque.dequeueFront();

        // analyze
        assertEquals(0, deque.size());
        assertEquals(expected, actual);
    }

    @Test
    public void enqueueBackDequeueBack() {
        // setup
        String expected = "d";
        Deque<String> deque = new MyDeque<>();
        deque.enqueueBack(expected);

        // invoke
        String actual = deque.dequeueBack();

        // analyze
        assertEquals(0, deque.size());
        assertEquals(expected, actual);
    }

    @Test
    public void enqueueFrontDequeueBack() {
        // setup
        String expected = "e";
        Deque<String> deque = new MyDeque<>();
        deque.enqueueFront(expected);

        // invoke
        String actual = deque.dequeueBack();

        // analyze
        assertEquals(0, deque.size());
        assertEquals(expected, actual);
    }

    @Test
    public void enqueueBackDequeueFront() {
        // setup
        String expected = "f";
        Deque<String> deque = new MyDeque<>();
        deque.enqueueBack(expected);

        // invoke
        String actual = deque.dequeueFront();

        // analyze
        assertEquals(0, deque.size());
        assertEquals(expected, actual);
    }

    @Test
    public void enqueueDequeueMany() {
        Deque<Integer> deque = new MyDeque<>();

        deque.enqueueFront(123);
        deque.enqueueBack(456);
        deque.enqueueFront(789);
        deque.enqueueBack(987);

        assertEquals(4, deque.size());
        assertEquals(789, deque.dequeueFront());
        assertEquals(3, deque.size());
        assertEquals(987, deque.dequeueBack());
        assertEquals(2, deque.size());
        assertEquals(123, deque.dequeueFront());
        assertEquals(1, deque.size());
        assertEquals(456, deque.dequeueBack());
        assertEquals(0, deque.size());
    }

    @Test
    public void forEach() {
        int[] expected = {333, 111, 222, 444};
        Deque<Integer> deque = new MyDeque<>();

        deque.enqueueFront(111);
        deque.enqueueBack(222);
        deque.enqueueFront(333);
        deque.enqueueBack(444);

        int index = 0;
        for(int element : deque) {
            assertEquals(expected[index++], element);
        }
    }
}
