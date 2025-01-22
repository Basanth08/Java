package unit11.activities;

public class Deadlock implements Runnable {
    private final Object lock1;
    private final Object lock2;
    private final String id;

    public Deadlock (String id, Object l1, Object l2) {
        this.id = id;
        lock1 = l1;
        lock2 = l2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.print (id);
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock1 = new Object ();
        Object lock2 = new Object ();

        new Thread (new Deadlock ("T1", lock1, lock2)).start ();
        new Thread (new Deadlock ("T2", lock2, lock1)).start ();
    }
}
