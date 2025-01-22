package unit11.activities;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private final Queue<String> queue;
    private final String id;
    private static final Random RANDOM = new Random ();

    public Producer (String id, Queue <String> queue) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {  
        int num = 0;
        while (true) {
            for (int i = 0; i < RANDOM.nextInt (1, 6); i++) {
                synchronized (queue) {
                    queue.add (id + " Message " + num++);
                    queue.notifyAll ();
                }
            }
        }  
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<> ();

        for (int i = 0; i < 5; i++) {
            new Thread (new Consumer ("C" + (i + 1), queue)).start ();
        }

        for (int i = 0; i < 2; i++) {
            new Thread (new Producer ("P" + (i + 1), queue)).start ();
        }
    }
}
