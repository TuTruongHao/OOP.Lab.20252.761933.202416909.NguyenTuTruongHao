import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = keyboard.nextLine();

        System.out.print("How old are you? ");
        int age = keyboard.nextInt();

        System.out.print("How tall are you (in meters)? ");
        double height = keyboard.nextDouble();

        System.out.println("Mr./Ms. " + name + ", " + age + " years old. Your height is " + height + " meters.");

        keyboard.close();
    }
}