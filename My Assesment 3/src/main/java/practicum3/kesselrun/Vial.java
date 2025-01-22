package practicum3.kesselrun;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a vial that can hold up to a maximum number of coaxium
 * units.
 * 
 * @author GCCIS Faculty
 */
public class Vial {
    /**
     * A list to store the coaxium units.
     */
    private final List<Integer> coaxiumUnits;

    /**
     * The maximum number of coaxium units that can be stored in this vial.
     */
    private final int maxCapacity;

    /**
     * The capacity remaining in this vial; the difference between the maximum
     * capacity and the number of units that have been stored in the vial.
     */
    private int remainingCapacity;

    /**
     * The total number of units stored in the vial so far.
     */
    private int totalUnits;

    /**
     * Creates a new vial with the specified maximum capacity.
     * 
     * @param maxCapacity The maximum capacity of the new vial.
     */
    public Vial(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.remainingCapacity = maxCapacity;
        this.totalUnits = 0;
        this.coaxiumUnits = new ArrayList<>();
    }

    public int getMaxCapacity() { return maxCapacity; }
    public int getTotalUnits() { return totalUnits; }
    public int getRemainingCapacity() { return remainingCapacity; }
    public List<Integer> getCoaxiumUnits() { return coaxiumUnits; }

    /**
     * Adds the given number of units to the vial if it is possible.
     * 
     * @param units the number of units to add
     * @return true if the units could be added, false otherwise
     */
    public boolean addUnits(int units) {
        if (units > remainingCapacity) {
            return false;
        }

        coaxiumUnits.add(units);
        remainingCapacity -= units;
        totalUnits += units;
        return true;
    }

    @Override
    public String toString() {
        return totalUnits + "/" + maxCapacity + coaxiumUnits;
    }
}
