package practicum2.ds;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    int size();
}