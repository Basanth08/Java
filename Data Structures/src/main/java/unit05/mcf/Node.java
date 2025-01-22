package unit05.mcf;

public class Node <E>{
    private E value;
    Node <E> next;
    public Object data;

    public Node (E value, Node <E> next) {
        this.value = value;
        this.next = next;
    }

    public Node(E value){
        this(value, null);
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setNext(Node <E> next) {
        this.next = next;
    }

    public Node <E> getNext() {
        return next;
    }

    public E getValue() {
        return value;
    }
    @Override
    public String toString(){
        return value + " -> " + next;
    }

    public static void main(String[] args) {
        Node <Integer> node1 = new Node<>(7);
        Node <Integer> node2 = new Node<>(8, node1);

        System.out.println(node2);
    }
}
