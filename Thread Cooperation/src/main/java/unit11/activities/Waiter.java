package unit11.activities;

public class Waiter implements Runnable {
    private final Object lock;

    public Waiter (Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                lock.wait ();
            }
        } catch (InterruptedException ie) {}
        System.out.println ("I'm awake!");
    }

    public static void main (String[] args) throws InterruptedException {
        Object lock = new Object ();
        for (int i = 0; i < 10; i++) {
            new Thread (new Waiter (lock)).start ();
        }

        Thread.sleep (50);

        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
