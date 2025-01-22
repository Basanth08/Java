package unit10.moonbase.part2;

public class Control {
    private boolean tunnelOccupied = false;

    public void accessTunnel() {
        while (tunnelOccupied) {
            try {
                Thread.sleep(2000); // Sleep for 2 seconds before checking again
            } catch (InterruptedException e) {
                System.out.println("Exception in accessTunnel: " + e.getMessage());
            }
        }
        tunnelOccupied = true;
    }

    public void leaveTunnel() {
        tunnelOccupied = false;
    }
}