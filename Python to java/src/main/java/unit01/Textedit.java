package unit01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Textedit {
    public static void main(String[] args) {
        // try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the filename: ");
            String filename = sc.nextLine();
            try{
            FileWriter fw = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(fw);
            String line = sc.nextLine();
            while (!line.equals(line)){
                writer.println(line);
                writer.flush();
                line = sc.nextLine();
        }
        sc.close();
        fw.close();
        writer.close();
    }catch(IOException io){
        System.out.println("NOPEEEE, something bad happened!  ");
    }
}
}
