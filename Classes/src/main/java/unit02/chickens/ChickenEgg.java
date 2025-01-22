package unit02.chickens;
public class ChickenEgg {
    private String color;
    private EggSize size;
    private boolean isCracked;
    private double weight;

public ChickenEgg(String color, EggSize size, boolean isCracked){
    this.color = color;
    this.size = size;
    this.weight = size.getMinOunces();
    this.isCracked = false;
}
public void crack(){
    if (!isCracked){
        isCracked = true;
    }
}

public String toString() {
    String cracked;
    if(isCracked){
        cracked = " Cracked";
    } else {
        cracked = " uncracked";
    }
    return "an " +cracked + " " + size + " (" + weight +" oz ) " + color + " Egg";
}

public boolean equals(Object o) {
    if(!(o instanceof ChickenEgg))
    return false;
    ChickenEgg other = (ChickenEgg) o;
    return color == other.color && size == other.size && isCracked == other.isCracked;
}
}
