package unit11.chevre;

public class Main  {
    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        TrollBouncer troll = new TrollBouncer(club);
        troll.start();
        for (int i = 0 ; i<1000; i++){
            new Goat(club).start();

        }
        System.out.println(club.numberOfGoatsInLine() + " goats lined up!");
    }
    
}
