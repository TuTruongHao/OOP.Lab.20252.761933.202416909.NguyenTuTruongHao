package Lab01;

import java.util.Scanner;
import java.util.Arrays;

public class MatrixAddition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println ("Nhập số hàng: ");
		int row = scan.nextInt();
		
		System.out.println ("Nhập số cột: ");
		int col = scan.nextInt();
		
		int[][] A = new int[row][col];
		int[][] B = new int[row][col];
		int[][] C = new int[row][col];
		
		System.out.println ("Nhập ma trận A: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				A[i][j] = scan.nextInt();
			}
		}
		
		System.out.println ("Nhập ma trận B: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				B[i][j] = scan.nextInt();
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		
		System.out.println("\nMa trận kết quả: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }

        scan.close();
	} 

}
