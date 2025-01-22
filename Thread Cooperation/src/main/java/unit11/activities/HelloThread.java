package unit11.activities;

public class HelloThread implements Runnable {
    @Override
    public void run() {
        System.out.println ("Hello, World!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread (new HelloThread ());
            thread.start ();
            threads[i] = thread;
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        } 

        System.out.println ("Goodbye!");
    }
}
