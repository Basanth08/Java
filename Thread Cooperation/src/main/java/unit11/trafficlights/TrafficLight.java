package unit11.trafficlights;

public class TrafficLight extends Thread {
    private Color color;
    private final Object lock;
    private final String name;

    public TrafficLight(Object lock, String name) {
        this.color = Color.RED;
        this.lock = lock;
        this.name = name;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    // Spend at least 1 second red
                    Thread.sleep(1000);
                    
                    // Change to green and spend 5 seconds
                    color = Color.GREEN;
                    System.out.println("The " + name + " light changes from RED to GREEN");
                    lock.notifyAll(); // Notify waiting vehicles
                    Thread.sleep(5000);
                    
                    // Change to yellow and spend 2 seconds
                    color = Color.YELLOW;
                    System.out.println("The " + name + " light changes from GREEN to YELLOW");
                    Thread.sleep(2000);
                    
                    // Change to red
                    color = Color.RED;
                    System.out.println("The " + name + " light changes from YELLOW to RED");
                    
                    // Notify the other traffic light
                    lock.notify();
                    
                    // Wait for the other traffic light to complete its cycle
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPTED!!");
                }
            }
        }
    }
    
    public Color getColor() {
        return color;
    }
}