package unit06.heaps;

public class Sushi implements Comparable<Sushi> {

    private int number;
    private int weight;
    private int price;

    public Sushi(int number, int weight, int price) {
        this.number = number;
        this.weight = weight;
        this.price = price; 
    }

    public int getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Sushi other) {
        if(this.weight < other.weight) {
          return -1;
        } else if (this.weight > other.weight) {
          return 1;
        } else {
          return 0;
        }
    }

    public String toString() { 
        return "Sushi{" + 
            "number=" + number +
            ", weight=" + weight + " grams" +  
            ", $" + price +  
        "}";
    }

}
