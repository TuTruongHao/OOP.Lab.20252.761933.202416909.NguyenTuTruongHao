package Lab01;

import javax.swing.JOptionPane;

public class QuadraticEquation {

	public static void main(String[] args) {
		double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        String result;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) result = "Vô số nghiệm";
                else result = "Vô nghiệm";
            } else {
                double x = -c / b;
                result = "Phương trình bậc nhất, x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                result = "Phương trình vô nghiệm";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Nghiệm kép x = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "x1 = " + x1 + "\nx2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
	}

}
