package unit06.heaps;
import java.util.*;
public class Shop {
    private Set<Sushi> displayCase;
    private Random rand;
    
    public Shop() {
        displayCase = new HashSet<>();
        rand = new Random();
        populateDisplay();
    }

    private void populateDisplay() {
        for(int i=0; i<25; i++) {
            int num = rand.nextInt(100);
            int weight = rand.nextInt(80) + 20;
            int price = rand.nextInt(30) + 10;
            displayCase.add(new Sushi(num, weight, price)); 
        }
    }
    
    public void takeOrder() {
        Set<Integer> orderNums = getRandomOrder(3, 8); 
        Order order = new Order();
        for(Integer num : orderNums) {
            Sushi sushi = getSushiByNumber(num);
            order.addSushi(sushi);
            displayCase.remove(sushi);  
        }
        printOrder(order, orderNums);
        simulateEating(order);
    }

    private Set<Integer> getRandomOrder(int min, int max) {
        Set<Integer> orderNums = new HashSet<>();
        Random rand = new Random();
        int numItems = rand.nextInt(max - min + 1) + min;
        while(orderNums.size() < numItems) {
            int num = rand.nextInt(25);
            orderNums.add(num);
        }
        return orderNums;
    }

    private Sushi getSushiByNumber(Integer number) {
        for(Sushi s : displayCase) {
          if(s.getNumber() == number) {
            return s; 
          }
        } 
        return null;
      }
  
    private void printOrder(Order order, Set<Integer> orderNums) {
        System.out.println("Welcome to Shinji's Sushi Shop!\n"); 
        System.out.print("The cashier takes your order: ");
        for(Integer num : orderNums) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        System.out.println("The cashier prepares your order."); 
        int total = order.getCost();
        for(Sushi s : order.getBag()) {
            total += s.getPrice();
        }
        System.out.println("That will be $" + total + ".\n");
        System.out.println("Here is your order, please come again.\n");
    }
    
    private void simulateEating(Order order) {
        System.out.println("Back at your apartment, you take out your sushi and eat it...");
        PriorityQueue<Sushi> sushiBag = order.getBag();
        while(!sushiBag.isEmpty()) {
            Sushi sushi = sushiBag.poll();
            System.out.println("Eating " + sushi + " ...yum!");
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.takeOrder();  
    }
}