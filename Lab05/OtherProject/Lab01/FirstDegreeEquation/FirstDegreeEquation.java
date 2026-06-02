import javax.swing.JOptionPane;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

        String result;

        if (a == 0) {
            if (b == 0) {
                result = "The equation has infinitely many solutions.";
            } else {
                result = "The equation has no solution.";
            }
        } else {
            double x = -b / a;
            result = "The equation has one solution: x = " + x;
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}