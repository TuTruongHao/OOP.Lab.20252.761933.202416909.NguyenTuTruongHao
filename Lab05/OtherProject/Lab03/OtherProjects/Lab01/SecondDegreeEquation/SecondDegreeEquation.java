import javax.swing.JOptionPane;

public class SecondDegreeEquation {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        String result;

        if (a == 0) {
            // Chuyển về phương trình bậc nhất: bx + c = 0
            if (b == 0) {
                if (c == 0) {
                    result = "The equation has infinitely many solutions.";
                } else {
                    result = "The equation has no solution.";
                }
            } else {
                double x = -c / b;
                result = "This is a first-degree equation.\n"
                       + "It has one solution: x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "The equation has two distinct real roots:\n"
                       + "x1 = " + x1 + "\n"
                       + "x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "The equation has a double root:\n"
                       + "x = " + x;
            } else {
                result = "The equation has no real root.";
            }
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}