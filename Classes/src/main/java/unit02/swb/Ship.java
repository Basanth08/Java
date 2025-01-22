package unit02.swb;

public class Ship {
    
    private final String name;
    private final int hull;
    private final int shields;
    private final Weapon[] armaments;
   /**
    * 
    * @param name Its the name
    * @param hull Hull
    * @param Shields Shields
    * @param armaments The weapons
    * 
    */
    
    public Ship(String name, int hull, int Shields,
                Weapon[] armaments){
                this.name = name;
                this.hull = hull;
                this.shields = Shields;
                this.armaments = armaments;
                }
    public Ship(String name, int hull){
        this(name, hull, 0, new Weapon[0] );
    }
    public String getname(){
        return name;
        /*
         * getter for name
         */
    }
    public int gethullamount(){
        return hull;
        /*
         * getter for hull
         */
    }
    public int getshields(){
        return shields;
        /*
         * getter for shields
         */
    }
    public Weapon[] armaments (){
        return armaments;
        /*
         * getter for armaments
         */
    }
    @Override
    public String toString(){
        return name + ": shields " + shields + ", hull " + hull; 
        /*
         * converts to string
         */
    }

}
