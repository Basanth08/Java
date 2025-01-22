package unit09.practicum;

import unit09.graphs.WAdjacencyGraph;
import unit09.graphs.WPath;

public class Word {
    public static void main(String[] args) {
        WAdjacencyGraph<String> graph = new WAdjacencyGraph<>();

        // Adding the vertices
        graph.add("P");
        graph.add("R");
        graph.add("A");
        graph.add("C");
        graph.add("T");
        graph.add("I");
        graph.add("c");
        graph.add("U");
        graph.add("M");

        // Add the edges
        graph.connect("P", "R", 1.0);
        graph.connect("P", "A", 2.0);
        graph.connect("P", "C", 3.0);
        graph.connect("R", "A", 1.0);
        graph.connect("R", "C", 2.0);
        graph.connect("R", "T", 3.0);
        graph.connect("A", "C", 1.0);
        graph.connect("A", "T", 2.0);
        graph.connect("A", "I", 3.0);
        graph.connect("C", "T", 1.0);
        graph.connect("C", "I", 2.0);
        graph.connect("C", "c", 3.0);
        graph.connect("T", "I", 1.0);
        graph.connect("T", "c", 2.0);
        graph.connect("T", "U", 3.0);
        graph.connect("I", "c", 1.0);
        graph.connect("I", "U", 2.0);
        graph.connect("I", "M", 3.0);
        graph.connect("c", "U", 1.0);
        graph.connect("c", "M", 2.0);
        graph.connect("U", "M", 1.0);
        graph.connect("M", "P", 1.0);

        // Finding the path between "P" and "M" using the Dijkstra's algorithm
        WPath<String> path = graph.dijkstrasPath("P", "M");

        // Printing the path
        if (path != null) {
            System.out.println(path);
        } else {
            System.out.println("There is no path that is found between 'P' and 'M'.");
        }
    }
}
