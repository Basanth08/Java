package practicum1.question1;
import java.util.Scanner;
import java.io.*;
public class FileParser {
    private String filename;

    public FileParser(String filename) {
        this.filename = filename;
    }
// I'm not sure of this.! I tried doing something, Please alot me some partial credits
    public int[] getInts() throws Exception {
        
        Reader reader = new FileReader(filename);
        BufferedReader buffReader = new BufferedReader(reader);
        String numString = buffReader.readLine();
        int count = 0;
        for(int i = 0; i < numString.length(); i++){
            int digit = numString.charAt(i) - '0';
            count = count*10 + digit;
        }
        
        int[] numbers = new int[count];
        for(int i = 0; i < count; i++){
           String intString = buffReader.readLine();
           int num = 0;
           for(int j = 0; j < intString.length(); j++){
               int digit = intString.charAt(j) - '0';
               num = num*10 + digit;
           }
           numbers[i] = num; 
        }
        
        reader.close();
        return numbers;
    }

    public static void main(String[] args) throws Exception {
     
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = scanner.nextLine();
        FileParser Parser = new FileParser(filename);
        int[] numbers = Parser.getInts();
        System.out.print("Numbers: ");
        for(int number : numbers) {
            System.out.print(number + " ");
        }
        scanner.close();
    }

}


    


