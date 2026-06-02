import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Enter first number:");
        String strNum2 = JOptionPane.showInputDialog("Enter second number:");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;

        JOptionPane.showMessageDialog(null, "Sum = " + sum);
    }
}