package unit11.chevre;

import java.util.Random;

/**
 * A class that will ultimately represent a party Goat out for a night of
 * dancing at the world famous Club Chèvre.
 */
public class Goat extends Thread{
    private final String name ;
    private final int coolness ;
    private final int stamina ;
    private final ClubChevre club ;
    private static final Random RANDOM = new Random();

    public Goat( ClubChevre club){
        name = Utils.makeGoatName();
        coolness = Utils.getRandomNumber(1, 101);
        stamina = Utils.getRandomNumber(5, 10);
        this.club = club;

    }
    @Override
    public void run(){
        synchronized(club){
            System.out.println(name + "getting in the line behind" + club.numberOfGoatsInLine()+ " other goats");
            club.getInLine(this);
        }
        
        try {
            synchronized(this){
                this.wait();
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted!");
        }

    }
    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        Goat goat = new Goat(club);
        Thread goatThread = new Thread(goat);
        goatThread.start();
    }
}
