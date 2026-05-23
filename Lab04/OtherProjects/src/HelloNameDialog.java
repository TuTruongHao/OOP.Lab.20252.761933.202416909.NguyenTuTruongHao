package Lab01;

import javax.swing.JOptionPane;

public class HelloNameDialog {
	public static void main (String agrs[]) {
		String result;
		result = JOptionPane.showInputDialog("Please enter your name: ");
		JOptionPane.showMessageDialog(null, "Hi " + result + "!");
		System.exit(0);
	}
}