package Lab01;

import javax.swing.JOptionPane;

public class LinearEquation {

	public static void main(String[] args) {
		double a = Double.parseDouble (JOptionPane.showInputDialog("Nhap a: "));
		double b = Double.parseDouble (JOptionPane.showInputDialog("Nhap b: "));
		
		String result;
		if (a == 0) {
			if (b == 0) result = "Phuong trinh co vo so nghiem!";
			else result = "phuong trinh vo nghiem!";
		}
		
		else {
			result = "Phuong trinh co nghiem: x = " + (-b/a);
		}
		JOptionPane.showInternalMessageDialog(null, result, "ket qua", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
