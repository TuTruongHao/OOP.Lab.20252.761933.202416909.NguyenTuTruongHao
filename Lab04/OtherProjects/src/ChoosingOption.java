package Lab01;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class ChoosingOption {

	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		
		JOptionPane.showInternalMessageDialog(null, "you've chosen: " + (option == JOptionPane.YES_OPTION? "YES": "NO"));
		System.exit(0);
	}

}
