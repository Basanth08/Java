package unit01;

import java.util.Scanner;

public class primes {
    public static boolean isPrime(int n) {
        if (n<=1){
            return false;
            // System.out.println("False");
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
        
    }
    public static String sequence(int n) {
        if (n < 1) {
            return ""; 
        }
        String sequence = "";
        while (n > 1) {
            sequence = sequence + n + " "; 
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1; 
            }
        }
        
        sequence = sequence + "1";
        return sequence;
    }
    public static void main(String[] args) {
        // for(int i =1;i<=100;i++){
        //     System.out.println(i + " is the Prime number ? " + " The answer is:" + isPrime(i));
        //     System.out.println(sequence(76));
        //     System.out.println(sequence(87));
        Scanner sc = new Scanner(System.in);
        int n;
        // lets assume a case here
        boolean yesorno = true;
        while(yesorno){
            System.out.println("Enter a number other than zero:");
            n = sc.nextInt();
            if(n==0){
                yesorno = false;
                // it will break
            }
            else{
                if(isPrime(n)){
                    System.out.println(n + " is a prime number.");
                }
                else{
                    System.out.println(n + " is not a prime number.");
                }
                System.out.println("Enter another Natural number for Collatz Sequence: ");
                n = sc.nextInt();
                if(n<1){
                    yesorno = false;
                    // it will break
                }
                else{
                    System.out.println(sequence(n));
                }
            }
        }
        sc.close();
        }   
    }
 