package unit11.practicum;

import java.util.Scanner;

public class SequentialCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();
        input.close();

        Thread[] threads = new Thread[n];

        for (int i = 1; i <= n; i++) {
            final int num = i;
            threads[i - 1] = new Thread(() -> System.out.println(num));
        }

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Interupted");
            }
        }
    }
}
