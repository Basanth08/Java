package unit07.sourceTarget;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BFSMain {

    public static AdjacencyGraphST<String> makeAdjacencyGraphST(String filename) throws IOException {
        AdjacencyGraphST<String> graph = new AdjacencyGraphST<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String sourceLine = br.readLine();
            String targetLine = br.readLine();

            String[] sourceVertices = sourceLine.split(" ");
            String[] targetVertices = targetLine.split(" ");

            for (String vertex : sourceVertices) {
                graph.addVertex(vertex);
                graph.addSourceVertex(vertex);
            }

            for (String vertex : targetVertices) {
                graph.addVertex(vertex);
                graph.addTargetVertex(vertex);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] vertices = line.split(" ");
                String vertex1 = vertices[0];
                graph.addVertex(vertex1);

                for (int i = 1; i < vertices.length; i++) {
                    String vertex2 = vertices[i];
                    graph.addVertex(vertex2);
                    graph.addEdge(vertex1, vertex2);
                }
            }
        }
        return graph;
    }

    public static AdjacencyGraphSTv2<String> makeAdjacencyGraphSTv2(String filename) throws IOException {
        AdjacencyGraphSTv2<String> graph = new AdjacencyGraphSTv2<>("s", "t");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String sourceLine = br.readLine();
            String targetLine = br.readLine();

            String[] sourceVertices = sourceLine.split(" ");
            String[] targetVertices = targetLine.split(" ");

            for (String vertex : sourceVertices) {
                graph.addVertex(vertex);
                graph.addSourceVertex(vertex);
            }

            for (String vertex : targetVertices) {
                graph.addVertex(vertex);
                graph.addTargetVertex(vertex);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] vertices = line.split(" ");
                String vertex1 = vertices[0];
                graph.addVertex(vertex1);

                for (int i = 1; i < vertices.length; i++) {
                    String vertex2 = vertices[i];
                    graph.addVertex(vertex2);
                    graph.addEdge(vertex1, vertex2);
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        String[] filenames = {"data/bfs/graph1.txt", "data/bfs/graph2.txt", "data/bfs/graph3.txt"};

        for (String filename : filenames) {
            try {
                System.out.println("Testing AdjacencyGraphST with " + filename);
                AdjacencyGraphST<String> graph = makeAdjacencyGraphST(filename);
                boolean pathExists = graph.bfSearch();
                System.out.println("Path exists: " + pathExists);
                if (pathExists) {
                    List<String> path = graph.bfPath();
                    System.out.println("Shortest path: " + path);
                }
                System.out.println();

                System.out.println("Testing AdjacencyGraphSTv2 with " + filename);
                AdjacencyGraphSTv2<String> graphV2 = makeAdjacencyGraphSTv2(filename);
                boolean pathExistsV2 = graphV2.bfSearch();
                System.out.println("Path exists: " + pathExistsV2);
                if (pathExistsV2) {
                    List<String> pathV2 = graphV2.bfPath();
                    System.out.println("Shortest path: " + pathV2);
                }
                System.out.println();
            } catch (IOException e) {
                System.out.println("Error reading file: " + filename);
            }
        }
    }
}