package unit05.iteratorss;
import java.io.*; 
import java.util.*;

public class IterableReader implements Iterable<String>, 
                                       Iterator<String>, 
                                       AutoCloseable {

    private BufferedReader reader;

    public IterableReader(String fileName) throws IOException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    @Override
    public Iterator<String> iterator() {
        return this; 
    }

    @Override
    public boolean hasNext() {
        try {
            return reader.ready();
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String next() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
    public static void main(String[] args) throws IOException {
        try (IterableReader reader = new IterableReader("data/simple.txt");) 
        {
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }
        }
        try (IterableReader reader = new IterableReader("data/simple.txt");)     
        {
            for (String line : reader) {
                System.out.println(line);
            }
        }
    } 
}