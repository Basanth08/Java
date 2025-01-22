package unit02.chickens;

import java.util.Random;

public class Chicken {
    private String name;
    private EggColor eggColor;
    private EggSize eggSize;

    public Chicken(String name, EggSize eggSize, EggColor eggColor){
        this.eggSize = eggSize;
        this.eggColor = eggColor;
        this.name = name;

    }   
    
    public ChickenEgg egglay(){
        boolean isCracked = Math.random() < 0.5;
        return new ChickenEgg(eggColor.name(), eggSize , isCracked);
    }

    @Override
    public String toString() {
        return name + ", a chicken that lays " + eggSize + " " + 
               eggColor + " eggs";
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chicken))
            return false;
        Chicken c = (Chicken) o;
        return eggSize == c.eggSize;
    }

    private static final String[] NAMES = {
    "Daisy ", "Chull-bull ", "Henny Penny ", 
    "Coco ", "Buttercup ", "Hazel ",
    "Poppy ", "Olive ", "Rio ", "Choco "};

    public static Chicken generateRandom() {
    
        String name = NAMES[new Random().nextInt(NAMES.length)];
        
        EggSize[] sizes = EggSize.values();
        EggSize size = sizes[new Random().nextInt(sizes.length)];
        
        EggColor[] colors = EggColor.values();
        EggColor color = colors[new Random().nextInt(colors.length)];

        return new Chicken(name, size, color); 
    }
}
