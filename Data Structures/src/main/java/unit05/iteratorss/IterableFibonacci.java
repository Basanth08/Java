package unit05.iteratorss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableFibonacci implements Iterable<Long> {
    private final List<Long> fibonum;

    public IterableFibonacci(long a, long b) {
        fibonum = new ArrayList<Long>();
        fibonum.add(a);
        fibonum.add(b);
    }

    public void add() {
        int size = fibonum.size();
        long next = fibonum.get(size - 2) + fibonum.get(size - 1);
        fibonum.add(next);
    }

    @Override
    public String toString() {
        return fibonum.toString();
    }

    public long get(int index) {
        return fibonum.get(index);
    }

    public int length() {
        return fibonum.size();
    }

    @Override
    public Iterator<Long> iterator() {
        return new FibonacciIterator(fibonum);
    }


    public static void main(String[] args) {
        IterableFibonacci fibo = new IterableFibonacci(2, 5);
        fibo.add();
        fibo.add();

        for (Long f : fibo) {
            System.out.println(f);
        }
        System.out.println(fibo.get(0)); 
        System.out.println(fibo.get(1));
        System.out.println(fibo.get(2)); 
        System.out.println(fibo.get(3)); 
        System.out.println("Length of Fibonacci sequence: " + fibo.length());
    }
}
