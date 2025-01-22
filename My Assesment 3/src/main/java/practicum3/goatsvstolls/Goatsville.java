package practicum3.goatsvstolls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import practicum3.graphs.WGraph;
import practicum3.graphs.WAdjacencyGraph;

public class Goatsville {
    public static List<String> readLocations(String filename) 
        throws IOException {
        try(FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr)) {
            List<String> lines = new ArrayList<>();
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            return lines;
        }
    }

    public static WGraph<String> buildGoatsville(List<String> lines) {
        WGraph<String> graph = new WAdjacencyGraph<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String origin = parts[0].trim();
            String destination = parts[1].trim();
            String tollString = parts[2].trim();
    
            if (!graph.contains(origin)) {
                graph.add(origin);
            }
            if (!graph.contains(destination)) {
                graph.add(destination);
            }
    
            try {
                double toll = Double.parseDouble(tollString);
                graph.connect(origin, destination, toll);
            } catch (NumberFormatException e) {
                System.err.println("Invalid toll value: " + tollString);
            }
        }
    
        return graph;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = readLocations("data/goatsville.csv");
        WGraph<String> graph = buildGoatsville(lines);
        System.out.println(graph);
    }
}

