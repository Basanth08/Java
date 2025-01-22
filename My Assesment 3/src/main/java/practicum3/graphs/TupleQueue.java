package practicum3.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * A priority queue for path tuples. Always returns the path tuple with the
 * shortest distance from start. If the shortest distance is infinity, it means
 * that the vertex is not reachable.
 * 
 * @author GCCIS Faculty
 */
public class TupleQueue<E> {
    /**
     * The list used to store the path tuples.
     */
    private final List<PathTuple<E>> queue;

    /**
     * Creates a new, empty queue.
     */
    public TupleQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Adds the specified path tuple to the back of the queue. 
     * 
     * Runs in constant time: O(1)
     * 
     * @param element The path tuple added to the back of the queue.
     */
    public void enqueue(PathTuple<E> element) {
        queue.add(element);
    }

    /**
     * Uses a linear search to find, remove, and return the path tuple with the
     * shortest distance from start. If the distance is infinity, it means that
     * the vertex is not reachable (i.e. in a separate connected component).
     * 
     * Runs in linear time: O(n)
     * 
     * @return The path tuy
     */
    public PathTuple<E> dequeue() {
        int index = 0;
        PathTuple<E> closest = queue.get(index);

        for(int i=1; i<queue.size(); i++) {
            PathTuple<E> candidate = queue.get(i);
            if(candidate.getDistance() < closest.getDistance()) {
                closest = candidate;
                index = i;
            }
        }

        queue.remove(index);

        return closest;
    }

    /**
     * Returns the number of path tuples currently stored in the queue.
     * 
     * @return The size of the queue.
     */
    public int size() {
        return queue.size();
    } 
}
