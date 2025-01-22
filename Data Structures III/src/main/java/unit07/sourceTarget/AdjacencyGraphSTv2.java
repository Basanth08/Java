package unit07.sourceTarget;
import java.util.*;
import unit07.graphs.AdjacencyGraph;

public class AdjacencyGraphSTv2<E> extends AdjacencyGraph<E>{
    private AdjacencyGraph<E> graph;
    private E dummySource;
    private E dummyTarget;

    public AdjacencyGraphSTv2(E dummySource, E dummyTarget) {
        graph = new AdjacencyGraph<>();
        this.dummySource = dummySource;
        this.dummyTarget = dummyTarget;
        graph.addVertex(dummySource);
        graph.addVertex(dummyTarget);
    }

    public void addVertex(E vertex) {
        graph.addVertex(vertex);
    }

    public void addEdge(E vertex1, E vertex2) {
        graph.addEdge(vertex1, vertex2);
    }

    public void addSourceVertex(E vertex) {
        graph.addEdge(dummySource, vertex);
    }

    public void addTargetVertex(E vertex) {
        graph.addEdge(vertex, dummyTarget);
    }

    public boolean bfSearch() {
        return graph.bfPath(dummySource, dummyTarget) != null;
    }

    public List<E> bfPath() {
        List<E> path = graph.bfPath(dummySource, dummyTarget);
        if (path != null) {
            path.remove(0); 
            path.remove(path.size() - 1); 
        }
        return path;
    }
}
