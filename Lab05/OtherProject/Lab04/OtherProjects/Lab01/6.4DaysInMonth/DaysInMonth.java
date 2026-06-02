import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int month = 0;
        int year;

        // Nhập tháng
        while (true) {
            System.out.print("Enter month: ");
            String input = keyboard.nextLine().trim();

            month = getMonth(input);

            if (month != -1) break;
            System.out.println("Invalid month, please enter again!");
        }

        // Nhập năm
        while (true) {
            System.out.print("Enter year: ");
            year = keyboard.nextInt();

            if (year >= 0) break;
            System.out.println("Invalid year, please enter again!");
        }

        // Kiểm tra năm nhuận
        boolean isLeap = isLeapYear(year);

        // Xác định số ngày
        int days;

        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                days = 31;
                break;

            case 4: case 6: case 9: case 11:
                days = 30;
                break;

            case 2:
                days = isLeap ? 29 : 28;
                break;

            default:
                days = 0;
        }

        System.out.println("Number of days: " + days);

        keyboard.close();
    }

    // Hàm chuyển tháng về số
    public static int getMonth(String input) {
        input = input.toLowerCase();

        switch (input) {
            case "1": case "jan": case "jan.": case "january": return 1;
            case "2": case "feb": case "feb.": case "february": return 2;
            case "3": case "mar": case "mar.": case "march": return 3;
            case "4": case "apr": case "apr.": case "april": return 4;
            case "5": case "may": return 5;
            case "6": case "jun": case "june": return 6;
            case "7": case "jul": case "july": return 7;
            case "8": case "aug": case "aug.": case "august": return 8;
            case "9": case "sep": case "sept": case "sept.": case "september": return 9;
            case "10": case "oct": case "oct.": case "october": return 10;
            case "11": case "nov": case "nov.": case "november": return 11;
            case "12": case "dec": case "dec.": case "december": return 12;
            default: return -1;
        }
    }

    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}