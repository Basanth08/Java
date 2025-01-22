package unit02.chickens;

import java.util.Scanner;

public class ChickenFarm {

    public static void main(String[] args) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.print("Enter number of Chickens: ");
                int numChickens = input.nextInt();
                for(int i = 0; i < numChickens; i++) {
                    Chicken chicken = Chicken.generateRandom();
                    System.out.println(chicken);
                        ChickenEgg egg = chicken.egglay(); 
                        System.out.println("Laid " + egg);
            }
        }       
    }
} 

