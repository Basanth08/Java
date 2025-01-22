package unit11.ggg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyGreedyGoats {
    public static void main(String[] args) throws InterruptedException {
        Trough trough = new Trough(250);

        TurnipDropper turnipDropper = new TurnipDropper(trough);
        Thread turnipDropperThread = new Thread(turnipDropper);
        turnipDropperThread.start();

        List<Goat> goats = new ArrayList<>();
        List<Thread> goatThreads = new ArrayList<>();
        for (Color color : Color.values()) {
            Goat goat = new Goat(color, trough);
            Thread thread = new Thread(goat);
            goats.add(goat);
            goatThreads.add(thread);
            thread.start();
        }

        turnipDropperThread.join();
        for (Thread thread : goatThreads) {
            thread.join();
        }

        System.out.println("The game is over! A total of " + trough.getTurnipsSoFar() + " turnips were dropped into the trough!");

        goats.sort(new Comparator<Goat>() {
            @Override
            public int compare(Goat goat1, Goat goat2) {
                return Integer.compare(goat2.getTurnipsEaten(), goat1.getTurnipsEaten());
            }
        });
        
        for (Goat goat : goats) {
            System.out.println(goat + " ate " + goat.getTurnipsEaten() + " turnips!");
        }

        int totalTurnipsConsumed = 0;
        for (Goat goat : goats) {
            totalTurnipsConsumed += goat.getTurnipsEaten();
        }
        System.out.println("Together, the goats ate " + totalTurnipsConsumed + " turnips!");
    }
}