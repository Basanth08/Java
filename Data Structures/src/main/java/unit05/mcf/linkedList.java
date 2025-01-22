package unit05.mcf;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class linkedList <E> implements List <E> {
    private Node <E> head;
    private Node <E> tail;
    private int size;

    public linkedList(Node <E> head, Node <E> tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = 0;
    }
    
    public linkedList(List <E> list){
        head = null;
        tail = null;
        size = 0;
        if(list != null){
            for (E element : list){
                append(element);
            }
        }
       
    }

    public void append(E value){
        Node <E> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public Node <E> getHead(){
        return head;
    }

    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node <E> current = head;
        int position = 0;
        while(position < index) {
            current = current.getNext();
            position++;
        }
        return (E) current.getValue();
    }

    public void set(int index, E value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node <E> current = head;
        int position = 0;
        while(position < index) {
            current = current.getNext();
            position++;
        }
        current.setValue(value);
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder elementsString = new StringBuilder();
        elementsString.append("[");
        
        Node<E> current = head;
        while(current != null) {
            elementsString.append(current.getValue());
            if(current.next != null) {
            elementsString.append(", ");
            }  
            current = current.next;        
        }
        
        elementsString.append("]");
    
        return size + ", " + elementsString.toString(); 
    }

    @Override
    public boolean equals(Object obj) {

    if(this == obj) {
        return true;
    }
    
    if(!(obj instanceof linkedList)) { 
        return false;
    }
    linkedList<E> other = (linkedList<E>)obj; 
    
    if(size != other.size()) {
        return false;
    }
    
    Node<E> n1 = head;
    Node<E> n2 = other.getHead();
    
    while(n1 != null) {
        if(!n1.getValue().equals(n2.getValue())) {
        return false;
        }
                
        n1 = n1.getNext();
        n2 = n2.getNext();
    }
    
    return true;
    }

    public static void main(String[] args) {
        linkedList <String> list1 = new linkedList<>(null);
        list1.append("A");
        list1.append("B");
        list1.append("C");
        System.out.println(list1);
        
        linkedList <String> list2 = new linkedList<>(null);
        list2.append("D");
        list2.append("E");
        list2.append("F");
        System.out.println(list2);

        boolean equal = list1.equals(list2);
        System.out.println(equal);
    }
}


    

