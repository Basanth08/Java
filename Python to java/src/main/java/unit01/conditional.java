package unit01;

public class conditional {
    public static void evenlydivisibe(int n) {
        if(n%2==0){
            System.out.println("The number is even");
        }
        else if(n%3==0){
            System.out.println("The number is divisible by 3.");
        }
        else if(n%5==0){
            System.out.println("The number is divisible by 5.");
        }
        else{
            System.out.println("The number is odd and is divisible by 3 or 5.");
        }
    }
    public static void main(String[] args) {
        evenlydivisibe(4);
        evenlydivisibe(7);
        evenlydivisibe(9);
        evenlydivisibe(5);
        
    }
}
