package Lab01;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println ("Nhập n: ");
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n - i; j++)
				System.out.print(" ");
			for (int j = 1; j <= 2 * i - 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
