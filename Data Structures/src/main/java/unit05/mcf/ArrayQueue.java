package unit05.mcf;

import java.util.Arrays;

public class ArrayQueue <E> implements Queue <E>{

    private E[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(int capacity){
        elements = (E[]) new Object[capacity];
        front = 0;
        back = 0;
        size = 0;
    }
    public ArrayQueue(){
        this(3);
    }

    @Override
    public int size() {
        return 0;
    }

    private void resize () {
        E [] bigger = (E[]) new Object [size * 2];
        for (int index = 0; index < size; index++) {
            int oldIndex = (front + index) % size;
            /*
            int oldIndex = front + index;
            if (oldIndex >= size) {
                oldIndex = oldIndex - size;
            }
             */
            bigger [index] = elements [oldIndex]; 
        }
        front = 0;
        back = size;
        elements = bigger;
    }

    @Override
    public void enqueue(E value) {
        if(size == elements.length){
            resize();
        }
        elements[back] = value;
        back++;
        if (back == elements.length){
            back = 0;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        E value = (E) elements[front];
        elements[front] = null;
        front ++;
        if(front == elements.length){
            front = 0;
        }
        return value;
    }

    @Override
    public String toString(){
        return size + ", " + Arrays.toString(elements);
    }
    public static void main(String[] args) {
        Queue <String> queue = new ArrayQueue <>();
        System.out.println(queue);

        queue.enqueue("1");
        System.out.println(queue);
        queue.enqueue("2");
        System.out.println(queue);
        queue.enqueue("3");
        System.out.println(queue);
        queue.enqueue("4");
        System.out.println(queue);
        queue.enqueue("5");
        System.out.println(queue);
        queue.enqueue("6");
        System.out.println(queue);
        System.out.println(queue.dequeue() + ": " + queue);
        System.out.println(queue.dequeue() + ": " + queue);
        System.out.println(queue.dequeue() + ": " + queue);
        System.out.println(queue.dequeue() + ": " + queue) ;
        
    }



    
}
