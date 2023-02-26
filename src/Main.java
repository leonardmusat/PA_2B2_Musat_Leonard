import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void createMatrix(int n, int[][] matrix){
        int count = 1;
        int proCount = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = count;
                count++;
                if(matrix[i][j] > n){
                    matrix[i][j]=matrix[i][j]-n;
                }
            }
            count = proCount;
            proCount++;
        }
    }

    static void displayMatrix(int[][] matrix){
        for (int k = 0; k < matrix.length; k++) { //this equals to the row in our matrix.
            for (int l = 0; l < matrix[k].length; l++) { //this equals to the column in each row.
                System.out.print(matrix[k][l] + " ");
            }
            System.out.println();
        }
    }

    static void displayRows(int[][] matrix){
        List<Integer> listRows = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                listRows.add(matrix[i][j]);
            }

            System.out.println("Row with number " + count + ": " + listRows);
            count++;
            listRows.clear();
        }
    }

    static void displayColums(int[][] matrix){
        int count = 1;
        List<Integer> listColumns = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                listColumns.add(matrix[j][i]);
            }

            System.out.println("Colum with number " + count + ": " + listColumns);
            count++;
            listColumns.clear();
        }
    }


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n:");
        n = scan.nextInt();
        int[][] matrix = new int[n][n];

        if (n > 1000){
            createMatrix(n, matrix);
            displayRows(matrix);
            displayColums(matrix);
            long t2 = System.currentTimeMillis();
            System.out.println("The running time of the application in milliseconds is: " + (t2 - t1));

        }
        else {
            createMatrix(n, matrix);

            displayMatrix(matrix);

            displayRows(matrix);

            displayColums(matrix);
        }

        ////////////////////////////////////////////



    }
}