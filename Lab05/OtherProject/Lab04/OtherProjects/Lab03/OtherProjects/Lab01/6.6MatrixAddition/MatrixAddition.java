import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = keyboard.nextInt();

        System.out.print("Enter number of columns: ");
        int n = keyboard.nextInt();

        int[][] A = new int[m][n];
        int[][] B = new int[m][n];
        int[][] C = new int[m][n];

        System.out.println("Enter matrix A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("Enter matrix B:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = keyboard.nextInt();
            }
        }

        // Cộng 2 ma trận
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // In kết quả
        System.out.println("Matrix C (A + B):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        keyboard.close();
    }
}