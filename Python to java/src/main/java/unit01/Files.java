package unit01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Files {
    public static void info(String filename) {
         File file = new File("data/alice.txt");
         System.out.println("Name: " + file.getName());
         System.out.println("Absolute Path: " + file.getAbsolutePath());
         System.out.println("It exits ? " + file.exists());
         System.out.println("length: " + file.length());
        //  String name = file.getName();
        //  boolean exists = file.exits();
    }
    public static void printFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while(line!= null){
            System.out.println(line);
            line = reader.readLine();
        }
        fileReader.close();
        reader.close();
    }
    public static void main(String[] args) {
        try{
            info("data/alice.txt");
            printFile("data/alice.txt");
        }catch(IOException ioe ){
            System.out.println("Error. ");
        }
        
    }
    
}
