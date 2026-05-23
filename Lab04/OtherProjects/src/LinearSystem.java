package Lab01;

import javax.swing.JOptionPane;

public class LinearSystem {

	public static void main(String[] args) {
		double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D  = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        String result;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                result = "Hệ có vô số nghiệm";
            } else {
                result = "Hệ vô nghiệm";
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            result = "x1 = " + x1 + "\nx2 = " + x2;
        }

        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
	}

}
