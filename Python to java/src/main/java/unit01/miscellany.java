package unit01;

import java.util.Arrays;

public class miscellany {
    public static int[] squares(int n){
        int[] squares =new int[n];
        for(int i = 0; i < n ; i++){
            squares[i] = i*i;
        }
        return squares;
    }
    public static int[][] multiplicationtable(int rows , int columns){
        int [][] table = new int [rows] [columns];
        for(int row = 0 ; row<rows ; row++){
            for(int col = 0; col <columns ; col++){
                table[row][col]= (row+1)*(col+1);
            }
        }
        return table;


    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squares(10)));
        int [][]table = multiplicationtable(10, 10);
        for (int row = 0; row<table.length ; row++){
            System.out.println(Arrays.toString(table[row]));
        }

    }
}
