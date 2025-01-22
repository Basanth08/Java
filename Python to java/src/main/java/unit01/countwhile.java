package unit01;

public class countwhile {
    private static final int sum = 0;
    public static int countwhile (int n) {
        // int i = 0;
        // int sum = 0;
        int count = 0;
        int sum = 0;
        while(count < n){
            System.out.println(count);
            sum += count;
           count ++;
        }
        return sum;
    }
    public static int countfor(int n) {

        for(int sum = 0, count = 0; count< n; count++){
            System.out.println(count);
            sum+=count;
        }
        return sum;
        
    }
     public static void main(String[] args) {
        int result1 = countwhile(5); 
        System.out.println("Sum using while: " + result1);
        int result2 = countfor(9); 
        System.out.println("Sum using for: " + result2);
     }
}
