import java.util.Scanner;
import java.util.Random;

public class Matrix {


    private int[][] matrix;

    /**
     * Creates an n-by-n symmetric matrix in which all entries are 0.
     */
    public Matrix(int n) {
        matrix = new int[n][];
        for (int i = 0; i < n; i++)
            matrix[i] = new int[i + 1];
    }

    /**
     * Returns the matrix entry at position (row,col).  (If row < col,
     * the value is actually stored at position (col,row).)
     */

    public int get( int row, int col ) {
        if (row >= col)
            return matrix[row][col];
        else
            return matrix[col][row];
    }

    /**
     * Sets the value of the matrix entry at (row,col).  (If row < col,
     * the value is actually stored at position (col,row).)
     */

    public void set( int row, int col, int value ) {
        if (row >= col)
            matrix[row][col] = value;
        else
            matrix[col][row] = value;
    }



    public class Adventure {

        public static void main(String[] args) {
            char grid[][]= new char[10][10];
            Scanner move = new Scanner(System.in);
            System.out.println("Here is the current game board:");
            System.out.println("-------------------------------");

            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid.length; j++) {
                    double random = Math.random();
                    if(random <=.05) {
                        grid[i][j]='*';
                    }
                    else if(random > .06 && random <= .15) {
                        grid[i][j]='X';
                    }
                    else {
                        grid[i][j]='.';
                    }
                    grid[0][0]='P';
                    grid[9][9]='T';
                    System.out.print(grid[i][j]);
                }
                System.out.println("");
            }
            System.out.print("Enter your move (U/D/L/R)>");
        }
    }


    public int size() {
        return matrix.length;  // The size is the number of rows.
    }

    public static void main(String[] args) {
       Matrix test = new Matrix(6);
       test.set(1,4,55);
        System.out.println(test.get(1,4));
        System.out.println(test.size());

    }
}
