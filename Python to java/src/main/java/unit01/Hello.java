package unit01;

import java.util.Scanner;

public class Hello {
    public static void helloyou() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Hello " + name + " !");
        sc.close();
    }
    public static void main(String[] args) {
        helloyou();
    }
}
