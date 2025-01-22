package unit10.moonbase.part2;

public class Rover implements Runnable {
    private String name;
    private int time;
    private String startHub;
    private String endHub;
    private Control control;

    public Rover(String name, int time, String startHub, String endHub, Control control) {
        this.name = name;
        this.time = time;
        this.startHub = startHub;
        this.endHub = endHub;
        this.control = control;
    }

    public void run() {
        System.out.println(name + " (" + time + ") " + "is ready to start traversal at the " + startHub + " end of the tunnel.");
        control.accessTunnel();
        System.out.println(name + " (" + time + ") " + "is starting traversal.");

        for (int i = 1; i <= time; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception reached.");
            }
            System.out.println("\t" + name + " (" + time + "): " + i + " seconds.");
        }

        System.out.println(name + " (" + time + ") " + "has completed traversal and has reached the " + endHub + " end of the tunnel.");
        control.leaveTunnel();
    }

    public static void main(String[] args) {
        Control control = new Control();

        Rover rover1 = new Rover("Rover1", 5, "Hyperion", "Odyssey", control);
        Rover rover2 = new Rover("Rover2", 3, "Odyssey", "Hyperion", control);
        Rover rover3 = new Rover("Rover3", 7, "Hyperion", "Odyssey", control);
        Rover rover4 = new Rover("Rover4", 4, "Odyssey", "Hyperion", control);

        Thread thread1 = new Thread(rover1);
        Thread thread2 = new Thread(rover2);
        Thread thread3 = new Thread(rover3);
        Thread thread4 = new Thread(rover4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

