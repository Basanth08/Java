package unit11.ggg;

import java.util.Random;

public class TurnipDropper implements Runnable {
    private final Trough trough;
    private final Random random;

    public TurnipDropper(Trough trough) {
        this.trough = trough;
        this.random = new Random();
    }

    private void dropTurnips() {
        int numTurnips = random.nextInt(3) + 1;
        synchronized (trough) {
            for (int i = 0; i < numTurnips; i++) {
                if (!trough.atLimit()) {
                    trough.drop();
                } else {
                    break;
                }
            }
            System.out.println("The dropper drops " + numTurnips + " turnips into the trough!");
            trough.notifyAll();
        }
    }

    @Override
    public void run() {
        System.out.println("The turnip dropper starts dropping turnips!");
        while (!trough.atLimit()) {
            dropTurnips();
            try {
                Thread.sleep(random.nextInt(251));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("The turnip dropper has run out of turnips!");
    }
}


