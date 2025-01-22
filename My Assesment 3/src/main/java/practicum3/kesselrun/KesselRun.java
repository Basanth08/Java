package practicum3.kesselrun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KesselRun {
    /**
     * This function implements a greedy algorithm to fill a list of vials with the
     * given coaxium units, using the fewest number of vials possible.
     * 
     * @param coaxiumUnits a list of coaxium units
     * @param vialMaxCapacity the maximum capacity of each vial
     * @return a list of vials that contain the coaxium units
     */
    // Sort the coaxiumUnits list in descending order
    // This ensures that larger units are placed first, minimizing the number of vials needed

    // Create a new vial with the given vialMaxCapacity

    // Iterate through each coaxium unit in the sorted list
    //     If the current vial has enough remaining capacity to accommodate the unit
    //         Add the unit to the current vial
    //     Else
    //         Create a new vial with the given vialMaxCapacity
    //         Add the unit to the new vial
    //         Add the new vial to the list of vials

    // Return the list of vials
    public static List<Vial> fillVials(List<Integer> coaxiumUnits, int vialMaxCapacity) {
    List<Vial> vials = new ArrayList<>();

    // Sort the coaxiumUnits list in descending order
    Collections.sort(coaxiumUnits, Collections.reverseOrder());

    // Create a new vial with the given vialMaxCapacity
    Vial currentVial = new Vial(vialMaxCapacity);

    // Iterate through each coaxium unit in the sorted list
    for (int unit : coaxiumUnits) {
        // If the current vial has enough remaining capacity to accommodate the unit
        if (currentVial.addUnits(unit)) {
            // Unit added successfully, continue to the next unit
            continue;
        }

        // If the unit couldn't be added to the current vial, create a new vial
        currentVial = new Vial(vialMaxCapacity);
        currentVial.addUnits(unit);
        vials.add(currentVial);
    }

    // Add the last vial to the list if it contains any units
    if (currentVial.getTotalUnits() > 0) {
        vials.add(currentVial);
    }

    // Return the list of vials
    return vials;
}

    public static void main(String[] args) {

        List<Integer> coaxiumUnits = Arrays.asList(4,4,10,1,6,2,2,8,1,4,1,3,3,8,1,5,2,1,2);
        int maxCapacity = 10;

        List<Vial> vials = fillVials(coaxiumUnits,maxCapacity);
        for(int i=0; i < vials.size(); i++) {
            System.out.println("Vial " + (i+1) + ": " + vials.get(i));
        }
    }
}
