package practicum2.ds;

public class NodeQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int size;
    
    public NodeQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(E value) {
        Node<E> node = new Node<>(value);
        if(front == null) {
            front = node;
            back = node;
        } else {
            back.setNext(node);
            back = node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        E value = (E)front.getValue();
        front = front.getNext();
        if(front == null) {
            back = null;
        }
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }
    
}
