package unit01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class calculon {
    public static double add(double x, double y) 
    {
        return x+y;
        // System.out.println(x+y);
    }
    public static double sub(double x, double y) {
        return x-y;
        // System.out.println(x-y); 
    }
    public static double mul(double x, double y) {
        // System.out.println(x*y);
        return x*y;
    }
    public static double divide(double x, double y) {
        // System.out.println(x/y);
        return x/y;
    }
    public static double raise(double x, double y) {
        double result = 1;
        for (int count = 0; count < y; count++){
            result*=x;
        }
        return result;    
    }
    
    
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            try{
            System.out.println("Enter the value of x and y :");
            int x = sc.nextInt();
            // System.out.println("Enter the value of y:");
            int y = sc.nextInt();
            System.out.println(add(x,y));
            System.out.println(sub(x,y));
            System.out.println(mul(x,y));
            System.out.println(divide(x,y));
            System.out.println(raise(x,y));
            }catch(InputMismatchException ime) {
                System.out.println("Invalid integer, Please enter an integer. ");
            }
            sc.close();
        }
    }


