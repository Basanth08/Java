package unit11.activities;

public class TheCount implements Runnable {
    private static final int[] COUNT = new int[1];
    private final int id;

    public TheCount (int id) {
        this.id = id;
    }

    @Override
    public void run() {
        
        System.out.println ("Starting " + id);
        for (int i = 0; i < 100000; i++) {
            synchronized (COUNT) {
                COUNT [0] += 1;
            }
        }
        System.out.println ("Ending " + id);

    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread (new TheCount (i));
            thread.start ();
            threads [i] = thread;
        }

        for (int i = 0; i < threads.length; i++) {
            threads [i].join ();
        }

        System.out.println (COUNT [0]);
    }
}
