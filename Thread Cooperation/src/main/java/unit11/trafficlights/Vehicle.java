package unit11.trafficlights;

public class Vehicle extends Thread {
    private final int id;
    private final Direction direction;
    private final Intersection intersection;

    public Vehicle(int id, Direction direction, Intersection intersection) {
        this.id = id;
        this.direction = direction;
        this.intersection = intersection;
    }

    @Override
    public void run() {
        intersection.driveThrough(this);
    }

    public long getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }
}
