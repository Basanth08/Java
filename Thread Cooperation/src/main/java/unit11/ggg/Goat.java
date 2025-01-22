package unit11.ggg;


public class Goat implements Runnable {
    private final Color color;
    private final Trough trough;
    private int turnipsEaten;

    public Goat(Color color, Trough trough) {
        this.color = color;
        this.trough = trough;
        this.turnipsEaten = 0;
    }

    public Color getColor() {
        return color;
    }

    public int getTurnipsEaten() {
        return turnipsEaten;
    }

    @Override
    public String toString() {
        return "The " + color + " goat";
    }

    public void waitForTurnips() {
        synchronized (trough) {
            try {
                trough.wait();
                System.out.println("The " + color + " goat is waiting for more turnips.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        while (!trough.atLimit()) {
            waitForTurnips();
                while (!trough.isEmpty()) { 
                    tryToEat();
                }
            
        }
    }

    public void tryToEat() {
        synchronized (trough) {
            if (trough.eat())
                turnipsEaten++;
            System.out.println("The " + color + " goat has eaten a turnip!");
        }
    }
        }


