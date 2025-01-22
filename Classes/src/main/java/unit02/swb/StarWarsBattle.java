package unit02.swb;

import java.util.Arrays;

public class StarWarsBattle {
    public static void main(String[] args) {
        Weapon blaster = new Weapon("Laser Blaster ",20,"Blue",DamageType.NORMAL);
        System.out.println("Name : " + blaster.getname());
        System.out.println("Damage: " + blaster.getdamageAmount());
        System.out.println("color: " + blaster.getcolor());
        System.out.println("Type: " + blaster.getType());
        System.out.println("Type Color: " + blaster.getType().getcolor());
        Weapon [] swb = {blaster,blaster,blaster,blaster};
        Ship ship = new Ship("M416", 20, 100, swb);
        System.out.println("name: " + ship.getname());
        System.out.println("Hull Amount" + ship.gethullamount());
        // System.out.println("Weapon name:" + ship.armaments[0].name);
        Ship otherShip = new Ship("BBBBB", 10);
        System.out.println("name: " + otherShip.getname());
        System.out.println("Hull amount:" + otherShip.gethullamount());
        System.out.println(ship);
        System.out.println(blaster);
        Weapon blaster1 = new Weapon("Blaster", 20, "Blue", DamageType.NORMAL); 
        Weapon blaster2 = new Weapon("Blaster", 20, "Red", DamageType.NORMAL);
        Weapon shotgun = new Weapon("Shotgun", 45, "Black", DamageType.HEAVY);
        System.out.println(blaster1 == blaster2); // false, different object references
        System.out.println(blaster1.equals(blaster2)); // true, same damage amount and type  
        System.out.println(blaster1.equals(shotgun));
        System.out.println(DamageType.HEAVY.toString()); 
        System.out.println(DamageType.NORMAL.toString());
        System.out.println(DamageType.ION.toString());  
        DamageType heavy = DamageType.valueOf("HEAVY");
        DamageType normal = DamageType.valueOf("NORMAL"); 
        System.out.println(heavy);
        System.out.println(normal); 
        DamageType[] values = DamageType.values();
        System.out.println(Arrays.toString(values));
    }
    
}
