package unit05.mcf;

import java.util.Arrays;
import java.util.Iterator;

import unit05.ArrayIterator;

public class ArrayList <E> implements List <E> {
    private Object[] elements;
    private int size;

    public ArrayList () {
        elements = new Object [2];
    }

    @Override
    public void append(E value) {
        if (size == elements.length) {
            elements = Arrays.copyOf (elements, size * 2);
        }
        elements [size] = value;
        size++;
    }

    @Override
    public E get(int index) {
        return (E) elements [index];
    }

    @Override
    public void set(int index, E value) {
        elements [index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return size + ", " + Arrays.toString (elements);
    }

    @Override
    public Iterator<E> iterator () {
        System.out.println ("ArrayList Iterator");
        return new ArrayIterator<> (elements, size);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<> ();
        System.out.println (list);

        list.append ("First");
        System.out.println (list);
        list.append ("Second");
        System.out.println (list);
        list.append ("Third");
        System.out.println (list);
        list.append ("Fourth");
        System.out.println (list);
        list.append ("Fifth");
        System.out.println (list);
        list.append ("Sixth");
        System.out.println (list);
    }
}