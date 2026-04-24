import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAverage {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = keyboard.nextInt();

        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = keyboard.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        double average = (double) sum / n;

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        keyboard.close();
    }
}