package practicum3.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a vertex in a weighted graph. Each vertex keeps track 
 * of its neighbors and the distance to each neighbor.
 * 
 * A weighted vertex can also return a collection of its neighbors sorted based
 * on the weight of the edge to each neighbor (in order from smallest to 
 * largest).
 * 
 * @author GCCIS Faculty
 */
public class WVertex<E> implements Comparator<WVertex<E>> {
    /**
     * The value stored by the vertex.
     */
    private final E value;

    /**
     * The map used to store the neighbor vertices (keys) and the weight of the
     * edge to each neighbor (values).
     */
    private final Map<WVertex<E>, Double> neighbors;

    /**
     * Creates a new weighted vertex with the specified value.
     * 
     * @param value The value stored by the vertex.
     */
    public WVertex(E value) {
        this.value = value;
        this.neighbors = new HashMap<>();
    }

    /**
     * Returns the value stored by this vertex.
     * 
     * @return The value.
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Connects this vertex to its neighbor by an edge with the specified 
     * weight.
     * 
     * @param neighbor The neighbor to which this vertex should be connected.
     * @param weight The weight of the edge connecting the two neighbors.
     */
    public void connect(WVertex<E> neighbor, double weight) {
        neighbors.put(neighbor, weight);
    }

    /**
     * Returns true if this vertex is connected to the specified vertex by an
     * edge.
     * 
     * @param vertex The other vertex.
     * @return True if the other vertex is a neighbor, and false otherwise.
     */
    public boolean connected(WVertex<E> vertex) {
        return neighbors.containsKey(vertex);
    }

    /**
     * Returns the weight of the edge connecting to the specified neighbor.
     * 
     * @param neighbor The neighbor.
     * @return The weight of the edge to the neighbor.
     */
    public double weight(WVertex<E> neighbor) {
        return neighbors.get(neighbor);
    }

    /**
     * Returns the map of this vertex's neighbors.
     * 
     * @return The map of neighbors.
     */
    public Map<WVertex<E>, Double> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * Compares two neighbors based on the weight of the edge to each neighbor.
     * Used to sort neighbors based on the weight from smallest to largest.
     */
    @Override
    public int compare(WVertex<E> a, WVertex<E> b) {
        double weightA = neighbors.get(a);
        double weightB = neighbors.get(b);

        return weightA < weightB ? -1 : 1;
    }

    /**
     * Returns a list of neighbors sorted based on the weight of the edges to
     * each neighbor from smallest to largest.
     * 
     * @return A sorted list of neighbors.
     */
    public List<WVertex<E>> getNearestNeighbors() {
        List<WVertex<E>> nearest = new ArrayList<>(neighbors.keySet());
        Collections.sort(nearest, this);
        return nearest;
    }
}
