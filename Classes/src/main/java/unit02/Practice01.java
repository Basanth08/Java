package unit02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Practice01 {
    
        public static String arrayToString(int[] array) {
            String result = "[";
    
            for(int index = 0; index < array.length; index++) {
                result += array[index];
                if(index != array.length - 1) {
                    result = result +  ", ";
                }
            }
            result += "]";
            return result;
        }
        public static int printLines(String filename, char letter) {
            int count = 0;
            try {
                File fi = new File(filename);
                BufferedReader br = new BufferedReader(new FileReader(fi));
                String line;
                while((line = br.readLine()) != null) {
                    if(line.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) {
                        System.out.println(line);
                        count++; 
                    }
                }
                br.close();
            } catch (IOException ioe) {
                System.out.println("Error occurred: " + ioe.getMessage());
            }
            return count;
        }
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3};
            String str1 = arrayToString(arr1);
            System.out.println(str1);
            int[] arr2 = {5, 7, 9, 11};
            String str2 = arrayToString(arr2);
            System.out.println(str2);
            String file = "data/alice.txt";
            char[] letters = {'a'};
            for(char letter : letters) {
                int count = printLines(file, letter);
                System.out.println(letter + ": " + count); 
            }
    }
    }





     