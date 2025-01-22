package practicum3.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * An implementation of an graph using adjacency lists with weighted edges.
 * 
 * @author GCCIS Faculty
 */
public class WAdjacencyGraph<E> implements WGraph<E> {

    /**
     * The map of vertices in the graph.
     */
    private final Map<E, WVertex<E>> vertices;

    /**
     * Creates a new, empty graph.
     */
    public WAdjacencyGraph() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);

        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);
    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);

        return vertexA.connected(vertexB);
    }

    @Override
    public double weight(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);

        return vertexA.weight(vertexB);
    }

    @Override
    public List<E> getValues() {
        List<E> values = new ArrayList<>(vertices.keySet());
        values.sort(null);
        return values;
    }

    @Override
    public WPath<E> nearestNeighbor(E start, E end) {
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitNearestNeighbor(s, e, visited);
    }

    private WPath<E> visitNearestNeighbor(WVertex<E> v, WVertex<E> e, 
        Set<WVertex<E>> visited) {

        if(v == e) {
            WPath<E> path = new WPath<>(e.getValue());
            return path;
        } else {
            for(WVertex<E> n : v.getNearestNeighbors()) {
                if(!visited.contains(n)) {
                    visited.add(n);
                    WPath<E> path = visitNearestNeighbor(n, e, visited);
                    if(path != null) {
                        path.prepend(v.getValue(), v.weight(n));
                        return path;
                    }
                }
            }
        }

        return null;
    }
    @Override
    public String toString() {
        String result = "Weighted Graph:\n";
        for (Map.Entry<E, WVertex<E>> entry : vertices.entrySet()) {
            WVertex<E> vertex = entry.getValue();
            result += vertex.getValue() + ":\n";
            for (Map.Entry<WVertex<E>, Double> neighborEntry : vertex.getNeighbors().entrySet()) {
                WVertex<E> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                result += "  " + neighbor.getValue() + " (" + weight + ")\n";
            }
        }
        return result;
    }

    @Override
    public WPath<E> dijkstrasPath(E start, E end) {
        // step 1: setup
        WVertex<E> startV = vertices.get(start);
        WVertex<E> endV = vertices.get(end);

        Map<WVertex<E>, PathTuple<E>> tuples = new HashMap<>();
        TupleQueue<E> queue = new TupleQueue<>();

        for(E value : vertices.keySet()) {
            WVertex<E> vertex = vertices.get(value);
            PathTuple<E> tuple = new PathTuple<>(vertex);
            tuples.put(vertex, tuple);
            queue.enqueue(tuple);
        }

        tuples.get(startV).update(null, 0);

        // step 2: the main loop
        while(queue.size() > 0) {
            PathTuple<E> tuple = queue.dequeue();
            if(tuple.getDistance() == Double.POSITIVE_INFINITY) {
                // unreachable
                break;
            } else {
                WVertex<E> v = tuple.getVertex();
                Map<WVertex<E>, Double> neighbors = v.getNeighbors();
                for(WVertex<E> n : neighbors.keySet()) {
                    double weight = neighbors.get(n);
                    double distanceToN = tuple.getDistance() + weight;
                    PathTuple<E> nTuple = tuples.get(n);
                    if(distanceToN < nTuple.getDistance()) {
                        nTuple.update(v, distanceToN);
                    }
                }
            }
        }

        // step 3: build the path (distance hack)
        PathTuple<E> tuple = tuples.get(endV);
        double distance = tuple.getDistance();
        if(distance < Double.POSITIVE_INFINITY) {
            WPath<E> path = new WPath<>(endV.getValue(), distance);
            WVertex<E> v = tuple.getPredecessor();
            while(v != null) {
                path.prepend(v.getValue());
                tuple = tuples.get(v);
                v = tuple.getPredecessor();
            }
            return path;
        } else {
            return null;
        }
    }

    protected WVertex<E> getVertex(E value) {
        return vertices.get(value);
    }

    public List<E> bfPath(E start, E end) {
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Queue<WVertex<E>> queue = new LinkedList<>();
        Map<WVertex<E>, WVertex<E>> predecessors = new HashMap<>();

        queue.add(s);
        predecessors.put(s, null);

        while(!queue.isEmpty()) {
            WVertex<E> v = queue.poll();
            if(v == e) {
                break;
            } else {
                Map<WVertex<E>, Double> neighbors = v.getNeighbors();
                for(WVertex<E> n : neighbors.keySet()) {
                    if(!predecessors.containsKey(n)) {
                        predecessors.put(n, v);
                        queue.add(n);
                    }
                }
            }
        }

        return makePath(predecessors, e);
    }

    private List<E> makePath(Map<WVertex<E>, WVertex<E>> predecessors, WVertex<E> end) {
        if(predecessors.containsKey(end)) {
            List<E> path = new LinkedList<>();
            WVertex<E> current = end;
            while(current != null) {
                path.add(0, current.getValue());
                current = predecessors.get(current);
            }
            return path;
        }
        return null;
    }

    @Override
    public List<E> dfPath(E start, E end) {
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitDFPath(s, e, visited);
    }

    private List<E> visitDFPath(WVertex<E> v, WVertex<E> e, Set<WVertex<E>> visited) {
        if(v == e) {
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        } else {
            Map<WVertex<E>, Double> neighbors = v.getNeighbors();
            for(WVertex<E> n : neighbors.keySet()) {
                if(!visited.contains(n)) {
                    visited.add(n);
                    List<E> path = visitDFPath(n, e, visited);
                    if(path != null) {
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }
    
}
