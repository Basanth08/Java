package practicum3.graphs;

/**
 * Represents a path tuple as used by Dijkstra's Shortest Path algorithm.
 * 
 * @autho GCCIS Faculty
 */
public class PathTuple<E> {
    /**
     * The vertex that owns this path tuple.
     */
    private final WVertex<E> vertex;

    /**
     * The predecessor vertex on the shortest known path; may be null.
     */
    private WVertex<E> predecessor;

    /**
     * The total known shortest distance from the start vertex; may be infinite.
     */
    private double distance;

    /**
     * Creates a new path tuple with the specified vertex, a null predecessor,
     * and an infinite distance from start.
     * 
     * @param vertex The vertex that owns this tuple.
     */
    public PathTuple(WVertex<E> vertex) {
        this(vertex, null, Double.POSITIVE_INFINITY);
    }

    /**
     * Creates a new path tuple with the specified vertex, predecessor, and 
     * distance from start.
     * 
     * @param vertex The vertex that owns this tuple.
     * @param predecessor The predecessor on the shortest path.
     * @param distance The total known shortest distance from start.
     */
    public PathTuple(WVertex<E> vertex, WVertex<E> predecessor, double distance) {
        this.vertex = vertex;
        this.predecessor = predecessor;
        this.distance = distance;
    }

    /**
     * Returns the predecessor vertex on the shortest known path.
     * 
     * @return The predecessor vertex on the shortest known path.
     */
    public WVertex<E> getPredecessor() {
        return predecessor;
    }

    /**
     * Returns the vertex that owns this tuple. 
     * 
     * @return The vertex that owns this tuple.
     */
    public WVertex<E> getVertex() {
        return vertex;
    }

    /**
     * returns the shortest known distance from the start vertex.
     * 
     * @return The shortest known distance from the start vertex.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Updates the predecessor vertex and shortest known distance from start
     * iff the distance is shorter than the current distance. If the distance
     * is not shorted, the update will be ignored.
     * 
     * @param predecessor The new predecessort vertex.
     * @param distance The new distance.
     */
    public void update(WVertex<E> predecessor, double distance) {
        if(distance < this.distance) {
            this.predecessor = predecessor;
            this.distance = distance;
        }
    }

    @Override
    public String toString() {
        return vertex + 
            ":(" 
            + predecessor 
            + ", " + distance 
            + ")";
    }
}
