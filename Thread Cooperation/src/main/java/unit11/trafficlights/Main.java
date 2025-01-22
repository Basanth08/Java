package unit11.trafficlights;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();

        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            int id = i;
            Direction direction = Direction.values()[random.nextInt(4)];
            Vehicle vehicle = new Vehicle(id, direction, intersection);
            vehicle.start();

            try {
                Thread.sleep(random.nextInt(2001));
            } catch (InterruptedException e) {
                System.out.println("INTERRUPTED!!");
            }
        }
    }
}
