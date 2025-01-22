package unit01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SieveValidator {
    public static int[] readSeive(String filename) {
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int size = Integer.parseInt(br.readLine());
            int [] seive = new int[size];
            int index = 0;
            String line;
            while((line = br.readLine()) != null){
                for(char digit : line.toCharArray()){
                    if(digit == '1'){
                        seive[index] = 1;
                    }else{
                        seive[index] = 0;
                    }
                    index ++;
                }
            }
            br.close();
            return seive;
        }catch(IOException io){
            System.out.println("Could'nt read seive: " + io.getMessage());
        return null;
        
        }
    }
    public static int repairseive(int[] seive) {
        System.out.println("Validating seive of Size " + seive.length + "......");
        int er = 0;
        for(int n = 0; n < seive.length; n++){
            if(seive[n]==0 && !primes.isPrime(n)){
                System.out.println(" " + n + " is incorrectly marked as prime: ");
                seive[n] = 1;
                er = er + 1;
            }else if(seive[n] == 1 && primes.isPrime(n)){
                System.out.println(" " + n + " is incorrectly marked as NOT prime." );
                seive[n] = 0;
                er = er + 1;
            }
        }
        System.out.println(" Seive contained " + er );
        System.out.println();
        return er;
    }
    public static void main(String[] args) {
        String[] files = {"data/sieve_10000.txt","data/sieve_1000.txt"}; 
        for(String f : files) {
            int[] sieve = readSeive(f);
            if(sieve != null) {
                repairseive(sieve);
            }
        }
    }
}

