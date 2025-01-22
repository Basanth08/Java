package unit02.swb;

public class Weapon {
    private final String name;
    private final int damageAmount;
    private final String color;
    private  final DamageType type;
    // public int dealDamage;
/**
 * @param name name of the weapon 
 * @param damageAmount amount of damage caused 
 * @param color gives the color
 * @param type damage type of the weapon
 */
    public Weapon(String name, int damageAmount, String color, DamageType type) {
        this.name  = name;
        this.damageAmount = damageAmount;
        this.color = color;
        this.type = type;
    }
    public String getname(){
        return name;
        /*
         * getter for name
         */
    }
    public int getdamageAmount(){
        return damageAmount;
        /*
         * getter for damageAmount
         */
    }

    public DamageType getType(){
        return type;
        /*
         * getter for type
         */
    }
    public String getcolor(){
        return color;
        /*
         * getter for color
         */
    }

    @Override
    public  String toString(){
        return name + " fires " + color + " bolts for " + damageAmount + "damage !";
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Weapon){
            Weapon other = (Weapon)o;
            return damageAmount == other.damageAmount && type == other.type;
        }
        else{
            return false;
        }
    }
    
}


