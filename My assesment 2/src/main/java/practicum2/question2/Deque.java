package practicum2.question2;

/**
 * Provided ADT interface. Do not change.
 * 
 * A Deque (pronounced like "deck") is a double-ended queue - 
 * values can be enqueued and dequeued from both ends of the queue. 
 *
 * Operation                   Deque Configuration 
 *
 * d.enqueueFront(111)         {111}, size=1
 * d.enqueueBack(222)          {111, 222}, size=2
 * d.enqueueFront(333)         {333, 111, 222}, size=3
 * d.enqueueBack(444)          {333, 111, 222, 444}, size=4
 * d.dequeueBack()             {333, 111, 222}, size=3
 * d.dequeueFront()            {111, 222}, size=2
 * 
 */
public interface Deque<E> extends Iterable<E> {
    /**
     * Adds element to the front of the queue.
     * @param element Value to add to the queue.
     */
    void enqueueFront(E element);

    /**
     * Adds element to the end of the queue.
     * @param element
     */
    void enqueueBack(E element);

    /**
     * Removes the element at the front of the queue.
     * @return The removed element.
     */
    E dequeueFront();

    /**
     * Removes the element at the back of the queue.
     * @return The removed element.
     */
    E dequeueBack();

    /**
     * Gets the size of the queue.
     * @return Number of elements stored in the queue.
     */
    int size();
}


