package unit11.chevre;
public class TrollBouncer extends Thread {
    private final ClubChevre club;
    
    public TrollBouncer(ClubChevre club) {
        this.club = club;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (club) {
                if (!club.isAtCapacity()) {
                    Goat goat = club.getGoatAtPosition(0);
                    if (goat != null) { // Ensure there's a goat to remove
                        club.removeGoatFromLine(goat);
                        synchronized (goat) {
                            goat.notify();
                        }
                    }
                } else {
                    try {
                        System.out.println("Taking a nap");
                        club.wait(); // Correct use of wait inside the else block
                    } catch (InterruptedException e) {
                        // Handle the InterruptedException, e.g., log it or re-interrupt the thread
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}


