package unit02.chickens;

public enum EggSize {

    PEEWEE(1.25),
    SMALL(1.5),
    MEDIUM(1.75),
    LARGE(2.0),
    EXTRA_LARGE(2.25),
    JUMBO(2.5);

    private double minOunces;

    EggSize (double minOunces){
        this.minOunces = minOunces;
    }

    public double getMinOunces(){
        return minOunces;
    }
}
