package unit10.concurrency;

import java.util.Scanner;

public class AnonymousCounters {
    public static void counter(String name){
        for (int i = 0; i < 101; i++) {
            System.out.println(name + ": " + i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of threads: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i ++){
            String name = "Thread" + i;
            new Thread(() -> counter(name)).start();
        }
        scanner.close();
    }
}
