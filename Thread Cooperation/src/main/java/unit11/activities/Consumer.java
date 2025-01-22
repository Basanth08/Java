package unit11.activities;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<String> queue;
    private final String id;

    public Consumer (String id, Queue <String> queue) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        for (;;) {
            synchronized (queue) {
                if (!queue.isEmpty ()) {
                    String item = queue.remove ();
                    System.err.println (id + " removed " + item);
                }
                else {
                    try {
                        queue.wait ();
                        System.out.println (id + " Waiting ...");
                    } catch (InterruptedException ie) {}
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<> ();
        queue.add ("First");
        queue.add ("Second");

        new Thread (new Consumer ("C1", queue)).start ();
    }
}
