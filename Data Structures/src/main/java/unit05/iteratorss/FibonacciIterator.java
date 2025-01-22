package unit05.iteratorss;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Long> {
    private final List<Long> fibonacciSequence;
    private int currentIndex = 0;

    public FibonacciIterator(List<Long> sequence) {
        this.fibonacciSequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < fibonacciSequence.size();
    }

    @Override
    public Long next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the Fibonacci sequence.");
        }
        return fibonacciSequence.get(currentIndex++);
    }
}
