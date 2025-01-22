import unit06.practicum.*;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack <E> implements Stack<E> {
        private E[] elements;
        private int size;
    
        @SuppressWarnings("unchecked")
        public ArrayStack(int capacity) {
            elements = (E[]) new Object[capacity];
            size = 0;
        }   
    
        @Override
        public int size() {
            return size;
        }
    
        @Override
        public E top() {
            if(size == 0) {
                throw new EmptyStackException();
            }
            return elements[size - 1];
        }
    
        public void ensureCapacity() {
            if(elements.length == size) {
                E[] newElements = (E[])new Object[2 * size + 1]; 
                for(int i=0; i<size; i++){
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
        }

        @Override   
        public void push(E element) {
            ensureCapacity();
            elements[size++] = element;
        }
    
        @Override
        public E pop() {
            if(size == 0) {
                throw new EmptyStackException();
            }
            E top = elements[--size];
            elements[size] = null;
            return top;
        }

        @Override
        public Iterator<E> iterator() {
            throw new UnsupportedOperationException("Unimplemented method 'iterator'");
        }

        public static void main(String[] args) {
            ArrayStack<Integer> stack = new ArrayStack<>(5);
            
            stack.push(1);
            stack.push(2);
            stack.push(3);
    
            for(Integer item : stack) { 
                System.out.println(item);  
                }
            }
 }
        
  