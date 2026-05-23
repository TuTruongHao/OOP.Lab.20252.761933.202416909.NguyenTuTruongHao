package Lab01;

import javax.swing.JOptionPane;

public class Ex225 {
	public static void main (String agrs[]) {
		String strNum1 = JOptionPane.showInputDialog("Please input the first number:");
		double num1 = Double.parseDouble(strNum1);
		
		String strNum2 = JOptionPane.showInputDialog("Please input the second number:");
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double diff = num1 - num2;
		double prod = num1 * num2;
		String result;
		
		if (num2 != 0) {
			result = "Sum: " + sum +
					"\nDifference: " + diff +
					"\nPruduct: " + prod +
					"\nQuotient: " + num1 / num2;
		}
		else {
			result = "Sum: " + sum +
					"\nDifference: " + diff +
					"\nPruduct: " + prod +
					"\nCannot divide by zero";
		}
		JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
	}
}
