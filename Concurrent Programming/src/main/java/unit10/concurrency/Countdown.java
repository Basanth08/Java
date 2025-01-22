package unit10.concurrency;

public class Countdown implements Runnable{
    
    @Override
    public void run(){
        for (int i = 10; i >= 0; i--){
            System.out.println("T-" + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Blastoff!");
    }
    public static void main(String[] args) {
        Runnable runner = new Countdown();
        Thread thread = new Thread(runner);
        thread.run();
    }
}
