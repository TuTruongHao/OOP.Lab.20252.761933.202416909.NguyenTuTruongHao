
import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
	public static void main(String[] args) {
		
		String strNum1 = JOptionPane.showInputDialog("Enter first number: ");
		double num1 = Double.parseDouble(strNum1);
		String strNum2 = JOptionPane.showInputDialog("Enter second number: ");
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double difference = num1 - num2;
		double product = num1 * num2;
		
		String quotient;
		if (num2 != 0) {
			quotient = String.valueOf(num1 / num2);
		}else {
			quotient = "Cannot divide by 0";
		}
		
		String results = "Sum: " + sum + 
				"\nDifference: " + difference +
				"\nProduct: " + product + 
				"\nQuotient: " + quotient;
		
		JOptionPane.showMessageDialog(null, results);
		
		System.exit(0);
	}
}
