package unit10.concurrency;

public class CounterThread extends Thread {
    private String name;

    public CounterThread (String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new CounterThread("Thread1");
        thread.start();
        int count = 0;
        while (thread.isAlive()){
            count++;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        for (char c = 'A'; c <= 'Z'; c++){
            System.out.print(c + " ");
        }
        System.out.println("");
        System.out.println("Busy waits: " + count);
        // thread.start();
    }
}
