package unit11.practicum;

public class EvenAndOdds {
    public class EvensAndOdds {
        public static void main(String[] args) {
            Thread oddThread = new Thread(() -> {
                for (int i = 1; i <= 99; i += 2) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("Interupted");
                    }
                }
            });
    
            Thread evenThread = new Thread(() -> {
                for (int i = 2; i <= 100; i += 2) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("Interupted");
                    }
                }
            });
    
            oddThread.start();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Interupted");
            }
            evenThread.start();
        }
    }
}