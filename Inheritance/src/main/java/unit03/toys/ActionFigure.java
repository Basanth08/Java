package unit03.toys;

public class ActionFigure extends toys {

    private final String hairColor;
    private final String eyeColor; 
    private final String[] sayings;
    private boolean hasKungFuGrip;
    private int numPlays;
    
    public ActionFigure(String hairColor, String eyeColor, String[] sayings, 
                        boolean hasKungFuGrip, double msrp) {
                        
        super("Action Figure", msrp);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.sayings = sayings; 
        this.hasKungFuGrip = hasKungFuGrip;
    }
    @Override
    public String toString() {
        return hairColor + eyeColor;
    }

    
    public void play() {
        if (numPlays < 10) {
            System.out.println("Plays saying: " + sayings[(int)(Math.random() * sayings.length)]);
            if (hasKungFuGrip) {
                System.out.println("Also brandishes sword! Hiya!"); 
            }
            numPlays++;
        } else {
            System.out.println("Cannot play, action figure broken!");
        }
    }
}
