package unit11.trafficlights;

import java.util.LinkedList;
import java.util.Queue;

public class Intersection {
    private final TrafficLight northSouthLight;
    private final TrafficLight eastWestLight;
    private final Queue<Vehicle> northSouthQueue;
    private final Queue<Vehicle> eastWestQueue;

    public Intersection() {
        northSouthLight = new TrafficLight(new Object(), "North/South");
        eastWestLight = new TrafficLight(northSouthLight, "East/West");
        northSouthQueue = new LinkedList<>();
        eastWestQueue = new LinkedList<>();
        northSouthLight.start();
        eastWestLight.start();
    }

    public synchronized void driveThrough(Vehicle vehicle) {
        Direction direction = vehicle.getDirection();
        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            northSouthQueue.add(vehicle);
            if (northSouthLight.getColor() != Color.GREEN) {
                System.out.println("  Vehicle (" + vehicle.getId() + ") headed " + direction + " stops because the light is " + northSouthLight.getColor() + ".");
            } else {
                allowTraffic();
            }
        } else {
            eastWestQueue.add(vehicle);
            if (eastWestLight.getColor() != Color.GREEN) {
                System.out.println("  Vehicle (" + vehicle.getId() + ") headed " + direction + " stops because the light is " + eastWestLight.getColor() + ".");
            } else {
                allowTraffic();
            }
        }
    }

    public synchronized void allowTraffic() {
        if (northSouthLight.getColor() == Color.GREEN) {
            for (Vehicle vehicle : northSouthQueue) {
                System.out.println("Vehicle (" + vehicle.getId() + ") headed " + vehicle.getDirection() + " drives through the intersection.");
            }
            northSouthQueue.clear();
        }
        if (eastWestLight.getColor() == Color.GREEN) {
            for (Vehicle vehicle : eastWestQueue) {
                System.out.println("Vehicle (" + vehicle.getId() + ") headed " + vehicle.getDirection() + " drives through the intersection.");
            }
            eastWestQueue.clear();
        }
    }
}