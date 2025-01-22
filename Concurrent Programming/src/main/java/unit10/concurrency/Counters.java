package unit10.concurrency;

import java.util.Scanner;

public class Counters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an number of threads: ");
        int num = in.nextInt();
        in.close();

        Thread [] threads = new Thread[num];
        for (int i = 0; i < threads.length; i ++){
            Runnable runner = new RunnableCounter("Runnable" + i);
            Thread thread = new Thread(new RunnableCounter("Thread" + i));
            thread.start();
        }
        in.close();
    }
}
