package Lab01;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayProcessing {
	public static void main (String agrs[]) {
		Scanner scan = new Scanner (System.in);
		System.out.println ("Nhập số phần tử của mảng: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		
		System.out.println ("Nhập các phần tử ủa mảng: ");
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();	
		}
		
		Arrays.sort(arr);
		System.out.println ("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
		
		int sum = 0;
		for (int x :arr) {
			sum += x;
		}
		
		double avg = (double) sum / n;
		System.out.println("Tổng = " + sum);
        System.out.println("Trung bình = " + avg);

        scan.close();
	}
}
