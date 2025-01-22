package unit05.mcf;

public class NodeQueue <E> implements Queue<E> {
    private Node <E> front;
    private Node <E> back;
    private int size;

    public NodeQueue() {
        front = null;
        back = null;
        size = 0;
    }

    public Node <E> getBack() {
        return back;
    }
    public int getSize() {
        return size;
    }
    public Node <E> getFront() {
        return front;
    }
    public int size(){
        return size;
    }
    public void enqueue(E value){
        Node <E> newNode = new Node <> (value);
        if (back != null){
            back.setNext(newNode);  
        }
        else {
            front = newNode;
        }
        back = newNode;
        size++;
    }
    public E dequeue(){
        E value = front.getValue();
        front = front.getNext();
        if (front == null){
            back = null;
        }
        size--;
        return value;
    }
    @Override
    public String toString() {
        return size + " |" + front;
    }
    public static void main(String[] args) {
        Queue <String> queue = new NodeQueue <>();
        System.out.println(queue);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println(queue);
        System.out.println(queue.dequeue() + ": " + queue);
        System.out.println(queue.dequeue() + ": " + queue);
        System.out.println(queue.dequeue() + ": " + queue);
    }
    
}
